package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private String chatroomName;
  private ca fNz;
  private ah iXp;
  private a iZm;
  private LinkedList<String> iZn;
  private List<String> iZo;
  private int iZp;
  private int iZq;
  private boolean iZr;
  private com.tencent.mm.roomsdk.a.c.a iZs;
  private ProgressDialog iZt;
  private ListView mListView;
  private int scene;
  private s tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.iZn = new LinkedList();
    this.iZo = new ArrayList();
    this.iZr = false;
    this.iZs = null;
    this.iZt = null;
    AppMethodBeat.o(12641);
  }
  
  public static d a(String paramString1, ca paramca, int paramInt, String paramString2, e parame)
  {
    AppMethodBeat.i(186247);
    if (paramca == null)
    {
      Log.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
      AppMethodBeat.o(186247);
      return null;
    }
    cjt localcjt = new cjt();
    localcjt.HlH = paramca.field_msgSvrId;
    localcjt.Trk = Long.parseLong(paramca.field_historyId);
    localcjt.lWn = paramString1;
    localcjt.Tfy = paramInt;
    if (paramInt == 2) {
      localcjt.UserName = paramString2;
    }
    localcjt.RJQ = x.u(z.bcZ(), paramca.field_createTime);
    paramString1 = new d();
    paramString1.a(new k.a(221, localcjt));
    paramString1.d(parame).aRu();
    AppMethodBeat.o(186247);
    return paramString1;
  }
  
  public int getLayoutId()
  {
    return a.f.jdT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12645);
    setMMTitle(a.i.jfX);
    this.mListView = ((ListView)findViewById(a.e.jcW));
    this.iZm = new a();
    a locala = this.iZm;
    Object localObject = this.iZn;
    if (localObject != null)
    {
      Log.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.iZA.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
        if ((localas != null) && (!Util.isNullOrNil(localas.field_username)) && (localas.field_username.equals(str))) {
          locala.iZA.add(localas);
        }
      }
    }
    this.mListView.setAdapter(this.iZm);
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
    this.iZp = getIntent().getIntExtra("local_scene", 0);
    this.iZq = getIntent().getIntExtra("select_record_report_opt", 0);
    this.iZr = getIntent().getBooleanExtra("revoke_record", false);
    if (this.iZp == 1)
    {
      long l = getIntent().getLongExtra("msg_id", -1L);
      this.fNz = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
    }
    paramBundle = getIntent().getStringExtra("members");
    this.iZo = Util.stringToList(getIntent().getStringExtra("origin_members"), ",");
    paramBundle = paramBundle.split(",");
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.iZn.add(localObject);
      i += 1;
    }
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.chatroomName);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
    List<as> iZA;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.iZA = new LinkedList();
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
          localObject2 = paramas.ayr();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.iZA.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.iZA.get(paramInt);
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
        paramView = View.inflate(DelChatroomMemberUI.this, a.f.jdS, null);
        paramViewGroup = new DelChatroomMemberUI.b(DelChatroomMemberUI.this);
        paramViewGroup.iZG = ((ImageView)paramView.findViewById(a.e.jcr));
        paramViewGroup.iZH = ((TextView)paramView.findViewById(a.e.jcs));
        paramViewGroup.iZI = ((TextView)paramView.findViewById(a.e.jcq));
        paramViewGroup.iZI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            final as localas = (as)DelChatroomMemberUI.a.this.getItem(i);
            if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
            {
              paramAnonymousView = DelChatroomMemberUI.this.getString(a.i.eQS, new Object[] { DelChatroomMemberUI.a.this.b(localas) });
              if (!DelChatroomMemberUI.f(DelChatroomMemberUI.this)) {
                break label229;
              }
            }
            label229:
            for (localObject = DelChatroomMemberUI.this.getString(a.i.eRa);; localObject = DelChatroomMemberUI.this.getString(a.i.eQZ))
            {
              com.tencent.mm.ui.base.h.a(DelChatroomMemberUI.this, paramAnonymousView, null, (String)localObject, DelChatroomMemberUI.this.getString(a.i.app_cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
                  AppMethodBeat.i(187977);
                  if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.a.this.getCount(), 1, 1, localas.field_username);
                  }
                  AppMethodBeat.o(187977);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12635);
              return;
              paramAnonymousView = DelChatroomMemberUI.this.getString(a.i.eQR, new Object[] { DelChatroomMemberUI.a.this.b(localas) });
              break;
            }
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.iZI.setTag(Integer.valueOf(paramInt));
        as localas = (as)getItem(paramInt);
        String str = b(localas);
        paramViewGroup.iZH.setText(str);
        l.b(DelChatroomMemberUI.this, str, paramViewGroup.iZH.getTextSize());
        a.b.c(paramViewGroup.iZG, localas.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView iZG;
    public TextView iZH;
    public TextView iZI;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */