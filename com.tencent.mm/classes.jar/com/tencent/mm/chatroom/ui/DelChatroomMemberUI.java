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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
  private bv dCi;
  private ac fNS;
  private a fPR;
  private LinkedList<String> fPS;
  private List<String> fPT;
  private int fPU;
  private int fPV;
  private boolean fPW;
  private com.tencent.mm.roomsdk.a.c.a fPX;
  private ProgressDialog fPY;
  private ListView mListView;
  private int scene;
  private p tipDialog;
  
  public DelChatroomMemberUI()
  {
    AppMethodBeat.i(12641);
    this.fPS = new LinkedList();
    this.fPT = new ArrayList();
    this.fPW = false;
    this.fPX = null;
    this.fPY = null;
    AppMethodBeat.o(12641);
  }
  
  public static d a(String paramString1, bv parambv, int paramInt, String paramString2, e parame)
  {
    AppMethodBeat.i(217207);
    if (parambv == null)
    {
      ae.e("MicroMsg.DelChatroomMemberUI", "revokeRecord msgInfo is null");
      AppMethodBeat.o(217207);
      return null;
    }
    boy localboy = new boy();
    localboy.xrk = parambv.field_msgSvrId;
    localboy.Hcu = Long.parseLong(parambv.field_historyId);
    localboy.ikN = paramString1;
    localboy.GSm = paramInt;
    if (paramInt == 2) {
      localboy.nIJ = paramString2;
    }
    localboy.FOR = t.w(v.aAC(), parambv.field_createTime);
    paramString1 = new d();
    paramString1.a(new k.a(221, localboy));
    paramString1.d(parame).cAs();
    AppMethodBeat.o(217207);
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
    this.fPR = new a();
    a locala = this.fPR;
    Object localObject = this.fPS;
    if (localObject != null)
    {
      ae.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      locala.fQf.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        an localan = ((l)g.ab(l.class)).azF().BH(str);
        if ((localan != null) && (!bu.isNullOrNil(localan.field_username)) && (localan.field_username.equals(str))) {
          locala.fQf.add(localan);
        }
      }
    }
    this.mListView.setAdapter(this.fPR);
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
    this.fPU = getIntent().getIntExtra("local_scene", 0);
    this.fPV = getIntent().getIntExtra("select_record_report_opt", 0);
    this.fPW = getIntent().getBooleanExtra("revoke_record", false);
    if (this.fPU == 1)
    {
      long l = getIntent().getLongExtra("msg_id", -1L);
      this.dCi = ((l)g.ab(l.class)).doJ().ys(l);
    }
    paramBundle = getIntent().getStringExtra("members");
    this.fPT = bu.lV(getIntent().getStringExtra("origin_members"), ",");
    paramBundle = paramBundle.split(",");
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      this.fPS.add(localObject);
      i += 1;
    }
    this.fNS = ((c)g.ab(c.class)).azP().Bx(this.chatroomName);
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
    ae.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
    List<an> fQf;
    
    a()
    {
      AppMethodBeat.i(12636);
      this.fQf = new LinkedList();
      AppMethodBeat.o(12636);
    }
    
    public final String b(an paraman)
    {
      AppMethodBeat.i(12640);
      if (!bu.isNullOrNil(paraman.field_conRemark)) {}
      for (Object localObject2 = paraman.field_conRemark;; localObject2 = DelChatroomMemberUI.a(DelChatroomMemberUI.this, paraman.field_username))
      {
        Object localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2)) {
          localObject1 = paraman.field_conRemark;
        }
        localObject2 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject2 = paraman.adF();
        }
        AppMethodBeat.o(12640);
        return localObject2;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12637);
      int i = this.fQf.size();
      AppMethodBeat.o(12637);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12638);
      Object localObject = this.fQf.get(paramInt);
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
        paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297963));
        paramViewGroup.fQm = ((TextView)paramView.findViewById(2131297964));
        paramViewGroup.fQn = ((TextView)paramView.findViewById(2131297962));
        paramViewGroup.fQn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12635);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            final an localan = (an)DelChatroomMemberUI.a.this.getItem(i);
            if (DelChatroomMemberUI.f(DelChatroomMemberUI.this))
            {
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131767136, new Object[] { DelChatroomMemberUI.a.this.b(localan) });
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
                    paramAnonymous2DialogInterface = DelChatroomMemberUI.a(DelChatroomMemberUI.g(DelChatroomMemberUI.this), DelChatroomMemberUI.b(DelChatroomMemberUI.this), 2, localan.field_username, new e() {});
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12634);
                    return;
                  }
                  DelChatroomMemberUI.a(DelChatroomMemberUI.this, localan.field_username, false);
                  AppMethodBeat.o(12634);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(217206);
                  if (DelChatroomMemberUI.a(DelChatroomMemberUI.this) == 1) {
                    DelChatroomMemberUI.a(DelChatroomMemberUI.this, DelChatroomMemberUI.b(DelChatroomMemberUI.this), DelChatroomMemberUI.c(DelChatroomMemberUI.this), DelChatroomMemberUI.d(DelChatroomMemberUI.this), DelChatroomMemberUI.a.this.getCount(), 1, 1, localan.field_username);
                  }
                  AppMethodBeat.o(217206);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DelChatroomMemberUI$DelChatroomMemberAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12635);
              return;
              paramAnonymousView = DelChatroomMemberUI.this.getString(2131762599, new Object[] { DelChatroomMemberUI.a.this.b(localan) });
              break;
            }
          }
        });
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.fQn.setTag(Integer.valueOf(paramInt));
        an localan = (an)getItem(paramInt);
        String str = b(localan);
        paramViewGroup.fQm.setText(str);
        k.b(DelChatroomMemberUI.this, str, paramViewGroup.fQm.getTextSize());
        a.b.c(paramViewGroup.fQl, localan.field_username);
        AppMethodBeat.o(12639);
        return paramView;
        paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
      }
    }
  }
  
  final class b
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView fQn;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI
 * JD-Core Version:    0.7.0.1
 */