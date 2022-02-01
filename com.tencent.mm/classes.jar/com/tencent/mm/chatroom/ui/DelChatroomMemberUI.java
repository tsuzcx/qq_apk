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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI
  extends MMActivity
  implements f
{
  private String chatroomName;
  private bu dBd;
  private ab fLO;
  private a fNK;
  private LinkedList<String> fNL;
  private List<String> fNM;
  private int fNN;
  private int fNO;
  private boolean fNP;
  private com.tencent.mm.roomsdk.a.c.a fNQ;
  private ProgressDialog fNR;
  private ListView mListView;
  private int scene;
  private p tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.fNL = new LinkedList();
    this.fNM = new ArrayList();
    this.fNP = false;
    this.fNQ = null;
    this.fNR = null;
    AppMethodBeat.o(12641);
  }
  
  public static d a(String paramString1, bu parambu, int paramInt, String paramString2, e parame)
  {
    AppMethodBeat.i(213490);
    if (parambu == null)
    {
      ad.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
      AppMethodBeat.o(213490);
      return null;
    }
    bog localbog = new bog();
    localbog.xbt = parambu.field_msgSvrId;
    localbog.GIT = Long.parseLong(parambu.field_historyId);
    localbog.ihU = paramString1;
    localbog.GyM = paramInt;
    if (paramInt == 2) {
      localbog.nDo = paramString2;
    }
    localbog.Fwt = s.w(u.aAm(), parambu.field_createTime);
    paramString1 = new d();
    paramString1.e(new k.a(221, localbog));
    paramString1.d(parame).cyR();
    AppMethodBeat.o(213490);
    return paramString1;
  }
  
  public int getLayoutId()
  {
    return 2131493375;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12645);
    setMMTitle(2131762610);
    this.mListView = ((ListView)findViewById(2131302235));
    this.fNK = new a();
    a locala = this.fNK;
    Object localObject = this.fNL;
    if (localObject != null)
    {
      ad.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.fNZ.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        am localam = ((l)g.ab(l.class)).azp().Bf(str);
        if ((localam != null) && (!bt.isNullOrNil(localam.field_username)) && (localam.field_username.equals(str))) {
          locala.fNZ.add(localam);
        }
      }
    }
    this.mListView.setAdapter(this.fNK);
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
    this.fNN = getIntent().getIntExtra("local_scene", 0);
    this.fNO = getIntent().getIntExtra("select_record_report_opt", 0);
    this.fNP = getIntent().getBooleanExtra("revoke_record", false);
    if (this.fNN == 1)
    {
      long l = getIntent().getLongExtra("msg_id", -1L);
      this.dBd = ((l)g.ab(l.class)).dlK().xY(l);
    }
    paramBundle = getIntent().getStringExtra("members");
    this.fNM = bt.lO(getIntent().getStringExtra("origin_members"), ",");
    paramBundle = paramBundle.split(",");
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.fNL.add(localObject);
      i += 1;
    }
    this.fLO = ((c)g.ab(c.class)).azz().AN(this.chatroomName);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12646);
    ad.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
    List<am> fNZ;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.fNZ = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(am paramam)
    {
      AppMethodBeat.i(12640);
      if (!bt.isNullOrNil(paramam.field_conRemark)) {}
      for (Object localObject2 = paramam.field_conRemark;; localObject2 = DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramam.field_username))
      {
        Object localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = paramam.field_conRemark;
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = paramam.adu();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.fNZ.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.fNZ.get(paramInt);
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
        paramView = View.inflate(DelChatroomMemberUI.this, 2131493374, null);
        paramViewGroup = new DelChatroomMemberUI.b(DelChatroomMemberUI.this);
        paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297963));
        paramViewGroup.fOg = ((TextView)paramView.findViewById(2131297964));
        paramViewGroup.fOh = ((TextView)paramView.findViewById(2131297962));
        paramViewGroup.fOh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            final am localam = (am)DelChatroomMemberUI.a.this.getItem(i);
            if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
            {
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131767136, new Object[] { DelChatroomMemberUI.a.this.b(localam) });
              if (!DelChatroomMemberUI.f(DelChatroomMemberUI.this)) {
                break label225;
              }
            }
            label225:
            for (localObject = DelChatroomMemberUI.this.getString(2131767137);; localObject = DelChatroomMemberUI.this.getString(2131762607))
            {
              h.a(DelChatroomMemberUI.this, paramAnonymousView, null, (String)localObject, DelChatroomMemberUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(12634);
                  if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
                  {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, null);
                    paramAnonymous2DialogInterface = DelChatroomMemberUI.a(DelChatroomMemberUI.g(DelChatroomMemberUI.this), DelChatroomMemberUI.b(DelChatroomMemberUI.this), 2, localam.field_username, new e() {});
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12634);
                    return;
                  }
                  DelChatroomMemberUI.a(DelChatroomMemberUI.this, localam.field_username, false);
                  AppMethodBeat.o(12634);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(213489);
                  if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.a.this.getCount(), 1, 1, localam.field_username);
                  }
                  AppMethodBeat.o(213489);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12635);
              return;
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131762599, new Object[] { DelChatroomMemberUI.a.this.b(localam) });
              break;
            }
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.fOh.setTag(Integer.valueOf(paramInt));
        am localam = (am)getItem(paramInt);
        String str = b(localam);
        paramViewGroup.fOg.setText(str);
        k.b(DelChatroomMemberUI.this, str, paramViewGroup.fOg.getTextSize());
        a.b.c(paramViewGroup.fOf, localam.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView fOh;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */