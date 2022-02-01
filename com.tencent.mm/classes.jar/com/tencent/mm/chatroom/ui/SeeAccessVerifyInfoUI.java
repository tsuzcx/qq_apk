package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private x ftP;
  private String fwd;
  private b fyB;
  private String fyC;
  private String fyD;
  private String fyE;
  private String fyF;
  private String fyG;
  private String fyH;
  private String fyI;
  private String fyJ;
  private String fyK;
  private long fyL;
  private long fyM;
  private String fyN;
  private String fyO;
  private TextView fyP;
  private TextView fyQ;
  private ImageView fyR;
  private TextView fyS;
  private TextView fyT;
  private TextView fyU;
  private GridView fyV;
  private boolean fyW = false;
  private boolean fyX = false;
  private boolean fyY = false;
  private p tipDialog;
  
  protected final c ct(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.fuY = ((ImageView)paramView.findViewById(2131304237));
    localc.fzg = ((TextView)paramView.findViewById(2131304234));
    localc.fzh = ((TextView)paramView.findViewById(2131304236));
    AppMethodBeat.o(12821);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2131495334;
  }
  
  public void initView()
  {
    Object localObject1 = null;
    AppMethodBeat.i(12819);
    this.fyP = ((TextView)findViewById(2131301072));
    this.fyQ = ((TextView)findViewById(2131301071));
    this.fyS = ((TextView)findViewById(2131304234));
    this.fyT = ((TextView)findViewById(2131304236));
    this.fyR = ((ImageView)findViewById(2131304237));
    this.fyU = ((TextView)findViewById(2131296325));
    this.fyV = ((GridView)findViewById(2131297195));
    this.fyV.setAdapter(this.fyB);
    if (this.fyR != null) {
      this.fyR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(bs.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localai.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).wk(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          Object localObject = paramAnonymousView;
          if (bs.isNullOrNil(paramAnonymousView)) {
            localObject = localai.aaS();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          AppMethodBeat.o(12805);
        }
      });
    }
    this.fyV.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.fyV.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12806);
        int i = 0;
        if (SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this) != null) {
          if (!SeeAccessVerifyInfoUI.d(SeeAccessVerifyInfoUI.this)) {
            break label138;
          }
        }
        label138:
        for (i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() * 2 + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165191) + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165508));; i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165191) + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165508)))
        {
          int j = i;
          if (SeeAccessVerifyInfoUI.e(SeeAccessVerifyInfoUI.this).getCount() / 4 > 0) {
            j = i * (SeeAccessVerifyInfoUI.e(SeeAccessVerifyInfoUI.this).getCount() / 4 + 1);
          }
          SeeAccessVerifyInfoUI.f(SeeAccessVerifyInfoUI.this).setLayoutParams(new LinearLayout.LayoutParams(SeeAccessVerifyInfoUI.f(SeeAccessVerifyInfoUI.this).getWidth(), j));
          AppMethodBeat.o(12806);
          return;
        }
      }
    }, 100L);
    if (this.fyR != null) {
      a.b.c(this.fyR, bs.nullAsNil(this.fyI));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.fyS != null)
    {
      localTextView1 = this.fyS;
      localObject2 = bs.nullAsNil(this.fyI);
      localTextView2 = this.fyS;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    com.tencent.mm.storage.ai localai;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.fyT != null)
      {
        if ((!w.wq(this.fyN)) || (!com.tencent.mm.storage.ai.aNc(this.fyI))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.fyJ;
        ((e)localObject1).field_wordingId = this.fyK;
        ((e)localObject1).field_language = ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
        com.tencent.mm.kernel.g.agS();
        ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.fyT.setVisibility(0);
        this.fyT.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.fyP != null) {
        this.fyP.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, bs.nullAsNil(this.fyH)));
      }
      if ((this.fyQ != null) && (!bs.isNullOrNil(this.fyO))) {
        this.fyQ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, "\"" + bs.nullAsNil(this.fyO) + "\""));
      }
      if (this.fyU != null) {
        this.fyU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            AppCompatActivity localAppCompatActivity = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(2131755906);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.b(localAppCompatActivity, SeeAccessVerifyInfoUI.this.getString(2131755122), false, null));
            if (w.wq(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bs.lp(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ","))).aBB().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
              AppMethodBeat.o(12809);
              return;
            }
            new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bs.S(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",")))).aBB().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            AppMethodBeat.o(12809);
          }
        });
      }
      if ((this.fyU != null) && (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.fyL).fce()))
      {
        this.fyU.setBackgroundResource(2131231367);
        this.fyU.setTextColor(getResources().getColor(2131100476));
        this.fyU.setText(getString(2131760229));
        this.fyU.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(bs.nullAsNil((String)localObject2));
      if (localai != null) {
        break;
      }
      ac.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bs.isNullOrNil(localai.field_conRemark)) {
      localObject1 = localai.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = localai.field_conRemark;
      }
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = localai.aaR();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(this, bs.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.ftP != null)
      {
        localObject1 = this.ftP.wk((String)localObject2);
        continue;
        label697:
        if ((!bs.isNullOrNil(this.fyK)) && (!bs.isNullOrNil(this.fyJ)))
        {
          this.fyY = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.fyK);
          com.tencent.mm.kernel.g.agQ().ghe.a(new i(this.fyJ, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.fyT.setVisibility(4);
        break label379;
        label777:
        this.fyT.setVisibility(8);
        break label379;
      }
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12816);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(2131755121));
    this.fyL = getIntent().getLongExtra("msgLocalId", 0L);
    this.fyM = getIntent().getLongExtra("msgSvrId", 0L);
    this.fyH = getIntent().getStringExtra("invitertitle");
    this.fyI = getIntent().getStringExtra("inviterusername");
    this.fyJ = getIntent().getStringExtra("inviterappid");
    this.fyK = getIntent().getStringExtra("inviterdescid");
    this.fyN = getIntent().getStringExtra("chatroom");
    this.fyO = getIntent().getStringExtra("invitationreason");
    this.fwd = getIntent().getStringExtra("ticket");
    this.fyD = getIntent().getStringExtra("username");
    this.fyC = getIntent().getStringExtra("nickname");
    this.fyE = getIntent().getStringExtra("descid");
    this.fyF = getIntent().getStringExtra("appid");
    this.fyG = getIntent().getStringExtra("headimgurl");
    this.ftP = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(bs.nullAsNil(this.fyN));
    this.fyB = new b(this);
    paramBundle = this.fyD.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      ac.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.fyN });
      if ((this.ftP.aDl() != null) && (this.ftP.aDl().contains(paramBundle)))
      {
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.fyL);
        if (!paramBundle.fce())
        {
          paramBundle.fcc();
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.fyL, paramBundle);
        }
      }
    }
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12804);
        SeeAccessVerifyInfoUI.this.finish();
        AppMethodBeat.o(12804);
        return true;
      }
    });
    AppMethodBeat.o(12816);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12818);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    ac.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    com.tencent.mm.kernel.g.agQ().ghe.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12820);
    if (((paramn instanceof i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.fyY) && (bs.aj(this.fyT.getText())))
      {
        this.fyY = false;
        paramString = new e();
        paramString.field_appid = this.fyJ;
        paramString.field_wordingId = this.fyK;
        paramString.field_language = ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
        com.tencent.mm.kernel.g.agS();
        ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.fyT.setVisibility(0);
        this.fyT.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.fyX) {
        this.fyB.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!bs.isNullOrNil(this.fyK)) && (!bs.isNullOrNil(this.fyJ)))
      {
        paramn = new LinkedList();
        paramn.add(this.fyK);
        com.tencent.mm.kernel.g.agQ().ghe.a(new i(this.fyJ, paramString.field_language, paramn), 0);
      }
      this.fyT.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String djj;
    String fzb;
    String fzc;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.djj = paramString3;
      this.fzb = paramString4;
      this.fzc = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> fzd;
    private com.tencent.mm.av.a.a.c fze;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.fzd = new ArrayList();
      this.fze = null;
      this.mContext = paramContext;
      WL();
      this$1 = new com.tencent.mm.av.a.a.c.a();
      SeeAccessVerifyInfoUI.this.hKx = true;
      SeeAccessVerifyInfoUI.this.gKm = true;
      SeeAccessVerifyInfoUI.this.hKI = 2131690013;
      this.fze = SeeAccessVerifyInfoUI.this.aFT();
      AppMethodBeat.o(12811);
    }
    
    private void WL()
    {
      AppMethodBeat.i(12812);
      String[] arrayOfString5;
      String[] arrayOfString1;
      String[] arrayOfString2;
      label112:
      String[] arrayOfString3;
      label139:
      int i;
      label150:
      List localList;
      SeeAccessVerifyInfoUI localSeeAccessVerifyInfoUI;
      String str5;
      String str1;
      label198:
      String str2;
      label221:
      String str3;
      if (!bs.isNullOrNil(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this)))
      {
        String[] arrayOfString4 = SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",");
        if (bs.isNullOrNil(SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this))) {
          break label318;
        }
        arrayOfString5 = SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this).split(",");
        if (bs.isNullOrNil(SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this))) {
          break label332;
        }
        arrayOfString1 = SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this).split(",");
        if (bs.isNullOrNil(SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this))) {
          break label344;
        }
        arrayOfString2 = SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this).split(",");
        if (bs.isNullOrNil(SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this))) {
          break label356;
        }
        arrayOfString3 = SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this).split(",");
        this.fzd.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.fzd;
        localSeeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
        str5 = arrayOfString4[i];
        if ((arrayOfString5.length > i) && (!bs.isNullOrNil(arrayOfString5[i]))) {
          break label369;
        }
        str1 = arrayOfString4[i];
        if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!bs.isNullOrNil(arrayOfString1[i]))) {
          break label378;
        }
        str2 = "";
        if ((arrayOfString2 != null) && (arrayOfString2.length > i) && (!bs.isNullOrNil(arrayOfString2[i]))) {
          break label386;
        }
        str3 = "";
        label244:
        if ((arrayOfString3 != null) && (arrayOfString3.length > i) && (!bs.isNullOrNil(arrayOfString3[i]))) {
          break label394;
        }
      }
      label386:
      label394:
      for (String str4 = "";; str4 = arrayOfString3[i])
      {
        localList.add(new SeeAccessVerifyInfoUI.a(localSeeAccessVerifyInfoUI, str5, str1, str2, str3, str4));
        i += 1;
        break label150;
        ac.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
        AppMethodBeat.o(12812);
        return;
        label318:
        ac.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
        AppMethodBeat.o(12812);
        return;
        label332:
        ac.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
        arrayOfString1 = null;
        break;
        label344:
        ac.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
        arrayOfString2 = null;
        break label112;
        label356:
        ac.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
        arrayOfString3 = null;
        break label139;
        label369:
        str1 = arrayOfString5[i];
        break label198;
        label378:
        str2 = arrayOfString1[i];
        break label221;
        str3 = arrayOfString2[i];
        break label244;
      }
      label403:
      AppMethodBeat.o(12812);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12813);
      int i = this.fzd.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.fzd.get(paramInt);
      AppMethodBeat.o(12814);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12815);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131495276, null);
        paramViewGroup = SeeAccessVerifyInfoUI.this.ct(paramView);
      }
      label479:
      for (;;)
      {
        paramViewGroup.fuY.setVisibility(0);
        paramViewGroup.fzg.setVisibility(0);
        o.aFB().a(((SeeAccessVerifyInfoUI.a)this.fzd.get(paramInt)).fzc, paramViewGroup.fuY, this.fze);
        paramViewGroup.fzg.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bs.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fzd.get(paramInt)).nickname), paramViewGroup.fzg.getTextSize()));
        e locale;
        if (com.tencent.mm.storage.ai.aNc(((SeeAccessVerifyInfoUI.a)this.fzd.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          locale = new e();
          locale.field_appid = bs.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fzd.get(paramInt)).djj);
          locale.field_wordingId = bs.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fzd.get(paramInt)).fzb);
          locale.field_language = ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
          com.tencent.mm.kernel.g.agS();
          ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(locale.field_wording))
          {
            paramViewGroup.fzh.setVisibility(0);
            paramViewGroup.fzh.setText("＠" + locale.field_wording);
          }
        }
        for (;;)
        {
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12810);
              String str = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fzd.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).wk(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fzd.get(paramInt)).username);
              }
              if (bs.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(bs.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fzd.get(paramInt)).username)).aaS();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fzd.get(paramInt)).username, paramAnonymousView, str, true);
                AppMethodBeat.o(12810);
                return;
              }
            }
          });
          AppMethodBeat.o(12815);
          return paramView;
          paramViewGroup = (SeeAccessVerifyInfoUI.c)paramView.getTag();
          if (paramViewGroup != null) {
            break label479;
          }
          paramViewGroup = SeeAccessVerifyInfoUI.this.ct(paramView);
          break;
          if ((!bs.isNullOrNil(locale.field_appid)) && (!bs.isNullOrNil(locale.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(locale.field_wordingId);
            if (!bs.I(paramViewGroup.fzh.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              com.tencent.mm.kernel.g.agQ().ghe.a(new i(locale.field_appid, locale.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.fzh.setVisibility(4);
          paramViewGroup.fzh.setTag("first");
          continue;
          paramViewGroup.fzh.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView fuY;
    public TextView fzg;
    public TextView fzh;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */