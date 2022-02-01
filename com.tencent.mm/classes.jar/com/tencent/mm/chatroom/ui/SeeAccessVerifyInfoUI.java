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
import com.tencent.mm.an.t;
import com.tencent.mm.cw.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private ah iXp;
  private String jaS;
  private boolean jjA = false;
  private boolean jjB = false;
  private b jje;
  private String jjf;
  private String jjg;
  private String jjh;
  private String jji;
  private String jjj;
  private String jjk;
  private String jjl;
  private String jjm;
  private String jjn;
  private long jjo;
  private long jjp;
  private String jjq;
  private String jjr;
  private TextView jjs;
  private TextView jjt;
  private ImageView jju;
  private TextView jjv;
  private TextView jjw;
  private TextView jjx;
  private GridView jjy;
  private boolean jjz = false;
  private s tipDialog;
  
  protected final c cB(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.iZG = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.jjJ = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    localc.jjK = ((TextView)paramView.findViewById(a.e.roominfo_contact_sub_detail));
    AppMethodBeat.o(12821);
    return localc;
  }
  
  public int getLayoutId()
  {
    return a.f.jek;
  }
  
  public void initView()
  {
    Object localObject1 = null;
    AppMethodBeat.i(12819);
    this.jjs = ((TextView)findViewById(a.e.jcO));
    this.jjt = ((TextView)findViewById(a.e.jcN));
    this.jjv = ((TextView)findViewById(a.e.roominfo_contact_name_for_span));
    this.jjw = ((TextView)findViewById(a.e.roominfo_contact_sub_detail));
    this.jju = ((ImageView)findViewById(a.e.roominfo_img));
    this.jjx = ((TextView)findViewById(a.e.jcj));
    this.jjy = ((GridView)findViewById(a.e.jcl));
    this.jjy.setAdapter(this.jje);
    if (this.jju != null) {
      this.jju.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(Util.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localas.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).PJ(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          localObject = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            localObject = localas.ays();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12805);
        }
      });
    }
    this.jjy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.jjy.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12806);
        int i = 0;
        if (SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this) != null) {
          if (!SeeAccessVerifyInfoUI.d(SeeAccessVerifyInfoUI.this)) {
            break label140;
          }
        }
        label140:
        for (i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() * 2 + SeeAccessVerifyInfoUI.this.getResources().getDimension(a.c.BigPadding) + SeeAccessVerifyInfoUI.this.getResources().getDimension(a.c.NormalAvatarSize));; i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() + SeeAccessVerifyInfoUI.this.getResources().getDimension(a.c.BigPadding) + SeeAccessVerifyInfoUI.this.getResources().getDimension(a.c.NormalAvatarSize)))
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
    if (this.jju != null) {
      com.tencent.mm.pluginsdk.ui.a.b.c(this.jju, Util.nullAsNil(this.jjl));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.jjv != null)
    {
      localTextView1 = this.jjv;
      localObject2 = Util.nullAsNil(this.jjl);
      localTextView2 = this.jjv;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    as localas;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.jjw != null)
      {
        if ((!ab.PQ(this.jjq)) || (!as.bvK(this.jjl))) {
          break label777;
        }
        localObject1 = new g();
        ((g)localObject1).field_appid = this.jjm;
        ((g)localObject1).field_wordingId = this.jjn;
        ((g)localObject1).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        com.tencent.mm.kernel.h.aHH();
        ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((g)localObject1).field_wording)) {
          break label697;
        }
        this.jjw.setVisibility(0);
        this.jjw.setText("＠" + ((g)localObject1).field_wording);
      }
      if (this.jjs != null) {
        this.jjs.setText(l.c(this, Util.nullAsNil(this.jjk)));
      }
      if ((this.jjt != null) && (!Util.isNullOrNil(this.jjr))) {
        this.jjt.setText(l.c(this, "\"" + Util.nullAsNil(this.jjr) + "\""));
      }
      if (this.jjx != null) {
        this.jjx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            localObject = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(a.i.app_tip);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject, SeeAccessVerifyInfoUI.this.getString(a.i.jez), false, null));
            if (ab.PQ(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              paramAnonymousView = new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ",")));
              paramAnonymousView.lBH = true;
              paramAnonymousView.bhW().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12809);
              return;
              paramAnonymousView = new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringsToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(","))));
              paramAnonymousView.lBH = true;
              paramAnonymousView.bhW().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
          }
        });
      }
      if ((this.jjx != null) && (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.jjo).hAc()))
      {
        this.jjx.setBackgroundResource(a.d.btn_solid_grey);
        this.jjx.setTextColor(getResources().getColor(a.b.grey_btn_stroke_color_normal));
        this.jjx.setText(getString(a.i.has_approve_info));
        this.jjx.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(Util.nullAsNil((String)localObject2));
      if (localas != null) {
        break;
      }
      Log.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!Util.isNullOrNil(localas.field_conRemark)) {
      localObject1 = localas.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = localas.field_conRemark;
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = localas.ayr();
      }
      localObject1 = l.b(this, Util.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.iXp != null)
      {
        localObject1 = this.iXp.PJ((String)localObject2);
        continue;
        label697:
        if ((!Util.isNullOrNil(this.jjn)) && (!Util.isNullOrNil(this.jjm)))
        {
          this.jjB = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.jjn);
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.openim.b.i(this.jjm, ((g)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.jjw.setVisibility(4);
        break label379;
        label777:
        this.jjw.setVisibility(8);
        break label379;
      }
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12816);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
    setMMTitle(getString(a.i.jey));
    this.jjo = getIntent().getLongExtra("msgLocalId", 0L);
    this.jjp = getIntent().getLongExtra("msgSvrId", 0L);
    this.jjk = getIntent().getStringExtra("invitertitle");
    this.jjl = getIntent().getStringExtra("inviterusername");
    this.jjm = getIntent().getStringExtra("inviterappid");
    this.jjn = getIntent().getStringExtra("inviterdescid");
    this.jjq = getIntent().getStringExtra("chatroom");
    this.jjr = getIntent().getStringExtra("invitationreason");
    this.jaS = getIntent().getStringExtra("ticket");
    this.jjg = getIntent().getStringExtra("username");
    this.jjf = getIntent().getStringExtra("nickname");
    this.jjh = getIntent().getStringExtra("descid");
    this.jji = getIntent().getStringExtra("appid");
    this.jjj = getIntent().getStringExtra("headimgurl");
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(Util.nullAsNil(this.jjq));
    this.jje = new b(this);
    paramBundle = this.jjg.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.jjq });
      if ((this.iXp.bjL() != null) && (this.iXp.bjL().contains(paramBundle)))
      {
        paramBundle = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.jjo);
        if (!paramBundle.hAc())
        {
          paramBundle.hAa();
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.jjo, paramBundle);
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
    com.tencent.mm.kernel.h.aHF().kcd.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    com.tencent.mm.kernel.h.aHF().kcd.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(12820);
    if (((paramq instanceof com.tencent.mm.openim.b.i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.jjB) && (Util.isNullOrNil(this.jjw.getText())))
      {
        this.jjB = false;
        paramString = new g();
        paramString.field_appid = this.jjm;
        paramString.field_wordingId = this.jjn;
        paramString.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        com.tencent.mm.kernel.h.aHH();
        ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.jjw.setVisibility(0);
        this.jjw.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.jjA) {
        this.jje.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!Util.isNullOrNil(this.jjn)) && (!Util.isNullOrNil(this.jjm)))
      {
        paramq = new LinkedList();
        paramq.add(this.jjn);
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.openim.b.i(this.jjm, paramString.field_language, paramq), 0);
      }
      this.jjw.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String appid;
    String jjE;
    String jjF;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.appid = paramString3;
      this.jjE = paramString4;
      this.jjF = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> jjG;
    private com.tencent.mm.ay.a.a.c jjH;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.jjG = new ArrayList();
      this.jjH = null;
      this.mContext = paramContext;
      atc();
      this$1 = new com.tencent.mm.ay.a.a.c.a();
      SeeAccessVerifyInfoUI.this.lRD = true;
      SeeAccessVerifyInfoUI.this.kOl = true;
      SeeAccessVerifyInfoUI.this.lRP = a.h.default_avatar;
      this.jjH = SeeAccessVerifyInfoUI.this.bmL();
      AppMethodBeat.o(12811);
    }
    
    private void atc()
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
      if (!Util.isNullOrNil(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this)))
      {
        String[] arrayOfString4 = SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(",");
        if (Util.isNullOrNil(SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this))) {
          break label318;
        }
        arrayOfString5 = SeeAccessVerifyInfoUI.n(SeeAccessVerifyInfoUI.this).split(",");
        if (Util.isNullOrNil(SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this))) {
          break label332;
        }
        arrayOfString1 = SeeAccessVerifyInfoUI.o(SeeAccessVerifyInfoUI.this).split(",");
        if (Util.isNullOrNil(SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this))) {
          break label344;
        }
        arrayOfString2 = SeeAccessVerifyInfoUI.p(SeeAccessVerifyInfoUI.this).split(",");
        if (Util.isNullOrNil(SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this))) {
          break label356;
        }
        arrayOfString3 = SeeAccessVerifyInfoUI.q(SeeAccessVerifyInfoUI.this).split(",");
        this.jjG.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.jjG;
        localSeeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
        str5 = arrayOfString4[i];
        if ((arrayOfString5.length > i) && (!Util.isNullOrNil(arrayOfString5[i]))) {
          break label369;
        }
        str1 = arrayOfString4[i];
        if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!Util.isNullOrNil(arrayOfString1[i]))) {
          break label378;
        }
        str2 = "";
        if ((arrayOfString2 != null) && (arrayOfString2.length > i) && (!Util.isNullOrNil(arrayOfString2[i]))) {
          break label386;
        }
        str3 = "";
        label244:
        if ((arrayOfString3 != null) && (arrayOfString3.length > i) && (!Util.isNullOrNil(arrayOfString3[i]))) {
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
        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
        AppMethodBeat.o(12812);
        return;
        label318:
        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
        AppMethodBeat.o(12812);
        return;
        label332:
        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
        arrayOfString1 = null;
        break;
        label344:
        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
        arrayOfString2 = null;
        break label112;
        label356:
        Log.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
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
      int i = this.jjG.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.jjG.get(paramInt);
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
        paramView = View.inflate(this.mContext, a.f.roominfo_contact, null);
        paramViewGroup = SeeAccessVerifyInfoUI.this.cB(paramView);
      }
      label480:
      for (;;)
      {
        paramViewGroup.iZG.setVisibility(0);
        paramViewGroup.jjJ.setVisibility(0);
        com.tencent.mm.ay.q.bml().a(((SeeAccessVerifyInfoUI.a)this.jjG.get(paramInt)).jjF, paramViewGroup.iZG, this.jjH);
        paramViewGroup.jjJ.setText(l.b(this.mContext, Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.jjG.get(paramInt)).nickname), paramViewGroup.jjJ.getTextSize()));
        g localg;
        if (as.bvK(((SeeAccessVerifyInfoUI.a)this.jjG.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          localg = new g();
          localg.field_appid = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.jjG.get(paramInt)).appid);
          localg.field_wordingId = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.jjG.get(paramInt)).jjE);
          localg.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          com.tencent.mm.kernel.h.aHH();
          ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().get(localg, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(localg.field_wording))
          {
            paramViewGroup.jjK.setVisibility(0);
            paramViewGroup.jjK.setText("＠" + localg.field_wording);
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
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              localObject = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.jjG.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).PJ(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.jjG.get(paramInt)).username);
              }
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(Util.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.jjG.get(paramInt)).username)).ays();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.jjG.get(paramInt)).username, paramAnonymousView, (String)localObject, true);
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
            break label480;
          }
          paramViewGroup = SeeAccessVerifyInfoUI.this.cB(paramView);
          break;
          if ((!Util.isNullOrNil(localg.field_appid)) && (!Util.isNullOrNil(localg.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(localg.field_wordingId);
            if (!Util.isEqual(paramViewGroup.jjK.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.openim.b.i(localg.field_appid, localg.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.jjK.setVisibility(4);
          paramViewGroup.jjK.setTag("first");
          continue;
          paramViewGroup.jjK.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView iZG;
    public TextView jjJ;
    public TextView jjK;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */