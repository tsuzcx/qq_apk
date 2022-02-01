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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.protocal.protobuf.hd;
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
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private ah gtd;
  private String gwF;
  private b gzb;
  private String gzc;
  private String gzd;
  private String gze;
  private String gzf;
  private String gzg;
  private String gzh;
  private String gzi;
  private String gzj;
  private String gzk;
  private long gzl;
  private long gzm;
  private String gzn;
  private String gzo;
  private TextView gzp;
  private TextView gzq;
  private ImageView gzr;
  private TextView gzs;
  private TextView gzt;
  private TextView gzu;
  private GridView gzv;
  private boolean gzw = false;
  private boolean gzx = false;
  private boolean gzy = false;
  private com.tencent.mm.ui.base.q tipDialog;
  
  protected final c ci(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.gvv = ((ImageView)paramView.findViewById(2131307155));
    localc.gzG = ((TextView)paramView.findViewById(2131307152));
    localc.gzH = ((TextView)paramView.findViewById(2131307154));
    AppMethodBeat.o(12821);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2131496195;
  }
  
  public void initView()
  {
    Object localObject1 = null;
    AppMethodBeat.i(12819);
    this.gzp = ((TextView)findViewById(2131302726));
    this.gzq = ((TextView)findViewById(2131302725));
    this.gzs = ((TextView)findViewById(2131307152));
    this.gzt = ((TextView)findViewById(2131307154));
    this.gzr = ((ImageView)findViewById(2131307155));
    this.gzu = ((TextView)findViewById(2131296338));
    this.gzv = ((GridView)findViewById(2131297340));
    this.gzv.setAdapter(this.gzb);
    if (this.gzr != null) {
      this.gzr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(Util.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localas.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).getDisplayName(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          localObject = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            localObject = localas.arJ();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12805);
        }
      });
    }
    this.gzv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.gzv.postDelayed(new Runnable()
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
        for (i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() * 2 + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165194) + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165526));; i = (int)(SeeAccessVerifyInfoUI.c(SeeAccessVerifyInfoUI.this).getHeight() + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165194) + SeeAccessVerifyInfoUI.this.getResources().getDimension(2131165526)))
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
    if (this.gzr != null) {
      a.b.c(this.gzr, Util.nullAsNil(this.gzi));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.gzs != null)
    {
      localTextView1 = this.gzs;
      localObject2 = Util.nullAsNil(this.gzi);
      localTextView2 = this.gzs;
      if (localTextView2 != null) {
        break label574;
      }
    }
    label379:
    as localas;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.gzt != null)
      {
        if ((!ab.Iy(this.gzn)) || (!as.bjp(this.gzi))) {
          break label777;
        }
        localObject1 = new e();
        ((e)localObject1).field_appid = this.gzj;
        ((e)localObject1).field_wordingId = this.gzk;
        ((e)localObject1).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        g.aAi();
        ((PluginOpenIM)g.ah(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((e)localObject1).field_wording)) {
          break label697;
        }
        this.gzt.setVisibility(0);
        this.gzt.setText("＠" + ((e)localObject1).field_wording);
      }
      if (this.gzp != null) {
        this.gzp.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(this.gzh)));
      }
      if ((this.gzq != null) && (!Util.isNullOrNil(this.gzo))) {
        this.gzq.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, "\"" + Util.nullAsNil(this.gzo) + "\""));
      }
      if (this.gzu != null) {
        this.gzu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            localObject = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(2131755998);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, h.a((Context)localObject, SeeAccessVerifyInfoUI.this.getString(2131755135), false, null));
            if (ab.Iy(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              paramAnonymousView = new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ",")));
              paramAnonymousView.iLA = true;
              paramAnonymousView.aYI().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12809);
              return;
              paramAnonymousView = new com.tencent.mm.chatroom.d.c(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringsToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(","))));
              paramAnonymousView.iLA = true;
              paramAnonymousView.aYI().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
          }
        });
      }
      if ((this.gzu != null) && (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.gzl).gDO()))
      {
        this.gzu.setBackgroundResource(2131231431);
        this.gzu.setTextColor(getResources().getColor(2131100578));
        this.gzu.setText(getString(2131761615));
        this.gzu.setEnabled(false);
      }
      AppMethodBeat.o(12819);
      return;
      label574:
      localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(Util.nullAsNil((String)localObject2));
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
        localObject1 = localas.arI();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.gtd != null)
      {
        localObject1 = this.gtd.getDisplayName((String)localObject2);
        continue;
        label697:
        if ((!Util.isNullOrNil(this.gzk)) && (!Util.isNullOrNil(this.gzj)))
        {
          this.gzy = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.gzk);
          g.aAg().hqi.a(new com.tencent.mm.openim.b.i(this.gzj, ((e)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.gzt.setVisibility(4);
        break label379;
        label777:
        this.gzt.setVisibility(8);
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
    setMMTitle(getString(2131755134));
    this.gzl = getIntent().getLongExtra("msgLocalId", 0L);
    this.gzm = getIntent().getLongExtra("msgSvrId", 0L);
    this.gzh = getIntent().getStringExtra("invitertitle");
    this.gzi = getIntent().getStringExtra("inviterusername");
    this.gzj = getIntent().getStringExtra("inviterappid");
    this.gzk = getIntent().getStringExtra("inviterdescid");
    this.gzn = getIntent().getStringExtra("chatroom");
    this.gzo = getIntent().getStringExtra("invitationreason");
    this.gwF = getIntent().getStringExtra("ticket");
    this.gzd = getIntent().getStringExtra("username");
    this.gzc = getIntent().getStringExtra("nickname");
    this.gze = getIntent().getStringExtra("descid");
    this.gzf = getIntent().getStringExtra("appid");
    this.gzg = getIntent().getStringExtra("headimgurl");
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(Util.nullAsNil(this.gzn));
    this.gzb = new b(this);
    paramBundle = this.gzd.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.gzn });
      if ((this.gtd.bax() != null) && (this.gtd.bax().contains(paramBundle)))
      {
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.gzl);
        if (!paramBundle.gDO())
        {
          paramBundle.gDM();
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.gzl, paramBundle);
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
    g.aAg().hqi.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    g.aAg().hqi.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(12820);
    if (((paramq instanceof com.tencent.mm.openim.b.i)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.gzy) && (Util.isNullOrNil(this.gzt.getText())))
      {
        this.gzy = false;
        paramString = new e();
        paramString.field_appid = this.gzj;
        paramString.field_wordingId = this.gzk;
        paramString.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        g.aAi();
        ((PluginOpenIM)g.ah(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.gzt.setVisibility(0);
        this.gzt.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.gzx) {
        this.gzb.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!Util.isNullOrNil(this.gzk)) && (!Util.isNullOrNil(this.gzj)))
      {
        paramq = new LinkedList();
        paramq.add(this.gzk);
        g.aAg().hqi.a(new com.tencent.mm.openim.b.i(this.gzj, paramString.field_language, paramq), 0);
      }
      this.gzt.setVisibility(4);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    String dNI;
    String gzB;
    String gzC;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.dNI = paramString3;
      this.gzB = paramString4;
      this.gzC = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> gzD;
    private com.tencent.mm.av.a.a.c gzE;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.gzD = new ArrayList();
      this.gzE = null;
      this.mContext = paramContext;
      anb();
      this$1 = new com.tencent.mm.av.a.a.c.a();
      SeeAccessVerifyInfoUI.this.jbf = true;
      SeeAccessVerifyInfoUI.this.hZF = true;
      SeeAccessVerifyInfoUI.this.jbq = 2131690042;
      this.gzE = SeeAccessVerifyInfoUI.this.bdv();
      AppMethodBeat.o(12811);
    }
    
    private void anb()
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
        this.gzD.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.gzD;
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
      int i = this.gzD.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.gzD.get(paramInt);
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
        paramView = View.inflate(this.mContext, 2131496126, null);
        paramViewGroup = SeeAccessVerifyInfoUI.this.ci(paramView);
      }
      label479:
      for (;;)
      {
        paramViewGroup.gvv.setVisibility(0);
        paramViewGroup.gzG.setVisibility(0);
        com.tencent.mm.av.q.bcV().a(((SeeAccessVerifyInfoUI.a)this.gzD.get(paramInt)).gzC, paramViewGroup.gvv, this.gzE);
        paramViewGroup.gzG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.gzD.get(paramInt)).nickname), paramViewGroup.gzG.getTextSize()));
        e locale;
        if (as.bjp(((SeeAccessVerifyInfoUI.a)this.gzD.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          locale = new e();
          locale.field_appid = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.gzD.get(paramInt)).dNI);
          locale.field_wordingId = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.gzD.get(paramInt)).gzB);
          locale.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          g.aAi();
          ((PluginOpenIM)g.ah(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(locale.field_wording))
          {
            paramViewGroup.gzH.setVisibility(0);
            paramViewGroup.gzH.setText("＠" + locale.field_wording);
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
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              localObject = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.gzD.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).getDisplayName(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.gzD.get(paramInt)).username);
              }
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(Util.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.gzD.get(paramInt)).username)).arJ();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.gzD.get(paramInt)).username, paramAnonymousView, (String)localObject, true);
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
          paramViewGroup = SeeAccessVerifyInfoUI.this.ci(paramView);
          break;
          if ((!Util.isNullOrNil(locale.field_appid)) && (!Util.isNullOrNil(locale.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(locale.field_wordingId);
            if (!Util.isEqual(paramViewGroup.gzH.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              g.aAg().hqi.a(new com.tencent.mm.openim.b.i(locale.field_appid, locale.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.gzH.setVisibility(4);
          paramViewGroup.gzH.setTag("first");
          continue;
          paramViewGroup.gzH.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView gvv;
    public TextView gzG;
    public TextView gzH;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */