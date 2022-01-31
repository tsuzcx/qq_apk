package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ai.f, h.a, h.b
{
  private final String TAG;
  private String cqx;
  private String egF;
  private EmojiInfo evH;
  private ajr lkA;
  private EmotionDetail lkB;
  private String lkC;
  private ScaleRelativeLayout lkD;
  private TextView lkE;
  private BaseEmojiView lkF;
  private com.tencent.mm.plugin.emoji.model.h lkG;
  private ajx lkH;
  private long lkI;
  String lkJ;
  private String lkK;
  private boolean lkL;
  private Runnable lkM;
  private Runnable lkN;
  private com.tencent.mm.sdk.b.c lkO;
  private com.tencent.mm.sdk.b.c lkn;
  private com.tencent.mm.plugin.emoji.f.g lko;
  com.tencent.mm.plugin.emoji.a.f lkv;
  private View lkw;
  private ImageView lkx;
  private TextView lky;
  private TextView lkz;
  private ListView mListView;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(53240);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.lkB = new EmotionDetail();
    this.lkL = false;
    this.lkM = new CustomSmileyPreviewUI.1(this);
    this.lkN = new CustomSmileyPreviewUI.8(this);
    this.lkn = new CustomSmileyPreviewUI.9(this);
    this.lkO = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(53240);
  }
  
  private static void a(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, TextView paramTextView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(53256);
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)paramCustomSmileyPreviewUI.getResources().getDimension(2131427758);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
    AppMethodBeat.o(53256);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53259);
    if ((bo.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(53259);
      return;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.yPe) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.yPd) && ((paramEmojiInfo.field_type != EmojiInfo.yPq) || (paramEmojiInfo.field_type != EmojiInfo.yPr)) && (com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNp.asM(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.lkv != null)
      {
        this.lkv.lej = this.lkL;
        this.lkv.notifyDataSetChanged();
        AppMethodBeat.o(53259);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(53259);
  }
  
  private void bmm()
  {
    AppMethodBeat.i(53252);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138339);
        if ((CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).xbj != null))
        {
          CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).xbj.Name);
          if (bo.isNullOrNil(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).xbj.IconUrl)) {
            CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          for (;;)
          {
            CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setText(2131299093);
            CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setOnClickListener(new CustomSmileyPreviewUI.2.1(this));
            CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(138339);
            return;
            CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this).setVisibility(0);
            o.ahG().a(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).xbj.IconUrl, CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.g.dM(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).xbj.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).xbf != null))
        {
          CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).xbf.Name);
          o.ahG().a(CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).xbf.HeadUrl, CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.g.dL(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).xbf.HeadUrl));
          CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).setVisibility(8);
          AppMethodBeat.o(138339);
          return;
        }
        CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setVisibility(8);
        AppMethodBeat.o(138339);
      }
    });
    AppMethodBeat.o(53252);
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c bmn()
  {
    AppMethodBeat.i(53258);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.lkB.CoverUrl;
    localEmotionSummary.IconUrl = this.lkB.IconUrl;
    localEmotionSummary.PackName = this.lkB.PackName;
    localEmotionSummary.PackFlag = this.lkB.PackFlag;
    localEmotionSummary.PackDesc = this.lkB.PackDesc;
    localEmotionSummary.PackExpire = this.lkB.PackExpire;
    localEmotionSummary.PackType = this.lkB.PackType;
    localEmotionSummary.PackPrice = this.lkB.PackPrice;
    localEmotionSummary.PriceNum = this.lkB.PriceNum;
    localEmotionSummary.PriceType = this.lkB.PriceType;
    localEmotionSummary.ProductID = this.lkB.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(53258);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(53260);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.bku())) {}
    for (String str1 = "";; str1 = parama.bku())
    {
      ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.bkt()) });
      this.lkG.a(parama);
      AppMethodBeat.o(53260);
      return;
    }
  }
  
  public final void blm() {}
  
  public int getLayoutId()
  {
    return 2130969291;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(53261);
    this.lko = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lko, 0);
    AppMethodBeat.o(53261);
  }
  
  public void initView()
  {
    AppMethodBeat.i(53262);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.lkI = getIntent().getLongExtra("msg_id", 0L);
    this.lkJ = getIntent().getStringExtra("msg_sender");
    this.lkK = getIntent().getStringExtra("msg_content");
    this.egF = getIntent().getStringExtra("room_id");
    ab.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str = bo.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str))
    {
      ab.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.lkD = ((ScaleRelativeLayout)findViewById(2131823291));
    this.lkE = ((TextView)findViewById(2131823294));
    this.lkF = ((BaseEmojiView)findViewById(2131821487));
    localObject1 = findViewById(2131823292);
    ((ImageView)findViewById(2131823293)).setImageDrawable(aj.g(this, 2131231272, -1));
    if ((com.tencent.mm.sdk.a.b.dsf()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)) {
      this.lkF.setOnClickListener(new CustomSmileyPreviewUI.11(this));
    }
    this.evH = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(str);
    if (this.evH == null) {
      finish();
    }
    label287:
    Object localObject4;
    Object localObject3;
    Object localObject5;
    label435:
    int i;
    if (this.evH.dzn())
    {
      this.lkF.setEmojiInfo(this.evH);
      if (!com.tencent.mm.plugin.emoji.h.b.z(this.evH)) {
        break label1112;
      }
      ((View)localObject1).setVisibility(0);
      this.lkD.post(new CustomSmileyPreviewUI.12(this));
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(this.evH.Al());
      if ((this.lkE != null) && (!bo.isNullOrNil((String)localObject1)))
      {
        this.lkE.setText((CharSequence)localObject1);
        this.lkF.setContentDescription((CharSequence)localObject1);
      }
      localObject4 = getIntent().getStringExtra("custom_smiley_preview_appid");
      localObject1 = getIntent().getStringExtra("custom_smiley_preview_appname");
      localObject3 = (TextView)findViewById(2131821490);
      localObject5 = com.tencent.mm.pluginsdk.model.app.g.ca((String)localObject4, true);
      if ((localObject5 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName.trim().length() > 0)) {
        break label1122;
      }
      if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
        break label1156;
      }
      if ((localObject1 != null) && (((String)localObject1).trim().length() != 0) && (!((String)localObject1).equals("weixinfile")) && (!((String)localObject1).equals("invalid_appname"))) {
        break label1132;
      }
      i = 0;
      label488:
      if (i == 0) {
        break label1156;
      }
      ((TextView)localObject3).setText(getString(2131299180, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(getContext(), (com.tencent.mm.pluginsdk.model.app.f)localObject5, (String)localObject1) }));
      ((TextView)localObject3).setVisibility(0);
      ((View)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(138342);
          if (bo.isNullOrNil(this.gjT))
          {
            AppMethodBeat.o(138342);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", this.gjT);
          com.tencent.mm.bq.d.b(CustomSmileyPreviewUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(138342);
        }
      });
      localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((String)localObject4, 2, com.tencent.mm.cb.a.getDensity(this));
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        break label1137;
      }
      a(this, (TextView)localObject3, (Bitmap)localObject1);
      label583:
      setBackBtn(new CustomSmileyPreviewUI.13(this));
      if ((this.evH.field_catalog == EmojiInfo.yPm) || (this.evH.dzq())) {
        break label1618;
      }
    }
    label1034:
    label1594:
    label1606:
    label1618:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if ((this.evH.field_catalog != EmojiInfo.yPm) && (!bo.isNullOrNil(this.evH.field_groupId)))
      {
        bool2 = bool1;
        if (!bo.isNullOrNil(this.evH.field_groupId))
        {
          bool2 = bool1;
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(this.evH.field_groupId)) {}
        }
      }
      else
      {
        bool2 = true;
      }
      addIconOptionMenu(0, 2130839668, new CustomSmileyPreviewUI.14(this));
      showOptionMenu(bool2);
      this.lkw = findViewById(2131823653);
      this.lkx = ((ImageView)this.lkw.findViewById(2131823654));
      this.lky = ((TextView)this.lkw.findViewById(2131823655));
      this.lkz = ((TextView)this.lkw.findViewById(2131823656));
      this.lkw.setVisibility(8);
      if ((this.evH != null) && (!bo.isNullOrNil(this.evH.field_designerID)))
      {
        localObject1 = this.evH.field_designerID;
        this.lkA = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNt.asU((String)localObject1);
        localObject1 = new com.tencent.mm.plugin.emoji.f.i(this.evH.field_designerID);
        com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
      }
      if ((this.evH != null) && (!bo.isNullOrNil(this.evH.field_activityid)))
      {
        localObject1 = this.evH.field_activityid;
        this.lkH = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNq.ata((String)localObject1);
        localObject1 = this.evH.field_activityid;
        localObject3 = this.evH.field_md5;
        if ((this.lkH == null) || ((this.lkH != null) && (this.lkH.xbj != null) && (this.lkH.xbj.wQC < System.currentTimeMillis() / 1000L)))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.j((String)localObject1, (String)localObject3);
          com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
        }
      }
      else
      {
        label993:
        bmm();
        this.lkw.setOnClickListener(new CustomSmileyPreviewUI.15(this));
        localObject4 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject5 = this.cqx;
        if (this.evH != null) {
          break label1594;
        }
        localObject1 = "";
        if (this.evH != null) {
          break label1606;
        }
      }
      for (localObject3 = "";; localObject3 = this.evH.field_activityid)
      {
        for (;;)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject4).e(12067, new Object[] { Integer.valueOf(2), localObject5, str, localObject1, localObject3 });
          AppMethodBeat.o(53262);
          return;
          localObject3 = com.tencent.mm.emoji.loader.a.evk;
          com.tencent.mm.emoji.loader.a.a(this.evH, this.lkF, null);
          break;
          label1112:
          ((View)localObject1).setVisibility(8);
          break label287;
          label1122:
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName;
          break label435;
          label1132:
          i = 1;
          break label488;
          label1137:
          a(this, (TextView)localObject3, BitmapFactory.decodeResource(getResources(), 2130839824));
          break label583;
          ((TextView)localObject3).setVisibility(8);
          this.cqx = this.evH.field_groupId;
          localObject1 = new k(this.cqx);
          com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
          this.mListView = ((ListView)findViewById(16908298));
          this.lkv = new com.tencent.mm.plugin.emoji.a.f(getContext());
          this.lkv.leP = this;
          this.lkv.lei = true;
          this.lkv.lel = false;
          this.mListView.setOnItemClickListener(this);
          this.mListView.setAdapter(this.lkv);
          this.lkv.leN = this.mListView;
          if (!bo.isNullOrNil(this.cqx))
          {
            localObject1 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNr.asW(this.cqx);
            if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.i)localObject1).field_content != null)) {
              localObject3 = new GetEmotionDetailResponse();
            }
          }
          try
          {
            ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.i)localObject1).field_content);
            this.lkB = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
            this.lkC = ((com.tencent.mm.storage.emotion.i)localObject1).field_lan;
            if ((this.lkB == null) || (bo.isNullOrNil(this.lkC)) || (!this.lkC.equalsIgnoreCase(aa.gP(getContext()))))
            {
              localObject1 = new l(this.cqx, 1);
              com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
              this.lkG = new com.tencent.mm.plugin.emoji.model.h();
              this.lkG.jpJ = this;
              this.lkG.lhv = this.lkv;
              this.lkG.lhy = 9;
              this.lkG.lhB = this;
              this.lkL = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNp.asN(this.cqx);
              a(this.cqx, this.evH);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ab.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bo.l(localIOException) });
              continue;
              localObject2 = bmn();
              if (this.lkv != null) {
                this.lkv.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
              }
              localObject2 = new l(this.cqx, 1, this.lkB.Version);
              com.tencent.mm.kernel.g.RK().eHt.a((m)localObject2, 0);
            }
          }
        }
        ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
        break label993;
        Object localObject2 = this.evH.field_designerID;
        break label1034;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53241);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RK().eHt.a(412, this);
    com.tencent.mm.kernel.g.RK().eHt.a(521, this);
    com.tencent.mm.kernel.g.RK().eHt.a(411, this);
    com.tencent.mm.kernel.g.RK().eHt.a(239, this);
    com.tencent.mm.kernel.g.RK().eHt.a(368, this);
    com.tencent.mm.sdk.b.a.ymk.c(this.lkn);
    com.tencent.mm.sdk.b.a.ymk.c(this.lkO);
    initView();
    String str = "";
    paramBundle = str;
    if (this.lkA != null)
    {
      paramBundle = str;
      if (this.lkA.xbf != null) {
        paramBundle = com.tencent.mm.a.p.getString(this.lkA.xbf.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(12740, new Object[] { Integer.valueOf(4), paramBundle, this.evH.field_groupId, "", Integer.valueOf(9), Integer.valueOf(9) });
    AppMethodBeat.o(53241);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53245);
    com.tencent.mm.kernel.g.RK().eHt.b(412, this);
    com.tencent.mm.kernel.g.RK().eHt.b(521, this);
    com.tencent.mm.kernel.g.RK().eHt.b(411, this);
    com.tencent.mm.kernel.g.RK().eHt.b(239, this);
    com.tencent.mm.kernel.g.RK().eHt.b(368, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.lkn);
    com.tencent.mm.sdk.b.a.ymk.d(this.lkO);
    super.onDestroy();
    al.ae(this.lkM);
    al.ae(this.lkN);
    AppMethodBeat.o(53245);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53263);
    if ((this.lkv == null) || (paramInt < 0) || (paramInt >= this.lkv.getCount()))
    {
      AppMethodBeat.o(53263);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(12789, new Object[] { Integer.valueOf(4), this.evH.Al(), Integer.valueOf(1), this.evH.field_designerID, this.evH.field_groupId, "", "", "", "", this.evH.field_activityid });
    paramAdapterView = this.lkv.uj(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    Object localObject = paramAdapterView.lfa;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      startActivity(paramAdapterView);
      AppMethodBeat.o(53263);
      return;
      paramView.putExtra("extra_id", ((EmotionSummary)localObject).ProductID);
      paramView.putExtra("extra_name", ((EmotionSummary)localObject).PackName);
      paramView.putExtra("extra_copyright", ((EmotionSummary)localObject).PackCopyright);
      paramView.putExtra("extra_coverurl", ((EmotionSummary)localObject).CoverUrl);
      paramView.putExtra("extra_description", ((EmotionSummary)localObject).PackDesc);
      paramView.putExtra("extra_price", ((EmotionSummary)localObject).PackPrice);
      paramView.putExtra("extra_type", ((EmotionSummary)localObject).PackType);
      paramView.putExtra("extra_flag", ((EmotionSummary)localObject).PackFlag);
      paramView.putExtra("preceding_scence", 4);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("download_entrance_scene", 9);
      paramView.putExtra("check_clickflag", true);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.ym);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bo.isNullOrNil((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53244);
    super.onPause();
    AppMethodBeat.o(53244);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53242);
    super.onResume();
    AppMethodBeat.o(53242);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53257);
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53257);
      return;
      if ((paramm instanceof l))
      {
        paramString = (l)paramm;
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.lkB = paramString.blF();
            if ((this.lkB != null) && (!TextUtils.isEmpty(this.cqx)) && (this.cqx.equals(this.lkB.ProductID)))
            {
              paramString = bmn();
              if (this.lkv != null) {
                this.lkv.a(paramString);
              }
              ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.lkB.ProductID);
              AppMethodBeat.o(53257);
              return;
            }
            paramm = this.cqx;
            if (this.lkB == null) {}
            for (paramString = "";; paramString = this.lkB.ProductID)
            {
              ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramm, paramString });
              AppMethodBeat.o(53257);
              return;
            }
          }
          if (paramInt2 == 1) {
            AppMethodBeat.o(53257);
          }
        }
        else if (paramInt2 == 5)
        {
          if ((this.lkB != null) && (paramString.blF() != null) && (!TextUtils.isEmpty(this.cqx)) && (this.cqx.equals(this.lkB.ProductID)) && (this.lkB.PackFlag != paramString.blF().PackFlag))
          {
            this.lkB.PackFlag = paramString.blF().PackFlag;
            paramString = bmn();
            if (this.lkv != null) {
              this.lkv.a(paramString);
            }
            ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.lkB.ProductID);
            AppMethodBeat.o(53257);
            return;
          }
          paramm = this.cqx;
          if (this.lkB == null) {}
          for (paramString = "";; paramString = this.lkB.ProductID)
          {
            ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramm, paramString });
            AppMethodBeat.o(53257);
            return;
          }
          if (paramInt2 == 0)
          {
            al.d(this.lkN);
            al.p(this.lkM, 500L);
            AppMethodBeat.o(53257);
            return;
            if ((paramm instanceof n))
            {
              paramString = (n)paramm;
              com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNq.a(12, paramString.blH());
              AppMethodBeat.o(53257);
              return;
              this.lkA = ((com.tencent.mm.plugin.emoji.f.i)paramm).blD();
              bmm();
              AppMethodBeat.o(53257);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.j)paramm;
                paramm = (ajx)paramString.rr.fsW.fta;
                if ((paramm != null) && (paramm.xbj != null))
                {
                  paramm.xbj.wQC = ((int)(System.currentTimeMillis() / 1000L) + paramm.xbj.wQC);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNq.a(paramString.liI, paramm);
                }
                this.lkH = paramm;
                bmm();
                AppMethodBeat.o(53257);
                return;
              }
              ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(53243);
    super.onStart();
    AppMethodBeat.o(53243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */