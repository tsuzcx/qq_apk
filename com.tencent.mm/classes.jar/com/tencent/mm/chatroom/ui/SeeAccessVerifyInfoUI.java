package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String lCS;
  private b lLJ;
  private String lLK;
  private String lLL;
  private String lLM;
  private String lLN;
  private String lLO;
  private String lLP;
  private String lLQ;
  private String lLR;
  private String lLS;
  private long lLT;
  private long lLU;
  private String lLV;
  private String lLW;
  private TextView lLX;
  private TextView lLY;
  private ImageView lLZ;
  private TextView lMa;
  private TextView lMb;
  private TextView lMc;
  private GridView lMd;
  private boolean lMe = false;
  private boolean lMf = false;
  private boolean lMg = false;
  private aj lzy;
  private w tipDialog;
  
  protected final c cV(View paramView)
  {
    AppMethodBeat.i(12821);
    c localc = new c();
    localc.lBC = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.lKP = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    localc.lMo = ((TextView)paramView.findViewById(a.e.roominfo_contact_sub_detail));
    AppMethodBeat.o(12821);
    return localc;
  }
  
  public int getLayoutId()
  {
    return a.f.lGv;
  }
  
  public void initView()
  {
    Object localObject1 = null;
    AppMethodBeat.i(12819);
    this.lLX = ((TextView)findViewById(a.e.lEU));
    this.lLY = ((TextView)findViewById(a.e.lET));
    this.lMa = ((TextView)findViewById(a.e.roominfo_contact_name_for_span));
    this.lMb = ((TextView)findViewById(a.e.roominfo_contact_sub_detail));
    this.lLZ = ((ImageView)findViewById(a.e.roominfo_img));
    this.lMc = ((TextView)findViewById(a.e.lEj));
    this.lMd = ((GridView)findViewById(a.e.lEl));
    this.lMd.setAdapter(this.lLJ);
    if (this.lLZ != null) {
      this.lLZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12805);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(Util.nullAsNil(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this)));
          String str = localau.field_nickname;
          paramAnonymousView = null;
          if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
            paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).getDisplayName(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this));
          }
          localObject = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            localObject = localau.aSV();
          }
          SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), (String)localObject, str, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12805);
        }
      });
    }
    this.lMd.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.lMd.postDelayed(new Runnable()
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
    if (this.lLZ != null) {
      com.tencent.mm.pluginsdk.ui.a.b.g(this.lLZ, Util.nullAsNil(this.lLQ));
    }
    TextView localTextView1;
    Object localObject2;
    TextView localTextView2;
    if (this.lMa != null)
    {
      localTextView1 = this.lMa;
      localObject2 = Util.nullAsNil(this.lLQ);
      localTextView2 = this.lMa;
      if (localTextView2 != null) {
        break label580;
      }
    }
    label379:
    au localau;
    for (;;)
    {
      localTextView1.setText((CharSequence)localObject1);
      if (this.lMb != null)
      {
        if ((!au.bwF(this.lLV)) || (!au.bwO(this.lLQ))) {
          break label783;
        }
        localObject1 = new com.tencent.mm.openim.e.k();
        ((com.tencent.mm.openim.e.k)localObject1).field_appid = this.lLR;
        ((com.tencent.mm.openim.e.k)localObject1).field_wordingId = this.lLS;
        ((com.tencent.mm.openim.e.k)localObject1).field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        com.tencent.mm.kernel.h.baF();
        ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject1, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(((com.tencent.mm.openim.e.k)localObject1).field_wording)) {
          break label703;
        }
        this.lMb.setVisibility(0);
        this.lMb.setText("＠" + ((com.tencent.mm.openim.e.k)localObject1).field_wording);
      }
      if (this.lLX != null) {
        this.lLX.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.lLP)));
      }
      if ((this.lLY != null) && (!Util.isNullOrNil(this.lLW))) {
        this.lLY.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, "\"" + Util.nullAsNil(this.lLW) + "\""));
      }
      if (this.lMc != null) {
        this.lMc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12809);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = SeeAccessVerifyInfoUI.this;
            localObject = SeeAccessVerifyInfoUI.this.getContext();
            SeeAccessVerifyInfoUI.this.getString(a.i.app_tip);
            SeeAccessVerifyInfoUI.a(paramAnonymousView, com.tencent.mm.ui.base.k.a((Context)localObject, SeeAccessVerifyInfoUI.this.getString(a.i.lGK), false, null));
            if (au.bwF(SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this)))
            {
              paramAnonymousView = new com.tencent.mm.openim.b.a.a(SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this), ",")));
              paramAnonymousView.otr = true;
              paramAnonymousView.bFJ().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12809);
              return;
              paramAnonymousView = new d(SeeAccessVerifyInfoUI.m(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.g(SeeAccessVerifyInfoUI.this), SeeAccessVerifyInfoUI.k(SeeAccessVerifyInfoUI.this), new LinkedList(Util.stringsToList(SeeAccessVerifyInfoUI.l(SeeAccessVerifyInfoUI.this).split(","))));
              paramAnonymousView.otr = true;
              paramAnonymousView.bFJ().a(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a() {});
            }
          }
        });
      }
      if (this.lMc != null)
      {
        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.lLT);
        if ((localObject1 != null) && (((cc)localObject1).jcg()))
        {
          this.lMc.setBackgroundResource(a.d.btn_solid_grey);
          this.lMc.setTextColor(getResources().getColor(a.b.grey_btn_stroke_color_normal));
          this.lMc.setText(getString(a.i.has_approve_info));
          this.lMc.setEnabled(false);
        }
      }
      AppMethodBeat.o(12819);
      return;
      label580:
      localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(Util.nullAsNil((String)localObject2));
      if (localau != null) {
        break;
      }
      Log.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
    }
    if (!Util.isNullOrNil(localau.field_conRemark)) {
      localObject1 = localau.field_conRemark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = localau.field_conRemark;
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = localau.aSU();
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil((String)localObject1), localTextView2.getTextSize());
      break;
      if (this.lzy != null)
      {
        localObject1 = this.lzy.getDisplayName((String)localObject2);
        continue;
        label703:
        if ((!Util.isNullOrNil(this.lLS)) && (!Util.isNullOrNil(this.lLR)))
        {
          this.lMg = true;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(this.lLS);
          com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.openim.model.l(this.lLR, ((com.tencent.mm.openim.e.k)localObject1).field_language, (LinkedList)localObject2), 0);
        }
        this.lMb.setVisibility(4);
        break label379;
        label783:
        this.lMb.setVisibility(8);
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
    setMMTitle(getString(a.i.lGJ));
    this.lLT = getIntent().getLongExtra("msgLocalId", 0L);
    this.lLU = getIntent().getLongExtra("msgSvrId", 0L);
    this.lLP = getIntent().getStringExtra("invitertitle");
    this.lLQ = getIntent().getStringExtra("inviterusername");
    this.lLR = getIntent().getStringExtra("inviterappid");
    this.lLS = getIntent().getStringExtra("inviterdescid");
    this.lLV = getIntent().getStringExtra("chatroom");
    this.lLW = getIntent().getStringExtra("invitationreason");
    this.lCS = getIntent().getStringExtra("ticket");
    this.lLL = getIntent().getStringExtra("username");
    this.lLK = getIntent().getStringExtra("nickname");
    this.lLM = getIntent().getStringExtra("descid");
    this.lLN = getIntent().getStringExtra("appid");
    this.lLO = getIntent().getStringExtra("headimgurl");
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(Util.nullAsNil(this.lLV));
    this.lLJ = new b(this);
    paramBundle = this.lLL.split(",");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      paramBundle = paramBundle[0];
      Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", new Object[] { paramBundle, this.lLV });
      if ((this.lzy.bHw() != null) && (this.lzy.bHw().contains(paramBundle)))
      {
        paramBundle = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.lLT);
        if ((paramBundle != null) && (!paramBundle.jcg()))
        {
          paramBundle.jce();
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.lLT, paramBundle);
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
    com.tencent.mm.kernel.h.baD().mCm.b(453, this);
    AppMethodBeat.o(12818);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12817);
    Log.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
    com.tencent.mm.kernel.h.baD().mCm.a(453, this);
    super.onResume();
    AppMethodBeat.o(12817);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(12820);
    if (((paramp instanceof com.tencent.mm.openim.model.l)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.lMg) && (Util.isNullOrNil(this.lMb.getText())))
      {
        this.lMg = false;
        paramString = new com.tencent.mm.openim.e.k();
        paramString.field_appid = this.lLR;
        paramString.field_wordingId = this.lLS;
        paramString.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        com.tencent.mm.kernel.h.baF();
        ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get(paramString, new String[] { "appid", "wordingId", "language" });
        if (TextUtils.isEmpty(paramString.field_wording)) {
          break label190;
        }
        this.lMb.setVisibility(0);
        this.lMb.setText("＠" + paramString.field_wording);
      }
    }
    for (;;)
    {
      if (this.lMf) {
        this.lLJ.notifyDataSetChanged();
      }
      AppMethodBeat.o(12820);
      return;
      label190:
      if ((!Util.isNullOrNil(this.lLS)) && (!Util.isNullOrNil(this.lLR)))
      {
        paramp = new LinkedList();
        paramp.add(this.lLS);
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.openim.model.l(this.lLR, paramString.field_language, paramp), 0);
      }
      this.lMb.setVisibility(4);
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
    String lMj;
    String lMk;
    String nickname;
    String username;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.username = paramString1;
      this.nickname = paramString2;
      this.appid = paramString3;
      this.lMj = paramString4;
      this.lMk = paramString5;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeAccessVerifyInfoUI.a> lMl;
    private com.tencent.mm.modelimage.loader.a.c lMm;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12811);
      this.lMl = new ArrayList();
      this.lMm = null;
      this.mContext = paramContext;
      aNk();
      this$1 = new c.a();
      SeeAccessVerifyInfoUI.this.oKp = true;
      SeeAccessVerifyInfoUI.this.nqa = true;
      SeeAccessVerifyInfoUI.this.oKB = a.h.default_avatar;
      this.lMm = SeeAccessVerifyInfoUI.this.bKx();
      AppMethodBeat.o(12811);
    }
    
    private void aNk()
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
        this.lMl.clear();
        i = 0;
        if (i >= arrayOfString4.length) {
          break label403;
        }
        localList = this.lMl;
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
      int i = this.lMl.size();
      AppMethodBeat.o(12813);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(12814);
      Object localObject = this.lMl.get(paramInt);
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
        paramViewGroup = SeeAccessVerifyInfoUI.this.cV(paramView);
      }
      label480:
      for (;;)
      {
        paramViewGroup.lBC.setVisibility(0);
        paramViewGroup.lKP.setVisibility(0);
        r.bKe().a(((SeeAccessVerifyInfoUI.a)this.lMl.get(paramInt)).lMk, paramViewGroup.lBC, this.lMm);
        paramViewGroup.lKP.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.mContext, Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.lMl.get(paramInt)).nickname), paramViewGroup.lKP.getTextSize()));
        com.tencent.mm.openim.e.k localk;
        if (au.bwO(((SeeAccessVerifyInfoUI.a)this.lMl.get(paramInt)).username))
        {
          SeeAccessVerifyInfoUI.r(SeeAccessVerifyInfoUI.this);
          localk = new com.tencent.mm.openim.e.k();
          localk.field_appid = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.lMl.get(paramInt)).appid);
          localk.field_wordingId = Util.nullAsNil(((SeeAccessVerifyInfoUI.a)this.lMl.get(paramInt)).lMj);
          localk.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          com.tencent.mm.kernel.h.baF();
          ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get(localk, new String[] { "appid", "wordingId", "language" });
          if (!TextUtils.isEmpty(localk.field_wording))
          {
            paramViewGroup.lMo.setVisibility(0);
            paramViewGroup.lMo.setText("＠" + localk.field_wording);
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
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeAccessVerifyInfoUI$InviteesAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              localObject = ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.lMl.get(paramInt)).nickname;
              paramAnonymousView = null;
              if (SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this) != null) {
                paramAnonymousView = SeeAccessVerifyInfoUI.b(SeeAccessVerifyInfoUI.this).getDisplayName(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.lMl.get(paramInt)).username);
              }
              if (Util.isNullOrNil(paramAnonymousView)) {
                paramAnonymousView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(Util.nullAsNil(((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.lMl.get(paramInt)).username)).aSV();
              }
              for (;;)
              {
                SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((SeeAccessVerifyInfoUI.a)SeeAccessVerifyInfoUI.b.this.lMl.get(paramInt)).username, paramAnonymousView, (String)localObject, true);
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
          paramViewGroup = SeeAccessVerifyInfoUI.this.cV(paramView);
          break;
          if ((!Util.isNullOrNil(localk.field_appid)) && (!Util.isNullOrNil(localk.field_wordingId)))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(localk.field_wordingId);
            if (!Util.isEqual(paramViewGroup.lMo.getTag(), "first"))
            {
              SeeAccessVerifyInfoUI.s(SeeAccessVerifyInfoUI.this);
              com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.openim.model.l(localk.field_appid, localk.field_language, localLinkedList), 0);
            }
          }
          paramViewGroup.lMo.setVisibility(4);
          paramViewGroup.lMo.setTag("first");
          continue;
          paramViewGroup.lMo.setVisibility(8);
        }
      }
    }
  }
  
  final class c
  {
    public ImageView lBC;
    public TextView lKP;
    public TextView lMo;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI
 * JD-Core Version:    0.7.0.1
 */