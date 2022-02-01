package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String chatroomName;
  private ca dTX;
  private ah gtd;
  private a gvb;
  private LinkedList<String> gvc;
  private List<String> gvd;
  private int gve;
  private int gvf;
  private boolean gvg;
  private com.tencent.mm.roomsdk.a.c.a gvh;
  private ProgressDialog gvi;
  private ListView mListView;
  private int scene;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.gvc = new LinkedList();
    this.gvd = new ArrayList();
    this.gvg = false;
    this.gvh = null;
    this.gvi = null;
    AppMethodBeat.o(12641);
  }
  
  public static d a(String paramString1, ca paramca, int paramInt, String paramString2, e parame)
  {
    AppMethodBeat.i(194121);
    if (paramca == null)
    {
      Log.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
      AppMethodBeat.o(194121);
      return null;
    }
    cbq localcbq = new cbq();
    localcbq.Brn = paramca.field_msgSvrId;
    localcbq.Mhx = Long.parseLong(paramca.field_historyId);
    localcbq.jfM = paramString1;
    localcbq.LWr = paramInt;
    if (paramInt == 2) {
      localcbq.UserName = paramString2;
    }
    localcbq.KIz = x.x(z.aTY(), paramca.field_createTime);
    paramString1 = new d();
    paramString1.a(new k.a(221, localcbq));
    paramString1.d(parame).aJu();
    AppMethodBeat.o(194121);
    return paramString1;
  }
  
  public int getLayoutId()
  {
    return 2131493467;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12645);
    setMMTitle(2131764692);
    this.mListView = ((ListView)findViewById(2131304601));
    this.gvb = new a();
    a locala = this.gvb;
    Object localObject = this.gvc;
    if (localObject != null)
    {
      Log.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.gvp.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if ((localas != null) && (!Util.isNullOrNil(localas.field_username)) && (localas.field_username.equals(str))) {
          locala.gvp.add(localas);
        }
      }
    }
    this.mListView.setAdapter(this.gvb);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12629);
        if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
          DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.e(DelChatroomMemberUI.this).getCount(), 0, 1, "");
        }
        DelChatroomMemberUI.this.finish();
        AppMethodBeat.o(12629);
        return true;
      }
    });
    AppMethodBeat.o(12645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12642);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    this.scene = getIntent().getIntExtra("scene", 0);
    this.gve = getIntent().getIntExtra("local_scene", 0);
    this.gvf = getIntent().getIntExtra("select_record_report_opt", 0);
    this.gvg = getIntent().getBooleanExtra("revoke_record", false);
    if (this.gve == 1)
    {
      long l = getIntent().getLongExtra("msg_id", -1L);
      this.dTX = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(l);
    }
    paramBundle = getIntent().getStringExtra("members");
    this.gvd = Util.stringToList(getIntent().getStringExtra("origin_members"), ",");
    paramBundle = paramBundle.split(",");
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.gvc.add(localObject);
      i += 1;
    }
    this.gtd = ((c)g.af(c.class)).aSX().Kd(this.chatroomName);
    initView();
    AppMethodBeat.o(12642);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12643);
    super.onDestroy();
    AppMethodBeat.o(12643);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12644);
    super.onResume();
    AppMethodBeat.o(12644);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(12646);
    Log.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(12646);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    List<as> gvp;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.gvp = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(as paramas)
    {
      AppMethodBeat.i(12640);
      if (!Util.isNullOrNil(paramas.field_conRemark)) {}
      for (Object localObject2 = paramas.field_conRemark;; localObject2 = DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramas.field_username))
      {
        Object localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = paramas.field_conRemark;
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = paramas.arI();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.gvp.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.gvp.get(paramInt);
      AppMethodBeat.o(12638);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12639);
      if (paramView == null)
      {
        paramView = View.inflate(DelChatroomMemberUI.this, 2131493466, null);
        paramViewGroup = new DelChatroomMemberUI.b(DelChatroomMemberUI.this);
        paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131298299));
        paramViewGroup.gvw = ((TextView)paramView.findViewById(2131298300));
        paramViewGroup.gvx = ((TextView)paramView.findViewById(2131298298));
        paramViewGroup.gvx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            final as localas = (as)DelChatroomMemberUI.a.this.getItem(i);
            if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
            {
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131764680, new Object[] { DelChatroomMemberUI.a.this.b(localas) });
              if (!DelChatroomMemberUI.f(DelChatroomMemberUI.this)) {
                break label225;
              }
            }
            label225:
            for (localObject = DelChatroomMemberUI.this.getString(2131764689);; localObject = DelChatroomMemberUI.this.getString(2131764688))
            {
              h.a(DelChatroomMemberUI.this, paramAnonymousView, null, (String)localObject, DelChatroomMemberUI.this.getString(2131755761), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(12634);
                  if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
                  {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, null);
                    paramAnonymous2DialogInterface = DelChatroomMemberUI.a(DelChatroomMemberUI.g(DelChatroomMemberUI.this), DelChatroomMemberUI.b(DelChatroomMemberUI.this), 2, localas.field_username, new e() {});
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12634);
                    return;
                  }
                  DelChatroomMemberUI.a(DelChatroomMemberUI.this, localas.field_username, false);
                  AppMethodBeat.o(12634);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(194120);
                  if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.a.this.getCount(), 1, 1, localas.field_username);
                  }
                  AppMethodBeat.o(194120);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12635);
              return;
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131764679, new Object[] { DelChatroomMemberUI.a.this.b(localas) });
              break;
            }
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.gvx.setTag(Integer.valueOf(paramInt));
        as localas = (as)getItem(paramInt);
        String str = b(localas);
        paramViewGroup.gvw.setText(str);
        com.tencent.mm.pluginsdk.ui.span.l.b(DelChatroomMemberUI.this, str, paramViewGroup.gvw.getTextSize());
        a.b.c(paramViewGroup.gvv, localas.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView gvv;
    public TextView gvw;
    public TextView gvx;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */