package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.roomsdk.model.b.e;
import com.tencent.mm.roomsdk.model.factory.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String chatroomName;
  private cc hTm;
  private a lBi;
  private LinkedList<String> lBj;
  private List<String> lBk;
  private int lBl;
  private int lBm;
  private boolean lBn;
  private com.tencent.mm.roomsdk.model.factory.a lBo;
  private ProgressDialog lBp;
  private aj lzy;
  private ListView mListView;
  private int scene;
  private w tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.lBj = new LinkedList();
    this.lBk = new ArrayList();
    this.lBn = false;
    this.lBo = null;
    this.lBp = null;
    AppMethodBeat.o(12641);
  }
  
  public static d a(String paramString1, cc paramcc, int paramInt, String paramString2, e parame)
  {
    AppMethodBeat.i(241643);
    if (paramcc == null)
    {
      Log.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
      AppMethodBeat.o(241643);
      return null;
    }
    czz localczz = new czz();
    localczz.Njv = paramcc.field_msgSvrId;
    localczz.aaFu = Long.parseLong(paramcc.field_historyId);
    localczz.oPp = paramString1;
    localczz.aasS = paramInt;
    if (paramInt == 2) {
      localczz.UserName = paramString2;
    }
    localczz.YHk = x.z(z.bAM(), paramcc.getCreateTime());
    paramString1 = new d();
    paramString1.a(new k.a(221, localczz));
    paramString1.d(parame).blj();
    AppMethodBeat.o(241643);
    return paramString1;
  }
  
  public int getLayoutId()
  {
    return a.f.lGb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12645);
    setMMTitle(a.i.lIk);
    this.mListView = ((ListView)findViewById(a.e.lFe));
    this.lBi = new a();
    a locala = this.lBi;
    Object localObject = this.lBj;
    if (localObject != null)
    {
      Log.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.lBw.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
        if ((localau != null) && (!Util.isNullOrNil(localau.field_username)) && (localau.field_username.equals(str))) {
          locala.lBw.add(localau);
        }
      }
    }
    this.mListView.setAdapter(this.lBi);
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
    this.lBl = getIntent().getIntExtra("local_scene", 0);
    this.lBm = getIntent().getIntExtra("select_record_report_opt", 0);
    this.lBn = getIntent().getBooleanExtra("revoke_record", false);
    if (this.lBl == 1)
    {
      long l = getIntent().getLongExtra("msg_id", -1L);
      this.hTm = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
    }
    paramBundle = getIntent().getStringExtra("members");
    this.lBk = Util.stringToList(getIntent().getStringExtra("origin_members"), ",");
    paramBundle = paramBundle.split(",");
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.lBj.add(localObject);
      i += 1;
    }
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.chatroomName);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
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
    List<au> lBw;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.lBw = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(au paramau)
    {
      AppMethodBeat.i(12640);
      if (!Util.isNullOrNil(paramau.field_conRemark)) {}
      for (Object localObject2 = paramau.field_conRemark;; localObject2 = DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramau.field_username))
      {
        Object localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = paramau.field_conRemark;
        }
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject2 = paramau.aSU();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.lBw.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.lBw.get(paramInt);
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
        paramView = View.inflate(DelChatroomMemberUI.this, a.f.lGa, null);
        paramViewGroup = new DelChatroomMemberUI.b(DelChatroomMemberUI.this);
        paramViewGroup.lBC = ((ImageView)paramView.findViewById(a.e.lEr));
        paramViewGroup.lBD = ((TextView)paramView.findViewById(a.e.lEs));
        paramViewGroup.lBE = ((TextView)paramView.findViewById(a.e.lEq));
        paramViewGroup.lBE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            final au localau = (au)DelChatroomMemberUI.a.this.getItem(i);
            if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
            {
              paramAnonymousView = DelChatroomMemberUI.this.getString(a.i.gTy, new Object[] { DelChatroomMemberUI.a.this.b(localau) });
              if (!DelChatroomMemberUI.f(DelChatroomMemberUI.this)) {
                break label229;
              }
            }
            label229:
            for (localObject = DelChatroomMemberUI.this.getString(a.i.gTG);; localObject = DelChatroomMemberUI.this.getString(a.i.gTF))
            {
              k.a(DelChatroomMemberUI.this, paramAnonymousView, null, (String)localObject, DelChatroomMemberUI.this.getString(a.i.app_cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(12634);
                  if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
                  {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, null);
                    paramAnonymous2DialogInterface = DelChatroomMemberUI.a(DelChatroomMemberUI.g(DelChatroomMemberUI.this), DelChatroomMemberUI.b(DelChatroomMemberUI.this), 2, localau.field_username, new e() {});
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12634);
                    return;
                  }
                  DelChatroomMemberUI.a(DelChatroomMemberUI.this, localau.field_username, false);
                  AppMethodBeat.o(12634);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(241519);
                  if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.a.this.getCount(), 1, 1, localau.field_username);
                  }
                  AppMethodBeat.o(241519);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12635);
              return;
              paramAnonymousView = DelChatroomMemberUI.this.getString(a.i.gTx, new Object[] { DelChatroomMemberUI.a.this.b(localau) });
              break;
            }
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.lBE.setTag(Integer.valueOf(paramInt));
        au localau = (au)getItem(paramInt);
        String str = b(localau);
        paramViewGroup.lBD.setText(str);
        com.tencent.mm.pluginsdk.ui.span.p.b(DelChatroomMemberUI.this, str, paramViewGroup.lBD.getTextSize());
        a.b.g(paramViewGroup.lBC, localau.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView lBC;
    public TextView lBD;
    public TextView lBE;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */