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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.b;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.storage.w fql;
  private String fsw;
  private b fuU;
  private String fuV;
  private String fuW;
  private String fuX;
  private String fuY;
  private String fuZ;
  private String fva;
  private String fvb;
  private String fvc;
  private String fvd;
  private long fve;
  private long fvf;
  private String fvg;
  private String fvh;
  private TextView fvi;
  private TextView fvj;
  private ImageView fvk;
  private TextView fvl;
  private TextView fvm;
  private TextView fvn;
  private GridView fvo;
  private boolean fvp = false;
  private boolean fvq = false;
  private boolean fvr = false;
  private p tipDialog;
  
  protected final c ct(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.frr = ((ImageView)paramView.findViewById(2131304237));
    localc.fvz = ((TextView)paramView.findViewById(2131304234));
    localc.fvA = ((TextView)paramView.findViewById(2131304236));
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
    this.fvi = ((TextView)findViewById(2131301072));
    this.fvj = ((TextView)findViewById(2131301071));
    this.fvl = ((TextView)findViewById(2131304234));
    this.fvm = ((TextView)findViewById(2131304236));
    this.fvk = ((ImageView)findViewById(2131304237));
    this.fvn = ((TextView)findViewById(2131296325));
    this.fvo = ((GridView)findViewById(2131297195));
    this.fvo.setAdapter(this.fuU);
    if (this.fvk != null) {
      this.fvk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(bt.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localaf.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).sh(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          Object localObject = paramAnonymousView;
          if (bt.isNullOrNil(paramAnonymousView)) {
            localObject = localaf.ZX();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          AppMethodBeat.o(12805);
        }
      });
    }
    this.fvo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.fvo.postDelayed(new Runnable()
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
    if (this.fvk != null) {
      a.b.c(this.fvk, bt.nullAsNil(this.fvb));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.fvl != null)
    {
      localTextView1 = this.fvl;
      localObject2 = bt.nullAsNil(this.fvb);
      localTextView2 = this.fvl;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    af localaf;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.fvm != null)
      {
        if ((!com.tencent.mm.model.w.sn(this.fvg)) || (!af.aHH(this.fvb))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.fvc;
        ((e)localObject1).field_wordingId = this.fvd;
        ((e)localObject1).field_language = ac.ir(com.tencent.mm.sdk.platformtools.aj.getContext());
        com.tencent.mm.kernel.g.afC();
        ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.fvm.setVisibility(0);
        this.fvm.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.fvi != null) {
        this.fvi.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, bt.nullAsNil(this.fva)));
      }
      if ((this.fvj != null) && (!bt.isNullOrNil(this.fvh))) {
        this.fvj.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, "\"" + bt.nullAsNil(this.fvh) + "\""));
      }
      if (this.fvn != null) {
        this.fvn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            AppCompatActivity localAppCompatActivity = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(2131755906);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.b(localAppCompatActivity, SeeAccessVerifyInfoUI.this.getString(2131755122), false, null));
            if (com.tencent.mm.model.w.sn(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bt.kS(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ","))).auK().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
              AppMethodBeat.o(12809);
              return;
            }
            new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bt.S(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",")))).auK().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            AppMethodBeat.o(12809);
          }
        });
      }
      if ((this.fvn != null) && (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.fve).eMz()))
      {
        this.fvn.setBackgroundResource(2131231367);
        this.fvn.setTextColor(getResources().getColor(2131100476));
        this.fvn.setText(getString(2131760229));
        this.fvn.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(bt.nullAsNil((String)localObject2));
      if (localaf != null) {
        break;
      }
      ad.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bt.isNullOrNil(localaf.field_conRemark)) {
      localObject1 = localaf.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = localaf.field_conRemark;
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = localaf.ZW();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(this, bt.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.fql != null)
      {
        localObject1 = this.fql.sh((String)localObject2);
        continue;
        label697:
        if ((!bt.isNullOrNil(this.fvd)) && (!bt.isNullOrNil(this.fvc)))
        {
          this.fvr = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.fvd);
          com.tencent.mm.kernel.g.afA().gcy.a(new i(this.fvc, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.fvm.setVisibility(4);
        break label379;
        label777:
        this.fvm.setVisibility(8);
        break label379;
      }
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12816);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(2131755121));
    this.fve = getIntent().getLongExtra("msgLocalId", 0L);
    this.fvf = getIntent().getLongExtra("msgSvrId", 0L);
    this.fva = getIntent().getStringExtra("invitertitle");
    this.fvb = getIntent().getStringExtra("inviterusername");
    this.fvc = getIntent().getStringExtra("inviterappid");
    this.fvd = getIntent().getStringExtra("inviterdescid");
    this.fvg = getIntent().getStringExtra("chatroom");
    this.fvh = getIntent().getStringExtra("invitationreason");
    this.fsw = getIntent().getStringExtra("ticket");
    this.fuW = getIntent().getStringExtra("username");
    this.fuV = getIntent().getStringExtra("nickname");
    this.fuX = getIntent().getStringExtra("descid");
    this.fuY = getIntent().getStringExtra("appid");
    this.fuZ = getIntent().getStringExtra("headimgurl");
    this.fql = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(bt.nullAsNil(this.fvg));
    this.fuU = new b(this);
    paramBundle = this.fuW.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      ad.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.fvg });
      if ((this.fql.awt() != null) && (this.fql.awt().contains(paramBundle)))
      {
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.fve);
        if (!paramBundle.eMz())
        {
          paramBundle.eMx();
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.fve, paramBundle);
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
    com.tencent.mm.kernel.g.afA().gcy.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    ad.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    com.tencent.mm.kernel.g.afA().gcy.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12820);
    if (((paramn instanceof i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.fvr) && (bt.ai(this.fvm.getText())))
      {
        this.fvr = false;
        paramString = new e();
        paramString.field_appid = this.fvc;
        paramString.field_wordingId = this.fvd;
        paramString.field_language = ac.ir(com.tencent.mm.sdk.platformtools.aj.getContext());
        com.tencent.mm.kernel.g.afC();
        ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.fvm.setVisibility(0);
        this.fvm.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.fvq) {
        this.fuU.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!bt.isNullOrNil(this.fvd)) && (!bt.isNullOrNil(this.fvc)))
      {
        paramn = new LinkedList();
        paramn.add(this.fvd);
        com.tencent.mm.kernel.g.afA().gcy.a(new i(this.fvc, paramString.field_language, paramn), 0);
      }
      this.fvm.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String dlB;
    String fvu;
    String fvv;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.dlB = paramString3;
      this.fvu = paramString4;
      this.fvv = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> fvw;
    private com.tencent.mm.aw.a.a.c fvx;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.fvw = new ArrayList();
      this.fvx = null;
      this.mContext = paramContext;
      VN();
      this$1 = new com.tencent.mm.aw.a.a.c.a();
      SeeAccessVerifyInfoUI.this.hjU = true;
      SeeAccessVerifyInfoUI.this.gjA = true;
      SeeAccessVerifyInfoUI.this.hkf = 2131690013;
      this.fvx = SeeAccessVerifyInfoUI.this.azc();
      AppMethodBeat.o(12811);
    }
    
    private void VN()
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
      if (!bt.isNullOrNil(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this)))
      {
        String[] arrayOfString4 = SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",");
        if (bt.isNullOrNil(SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this))) {
          break label318;
        }
        arrayOfString5 = SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this).split(",");
        if (bt.isNullOrNil(SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this))) {
          break label332;
        }
        arrayOfString1 = SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this).split(",");
        if (bt.isNullOrNil(SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this))) {
          break label344;
        }
        arrayOfString2 = SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this).split(",");
        if (bt.isNullOrNil(SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this))) {
          break label356;
        }
        arrayOfString3 = SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this).split(",");
        this.fvw.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.fvw;
        localSeeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
        str5 = arrayOfString4[i];
        if ((arrayOfString5.length > i) && (!bt.isNullOrNil(arrayOfString5[i]))) {
          break label369;
        }
        str1 = arrayOfString4[i];
        if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!bt.isNullOrNil(arrayOfString1[i]))) {
          break label378;
        }
        str2 = "";
        if ((arrayOfString2 != null) && (arrayOfString2.length > i) && (!bt.isNullOrNil(arrayOfString2[i]))) {
          break label386;
        }
        str3 = "";
        label244:
        if ((arrayOfString3 != null) && (arrayOfString3.length > i) && (!bt.isNullOrNil(arrayOfString3[i]))) {
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
        ad.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
        AppMethodBeat.o(12812);
        return;
        label318:
        ad.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
        AppMethodBeat.o(12812);
        return;
        label332:
        ad.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
        arrayOfString1 = null;
        break;
        label344:
        ad.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
        arrayOfString2 = null;
        break label112;
        label356:
        ad.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
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
      int i = this.fvw.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.fvw.get(paramInt);
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
        paramViewGroup.frr.setVisibility(0);
        paramViewGroup.fvz.setVisibility(0);
        o.ayJ().a(((SeeAccessVerifyInfoUI.a)this.fvw.get(paramInt)).fvv, paramViewGroup.frr, this.fvx);
        paramViewGroup.fvz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fvw.get(paramInt)).nickname), paramViewGroup.fvz.getTextSize()));
        e locale;
        if (af.aHH(((SeeAccessVerifyInfoUI.a)this.fvw.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          locale = new e();
          locale.field_appid = bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fvw.get(paramInt)).dlB);
          locale.field_wordingId = bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fvw.get(paramInt)).fvu);
          locale.field_language = ac.ir(com.tencent.mm.sdk.platformtools.aj.getContext());
          com.tencent.mm.kernel.g.afC();
          ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(locale.field_wording))
          {
            paramViewGroup.fvA.setVisibility(0);
            paramViewGroup.fvA.setText("＠" + locale.field_wording);
          }
        }
        for (;;)
        {
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12810);
              String str = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fvw.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).sh(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fvw.get(paramInt)).username);
              }
              if (bt.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(bt.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fvw.get(paramInt)).username)).ZX();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fvw.get(paramInt)).username, paramAnonymousView, str, true);
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
          if ((!bt.isNullOrNil(locale.field_appid)) && (!bt.isNullOrNil(locale.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(locale.field_wordingId);
            if (!bt.I(paramViewGroup.fvA.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              com.tencent.mm.kernel.g.afA().gcy.a(new i(locale.field_appid, locale.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.fvA.setVisibility(4);
          paramViewGroup.fvA.setTag("first");
          continue;
          paramViewGroup.fvA.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView frr;
    public TextView fvA;
    public TextView fvz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */