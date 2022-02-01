package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private ab fLO;
  private String fPq;
  private b fRO;
  private String fRP;
  private String fRQ;
  private String fRR;
  private String fRS;
  private String fRT;
  private String fRU;
  private String fRV;
  private String fRW;
  private String fRX;
  private long fRY;
  private long fRZ;
  private String fSa;
  private String fSb;
  private TextView fSc;
  private TextView fSd;
  private ImageView fSe;
  private TextView fSf;
  private TextView fSg;
  private TextView fSh;
  private GridView fSi;
  private boolean fSj = false;
  private boolean fSk = false;
  private boolean fSl = false;
  private p tipDialog;
  
  protected final c ct(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.fOf = ((ImageView)paramView.findViewById(2131304237));
    localc.fSt = ((TextView)paramView.findViewById(2131304234));
    localc.fSu = ((TextView)paramView.findViewById(2131304236));
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
    this.fSc = ((TextView)findViewById(2131301072));
    this.fSd = ((TextView)findViewById(2131301071));
    this.fSf = ((TextView)findViewById(2131304234));
    this.fSg = ((TextView)findViewById(2131304236));
    this.fSe = ((ImageView)findViewById(2131304237));
    this.fSh = ((TextView)findViewById(2131296325));
    this.fSi = ((GridView)findViewById(2131297195));
    this.fSi.setAdapter(this.fRO);
    if (this.fSe != null) {
      this.fSe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          am localam = ((l)g.ab(l.class)).azp().Bf(bt.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localam.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).zf(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          localObject = paramAnonymousView;
          if (bt.isNullOrNil(paramAnonymousView)) {
            localObject = localam.adv();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12805);
        }
      });
    }
    this.fSi.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213548);
        return true;
      }
    });
    this.fSi.postDelayed(new Runnable()
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
    if (this.fSe != null) {
      a.b.c(this.fSe, bt.nullAsNil(this.fRV));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.fSf != null)
    {
      localTextView1 = this.fSf;
      localObject2 = bt.nullAsNil(this.fRV);
      localTextView2 = this.fSf;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    am localam;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.fSg != null)
      {
        if ((!w.zl(this.fSa)) || (!am.aSQ(this.fRV))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.fRW;
        ((e)localObject1).field_wordingId = this.fRX;
        ((e)localObject1).field_language = ac.iM(aj.getContext());
        g.ajD();
        ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.fSg.setVisibility(0);
        this.fSg.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.fSc != null) {
        this.fSc.setText(k.c(this, bt.nullAsNil(this.fRU)));
      }
      if ((this.fSd != null) && (!bt.isNullOrNil(this.fSb))) {
        this.fSd.setText(k.c(this, "\"" + bt.nullAsNil(this.fSb) + "\""));
      }
      if (this.fSh != null) {
        this.fSh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            localObject = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(2131755906);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, h.b((Context)localObject, SeeAccessVerifyInfoUI.this.getString(2131755122), false, null));
            if (w.zl(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              paramAnonymousView = new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bt.lO(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ",")));
              paramAnonymousView.hNz = true;
              paramAnonymousView.aED().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12809);
              return;
              paramAnonymousView = new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bt.U(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(","))));
              paramAnonymousView.hNz = true;
              paramAnonymousView.aED().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
          }
        });
      }
      if ((this.fSh != null) && (((l)g.ab(l.class)).dlK().xY(this.fRY).fsh()))
      {
        this.fSh.setBackgroundResource(2131231367);
        this.fSh.setTextColor(getResources().getColor(2131100476));
        this.fSh.setText(getString(2131760229));
        this.fSh.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localam = ((l)g.ab(l.class)).azp().Bf(bt.nullAsNil((String)localObject2));
      if (localam != null) {
        break;
      }
      ad.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bt.isNullOrNil(localam.field_conRemark)) {
      localObject1 = localam.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = localam.field_conRemark;
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = localam.adu();
      }
      localObject1 = k.b(this, bt.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.fLO != null)
      {
        localObject1 = this.fLO.zf((String)localObject2);
        continue;
        label697:
        if ((!bt.isNullOrNil(this.fRX)) && (!bt.isNullOrNil(this.fRW)))
        {
          this.fSl = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.fRX);
          g.ajB().gAO.a(new com.tencent.mm.openim.b.i(this.fRW, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.fSg.setVisibility(4);
        break label379;
        label777:
        this.fSg.setVisibility(8);
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
    this.fRY = getIntent().getLongExtra("msgLocalId", 0L);
    this.fRZ = getIntent().getLongExtra("msgSvrId", 0L);
    this.fRU = getIntent().getStringExtra("invitertitle");
    this.fRV = getIntent().getStringExtra("inviterusername");
    this.fRW = getIntent().getStringExtra("inviterappid");
    this.fRX = getIntent().getStringExtra("inviterdescid");
    this.fSa = getIntent().getStringExtra("chatroom");
    this.fSb = getIntent().getStringExtra("invitationreason");
    this.fPq = getIntent().getStringExtra("ticket");
    this.fRQ = getIntent().getStringExtra("username");
    this.fRP = getIntent().getStringExtra("nickname");
    this.fRR = getIntent().getStringExtra("descid");
    this.fRS = getIntent().getStringExtra("appid");
    this.fRT = getIntent().getStringExtra("headimgurl");
    this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AO(bt.nullAsNil(this.fSa));
    this.fRO = new b(this);
    paramBundle = this.fRQ.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      ad.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.fSa });
      if ((this.fLO.aGo() != null) && (this.fLO.aGo().contains(paramBundle)))
      {
        paramBundle = ((l)g.ab(l.class)).dlK().xY(this.fRY);
        if (!paramBundle.fsh())
        {
          paramBundle.fsf();
          ((l)g.ab(l.class)).dlK().a(this.fRY, paramBundle);
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
    g.ajB().gAO.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    ad.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    g.ajB().gAO.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12820);
    if (((paramn instanceof com.tencent.mm.openim.b.i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.fSl) && (bt.ai(this.fSg.getText())))
      {
        this.fSl = false;
        paramString = new e();
        paramString.field_appid = this.fRW;
        paramString.field_wordingId = this.fRX;
        paramString.field_language = ac.iM(aj.getContext());
        g.ajD();
        ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.fSg.setVisibility(0);
        this.fSg.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.fSk) {
        this.fRO.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!bt.isNullOrNil(this.fRX)) && (!bt.isNullOrNil(this.fRW)))
      {
        paramn = new LinkedList();
        paramn.add(this.fRX);
        g.ajB().gAO.a(new com.tencent.mm.openim.b.i(this.fRW, paramString.field_language, paramn), 0);
      }
      this.fSg.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String duW;
    String fSo;
    String fSp;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.duW = paramString3;
      this.fSo = paramString4;
      this.fSp = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> fSq;
    private com.tencent.mm.aw.a.a.c fSr;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.fSq = new ArrayList();
      this.fSr = null;
      this.mContext = paramContext;
      Zf();
      this$1 = new c.a();
      SeeAccessVerifyInfoUI.this.idr = true;
      SeeAccessVerifyInfoUI.this.hdX = true;
      SeeAccessVerifyInfoUI.this.idD = 2131690013;
      this.fSr = SeeAccessVerifyInfoUI.this.aJc();
      AppMethodBeat.o(12811);
    }
    
    private void Zf()
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
        this.fSq.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.fSq;
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
      int i = this.fSq.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.fSq.get(paramInt);
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
        paramViewGroup.fOf.setVisibility(0);
        paramViewGroup.fSt.setVisibility(0);
        com.tencent.mm.aw.q.aIJ().a(((SeeAccessVerifyInfoUI.a)this.fSq.get(paramInt)).fSp, paramViewGroup.fOf, this.fSr);
        paramViewGroup.fSt.setText(k.b(this.mContext, bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fSq.get(paramInt)).nickname), paramViewGroup.fSt.getTextSize()));
        e locale;
        if (am.aSQ(((SeeAccessVerifyInfoUI.a)this.fSq.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          locale = new e();
          locale.field_appid = bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fSq.get(paramInt)).duW);
          locale.field_wordingId = bt.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fSq.get(paramInt)).fSo);
          locale.field_language = ac.iM(aj.getContext());
          g.ajD();
          ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(locale.field_wording))
          {
            paramViewGroup.fSu.setVisibility(0);
            paramViewGroup.fSu.setText("＠" + locale.field_wording);
          }
        }
        for (;;)
        {
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12810);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              localObject = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fSq.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).zf(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fSq.get(paramInt)).username);
              }
              if (bt.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((l)g.ab(l.class)).azp().Bf(bt.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fSq.get(paramInt)).username)).adv();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fSq.get(paramInt)).username, paramAnonymousView, (String)localObject, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
            if (!bt.K(paramViewGroup.fSu.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              g.ajB().gAO.a(new com.tencent.mm.openim.b.i(locale.field_appid, locale.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.fSu.setVisibility(4);
          paramViewGroup.fSu.setTag("first");
          continue;
          paramViewGroup.fSu.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView fOf;
    public TextView fSt;
    public TextView fSu;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */