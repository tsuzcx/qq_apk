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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private ac fNS;
  private String fRw;
  private b fTU;
  private String fTV;
  private String fTW;
  private String fTX;
  private String fTY;
  private String fTZ;
  private String fUa;
  private String fUb;
  private String fUc;
  private String fUd;
  private long fUe;
  private long fUf;
  private String fUg;
  private String fUh;
  private TextView fUi;
  private TextView fUj;
  private ImageView fUk;
  private TextView fUl;
  private TextView fUm;
  private TextView fUn;
  private GridView fUo;
  private boolean fUp = false;
  private boolean fUq = false;
  private boolean fUr = false;
  private p tipDialog;
  
  protected final c ct(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.fQl = ((ImageView)paramView.findViewById(2131304237));
    localc.fUz = ((TextView)paramView.findViewById(2131304234));
    localc.fUA = ((TextView)paramView.findViewById(2131304236));
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
    this.fUi = ((TextView)findViewById(2131301072));
    this.fUj = ((TextView)findViewById(2131301071));
    this.fUl = ((TextView)findViewById(2131304234));
    this.fUm = ((TextView)findViewById(2131304236));
    this.fUk = ((ImageView)findViewById(2131304237));
    this.fUn = ((TextView)findViewById(2131296325));
    this.fUo = ((GridView)findViewById(2131297195));
    this.fUo.setAdapter(this.fTU);
    if (this.fUk != null) {
      this.fUk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          an localan = ((l)g.ab(l.class)).azF().BH(bu.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localan.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).zP(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          localObject = paramAnonymousView;
          if (bu.isNullOrNil(paramAnonymousView)) {
            localObject = localan.adG();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12805);
        }
      });
    }
    this.fUo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(217265);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(217265);
        return true;
      }
    });
    this.fUo.postDelayed(new Runnable()
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
    if (this.fUk != null) {
      a.b.c(this.fUk, bu.nullAsNil(this.fUb));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.fUl != null)
    {
      localTextView1 = this.fUl;
      localObject2 = bu.nullAsNil(this.fUb);
      localTextView2 = this.fUl;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    an localan;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.fUm != null)
      {
        if ((!x.zV(this.fUg)) || (!an.aUq(this.fUb))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.fUc;
        ((e)localObject1).field_wordingId = this.fUd;
        ((e)localObject1).field_language = ad.iR(ak.getContext());
        g.ajS();
        ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.fUm.setVisibility(0);
        this.fUm.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.fUi != null) {
        this.fUi.setText(k.c(this, bu.nullAsNil(this.fUa)));
      }
      if ((this.fUj != null) && (!bu.isNullOrNil(this.fUh))) {
        this.fUj.setText(k.c(this, "\"" + bu.nullAsNil(this.fUh) + "\""));
      }
      if (this.fUn != null) {
        this.fUn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            localObject = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(2131755906);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, h.b((Context)localObject, SeeAccessVerifyInfoUI.this.getString(2131755122), false, null));
            if (x.zV(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              paramAnonymousView = new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bu.lV(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ",")));
              paramAnonymousView.hQs = true;
              paramAnonymousView.aET().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12809);
              return;
              paramAnonymousView = new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(bu.U(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(","))));
              paramAnonymousView.hQs = true;
              paramAnonymousView.aET().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
          }
        });
      }
      if ((this.fUn != null) && (((l)g.ab(l.class)).doJ().ys(this.fUe).fwi()))
      {
        this.fUn.setBackgroundResource(2131231367);
        this.fUn.setTextColor(getResources().getColor(2131100476));
        this.fUn.setText(getString(2131760229));
        this.fUn.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localan = ((l)g.ab(l.class)).azF().BH(bu.nullAsNil((String)localObject2));
      if (localan != null) {
        break;
      }
      ae.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!bu.isNullOrNil(localan.field_conRemark)) {
      localObject1 = localan.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        localObject2 = localan.field_conRemark;
      }
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = localan.adF();
      }
      localObject1 = k.b(this, bu.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.fNS != null)
      {
        localObject1 = this.fNS.zP((String)localObject2);
        continue;
        label697:
        if ((!bu.isNullOrNil(this.fUd)) && (!bu.isNullOrNil(this.fUc)))
        {
          this.fUr = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.fUd);
          g.ajQ().gDv.a(new com.tencent.mm.openim.b.i(this.fUc, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.fUm.setVisibility(4);
        break label379;
        label777:
        this.fUm.setVisibility(8);
        break label379;
      }
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12816);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(2131755121));
    this.fUe = getIntent().getLongExtra("msgLocalId", 0L);
    this.fUf = getIntent().getLongExtra("msgSvrId", 0L);
    this.fUa = getIntent().getStringExtra("invitertitle");
    this.fUb = getIntent().getStringExtra("inviterusername");
    this.fUc = getIntent().getStringExtra("inviterappid");
    this.fUd = getIntent().getStringExtra("inviterdescid");
    this.fUg = getIntent().getStringExtra("chatroom");
    this.fUh = getIntent().getStringExtra("invitationreason");
    this.fRw = getIntent().getStringExtra("ticket");
    this.fTW = getIntent().getStringExtra("username");
    this.fTV = getIntent().getStringExtra("nickname");
    this.fTX = getIntent().getStringExtra("descid");
    this.fTY = getIntent().getStringExtra("appid");
    this.fTZ = getIntent().getStringExtra("headimgurl");
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(bu.nullAsNil(this.fUg));
    this.fTU = new b(this);
    paramBundle = this.fTW.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      ae.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.fUg });
      if ((this.fNS.aGE() != null) && (this.fNS.aGE().contains(paramBundle)))
      {
        paramBundle = ((l)g.ab(l.class)).doJ().ys(this.fUe);
        if (!paramBundle.fwi())
        {
          paramBundle.fwg();
          ((l)g.ab(l.class)).doJ().a(this.fUe, paramBundle);
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
    g.ajQ().gDv.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    ae.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    g.ajQ().gDv.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12820);
    if (((paramn instanceof com.tencent.mm.openim.b.i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.fUr) && (bu.ah(this.fUm.getText())))
      {
        this.fUr = false;
        paramString = new e();
        paramString.field_appid = this.fUc;
        paramString.field_wordingId = this.fUd;
        paramString.field_language = ad.iR(ak.getContext());
        g.ajS();
        ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.fUm.setVisibility(0);
        this.fUm.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.fUq) {
        this.fTU.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!bu.isNullOrNil(this.fUd)) && (!bu.isNullOrNil(this.fUc)))
      {
        paramn = new LinkedList();
        paramn.add(this.fUd);
        g.ajQ().gDv.a(new com.tencent.mm.openim.b.i(this.fUc, paramString.field_language, paramn), 0);
      }
      this.fUm.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String dwb;
    String fUu;
    String fUv;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.dwb = paramString3;
      this.fUu = paramString4;
      this.fUv = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> fUw;
    private com.tencent.mm.av.a.a.c fUx;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.fUw = new ArrayList();
      this.fUx = null;
      this.mContext = paramContext;
      Zo();
      this$1 = new c.a();
      SeeAccessVerifyInfoUI.this.igk = true;
      SeeAccessVerifyInfoUI.this.hgL = true;
      SeeAccessVerifyInfoUI.this.igv = 2131690013;
      this.fUx = SeeAccessVerifyInfoUI.this.aJu();
      AppMethodBeat.o(12811);
    }
    
    private void Zo()
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
      if (!bu.isNullOrNil(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this)))
      {
        String[] arrayOfString4 = SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",");
        if (bu.isNullOrNil(SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this))) {
          break label318;
        }
        arrayOfString5 = SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this).split(",");
        if (bu.isNullOrNil(SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this))) {
          break label332;
        }
        arrayOfString1 = SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this).split(",");
        if (bu.isNullOrNil(SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this))) {
          break label344;
        }
        arrayOfString2 = SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this).split(",");
        if (bu.isNullOrNil(SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this))) {
          break label356;
        }
        arrayOfString3 = SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this).split(",");
        this.fUw.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.fUw;
        localSeeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
        str5 = arrayOfString4[i];
        if ((arrayOfString5.length > i) && (!bu.isNullOrNil(arrayOfString5[i]))) {
          break label369;
        }
        str1 = arrayOfString4[i];
        if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!bu.isNullOrNil(arrayOfString1[i]))) {
          break label378;
        }
        str2 = "";
        if ((arrayOfString2 != null) && (arrayOfString2.length > i) && (!bu.isNullOrNil(arrayOfString2[i]))) {
          break label386;
        }
        str3 = "";
        label244:
        if ((arrayOfString3 != null) && (arrayOfString3.length > i) && (!bu.isNullOrNil(arrayOfString3[i]))) {
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
        ae.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
        AppMethodBeat.o(12812);
        return;
        label318:
        ae.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
        AppMethodBeat.o(12812);
        return;
        label332:
        ae.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
        arrayOfString1 = null;
        break;
        label344:
        ae.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
        arrayOfString2 = null;
        break label112;
        label356:
        ae.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
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
      int i = this.fUw.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.fUw.get(paramInt);
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
        paramViewGroup.fQl.setVisibility(0);
        paramViewGroup.fUz.setVisibility(0);
        com.tencent.mm.av.q.aJb().a(((SeeAccessVerifyInfoUI.a)this.fUw.get(paramInt)).fUv, paramViewGroup.fQl, this.fUx);
        paramViewGroup.fUz.setText(k.b(this.mContext, bu.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fUw.get(paramInt)).nickname), paramViewGroup.fUz.getTextSize()));
        e locale;
        if (an.aUq(((SeeAccessVerifyInfoUI.a)this.fUw.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          locale = new e();
          locale.field_appid = bu.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fUw.get(paramInt)).dwb);
          locale.field_wordingId = bu.nullAsNil(((SeeAccessVerifyInfoUI.a)this.fUw.get(paramInt)).fUu);
          locale.field_language = ad.iR(ak.getContext());
          g.ajS();
          ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(locale.field_wording))
          {
            paramViewGroup.fUA.setVisibility(0);
            paramViewGroup.fUA.setText("＠" + locale.field_wording);
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              localObject = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fUw.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).zP(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fUw.get(paramInt)).username);
              }
              if (bu.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((l)g.ab(l.class)).azF().BH(bu.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fUw.get(paramInt)).username)).adG();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.fUw.get(paramInt)).username, paramAnonymousView, (String)localObject, true);
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
          if ((!bu.isNullOrNil(locale.field_appid)) && (!bu.isNullOrNil(locale.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(locale.field_wordingId);
            if (!bu.K(paramViewGroup.fUA.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              g.ajQ().gDv.a(new com.tencent.mm.openim.b.i(locale.field_appid, locale.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.fUA.setVisibility(4);
          paramViewGroup.fUA.setTag("first");
          continue;
          paramViewGroup.fUA.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView fQl;
    public TextView fUA;
    public TextView fUz;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */