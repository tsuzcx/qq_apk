package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.g, j.a, j.b
{
  private final String TAG;
  private String dcO;
  private EmojiInfo fPB;
  private String fvZ;
  private ListView mListView;
  private com.tencent.mm.sdk.b.c pdV;
  private com.tencent.mm.plugin.emoji.f.g pdW;
  private boolean peA;
  private Runnable peB;
  private Runnable peC;
  private com.tencent.mm.sdk.b.c peD;
  com.tencent.mm.plugin.emoji.a.f ped;
  private View pee;
  private ImageView pef;
  private TextView peg;
  private TextView peh;
  private awf pei;
  private EmotionDetail pej;
  private String pek;
  long pel;
  private ScaleRelativeLayout pem;
  private TextView pen;
  private BaseEmojiView peo;
  private ViewGroup pep;
  private ImageView peq;
  private TextView per;
  private TextView pes;
  private Button pet;
  private com.tencent.mm.plugin.emoji.model.j peu;
  private awn pev;
  private long pew;
  String pex;
  private String pey;
  private String pez;
  private int scene;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.pej = new EmotionDetail();
    this.peA = false;
    this.peB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).JC()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.peC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.pdV = new com.tencent.mm.sdk.b.c() {};
    this.peD = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108809);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108820);
    if ((bs.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108820);
      return;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.Jsq) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.Jsp) && ((paramEmojiInfo.field_type != EmojiInfo.Kgb) || (paramEmojiInfo.field_type != EmojiInfo.Kgc)) && (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYb.aOP(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.ped != null)
      {
        this.ped.oXu = this.peA;
        this.ped.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void cdk()
  {
    AppMethodBeat.i(108816);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx.Name);
          if (bs.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx.IconUrl)) {
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          for (;;)
          {
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setText(2131758204);
            CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108791);
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx.EwR);
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
            o.aFB().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx.IconUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fm(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).EOx.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.Name);
          o.aFB().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.HeadUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fl(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.HeadUrl));
          CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
          AppMethodBeat.o(108792);
          return;
        }
        CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(8);
        AppMethodBeat.o(108792);
      }
    });
    AppMethodBeat.o(108816);
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c cdl()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.pej.CoverUrl;
    localEmotionSummary.IconUrl = this.pej.IconUrl;
    localEmotionSummary.PackName = this.pej.PackName;
    localEmotionSummary.PackFlag = this.pej.PackFlag;
    localEmotionSummary.PackDesc = this.pej.PackDesc;
    localEmotionSummary.PackExpire = this.pej.PackExpire;
    localEmotionSummary.PackType = this.pej.PackType;
    localEmotionSummary.PackPrice = this.pej.PackPrice;
    localEmotionSummary.PriceNum = this.pej.PriceNum;
    localEmotionSummary.PriceType = this.pej.PriceType;
    localEmotionSummary.ProductID = this.pej.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.cbx())) {}
    for (String str1 = "";; str1 = parama.cbx())
    {
      ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cbw()) });
      this.peu.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void cci() {}
  
  public int getLayoutId()
  {
    return 2131493679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.pel = ce.azH();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.pew = getIntent().getLongExtra("msg_id", 0L);
    this.pex = getIntent().getStringExtra("msg_sender");
    this.pey = getIntent().getStringExtra("msg_content");
    this.fvZ = getIntent().getStringExtra("room_id");
    this.pez = getIntent().getStringExtra("talker_username");
    ac.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = bs.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      ac.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.pem = ((ScaleRelativeLayout)findViewById(2131299426));
    this.pen = ((TextView)findViewById(2131298906));
    this.peo = ((BaseEmojiView)findViewById(2131298907));
    localObject1 = findViewById(2131299421);
    ((ImageView)findViewById(2131299422)).setImageDrawable(am.k(this, 2131690116, -1));
    if ((com.tencent.mm.sdk.a.b.eUk()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      this.peo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108802);
          ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).fWN) });
          AppMethodBeat.o(108802);
        }
      });
    }
    this.fPB = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(str1);
    if (this.fPB == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.fOZ;
    com.tencent.mm.emoji.loader.e.a(this.fPB, this.peo, null);
    if (com.tencent.mm.plugin.emoji.h.b.z(this.fPB)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.pem.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.aNk = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.pmv = (localScaleRelativeLayout.aNk * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(this.fPB.JC());
      if ((this.pen != null) && (!bs.isNullOrNil((String)localObject1)))
      {
        this.pen.setText((CharSequence)localObject1);
        this.peo.setContentDescription((CharSequence)localObject1);
      }
      this.pep = ((ViewGroup)findViewById(2131299424));
      this.peq = ((ImageView)findViewById(2131299423));
      this.per = ((TextView)findViewById(2131299427));
      this.pes = ((TextView)findViewById(2131299425));
      this.pet = ((Button)findViewById(2131299420));
      ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.fPB.field_lensId });
      this.pep.setVisibility(8);
      if (!bs.isNullOrNil(this.fPB.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.fPB.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final bpl paramAnonymousbpl)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymousbpl == null) {}
            for (String str = "";; str = paramAnonymousbpl.Ewy)
            {
              ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymousbpl != null)
                  {
                    CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.GAX;
                    com.tencent.mm.sticker.loader.h.getLoader().bG(new com.tencent.mm.sticker.loader.a(paramAnonymousbpl)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setText(paramAnonymousbpl.Name);
                    if (bs.isNullOrNil(paramAnonymousbpl.EOk.Name)) {
                      break label160;
                    }
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymousbpl.EOk.Name);
                  }
                  for (;;)
                  {
                    CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymous3View)
                      {
                        AppMethodBeat.i(108806);
                        com.tencent.mm.plugin.emojicapture.api.b.w(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).JC(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this));
                        AppMethodBeat.o(108806);
                      }
                    });
                    AppMethodBeat.o(108807);
                    return;
                    label160:
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(8);
                  }
                }
              });
              AppMethodBeat.o(108808);
              return;
            }
          }
        });
      }
      localObject3 = getIntent().getStringExtra("custom_smiley_preview_appid");
      getIntent().getStringExtra("custom_smiley_preview_appname");
      localObject1 = (TextView)findViewById(2131296934);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.k((String)localObject3, true, false);
      if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName != null)) {
        ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.dcO = this.fPB.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.k(this.dcO);
      com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.ped = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.ped.oYa = this;
      this.ped.oXt = true;
      this.ped.oXw = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.ped);
      this.ped.oXY = this.mListView;
      if (!bs.isNullOrNil(this.dcO))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYd.aPc(this.dcO);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new GetEmotionDetailResponse();
        }
      }
      try
      {
        ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.pej = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
        this.pek = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.pej == null) || (bs.isNullOrNil(this.pek)) || (!this.pek.equalsIgnoreCase(ab.iC(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.dcO, 1);
          com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
          this.peu = new com.tencent.mm.plugin.emoji.model.j();
          this.peu.mHB = this;
          this.peu.paX = this.ped;
          this.peu.pba = 9;
          this.peu.pbd = this;
          this.peA = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYb.aOQ(this.dcO);
          a(this.dcO, this.fPB);
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(108804);
              CustomSmileyPreviewUI.this.finish();
              AppMethodBeat.o(108804);
              return true;
            }
          });
          if ((this.fPB.field_catalog == EmojiInfo.Jsy) || (this.fPB.fxI())) {
            break label1544;
          }
          bool1 = true;
          boolean bool2;
          if ((this.fPB.field_catalog != EmojiInfo.Jsy) && (!bs.isNullOrNil(this.fPB.field_groupId)))
          {
            bool2 = bool1;
            if (!bs.isNullOrNil(this.fPB.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(this.fPB.field_groupId)) {}
            }
          }
          else
          {
            bool2 = true;
          }
          addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(108805);
              CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this);
              AppMethodBeat.o(108805);
              return true;
            }
          });
          showOptionMenu(bool2);
          this.pee = findViewById(2131299016);
          this.pef = ((ImageView)this.pee.findViewById(2131299022));
          this.peg = ((TextView)this.pee.findViewById(2131299032));
          this.peh = ((TextView)this.pee.findViewById(2131299020));
          this.pee.setVisibility(8);
          if ((this.fPB != null) && (!bs.isNullOrNil(this.fPB.field_designerID)))
          {
            localObject1 = this.fPB.field_designerID;
            this.pei = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYf.aPa((String)localObject1);
            localObject1 = new i(this.fPB.field_designerID);
            com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
          }
          if ((this.fPB != null) && (!bs.isNullOrNil(this.fPB.field_activityid)))
          {
            localObject1 = this.fPB.field_activityid;
            this.pev = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.aPg((String)localObject1);
            localObject1 = this.fPB.field_activityid;
            localObject3 = this.fPB.field_md5;
            if ((this.pev != null) && ((this.pev == null) || (this.pev.EOx == null) || (this.pev.EOx.EwS >= System.currentTimeMillis() / 1000L))) {
              break label1510;
            }
            localObject1 = new com.tencent.mm.plugin.emoji.f.j((String)localObject1, (String)localObject3);
            com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
          }
          cdk();
          this.pee.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(108790);
              if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk != null))
              {
                Object localObject = new Intent();
                ((Intent)localObject).setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.DesignerUin);
                ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.Name);
                ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).EOk.HeadUrl);
                ((Intent)localObject).putExtra("extra_scence", 9);
                paramAnonymousView = CustomSmileyPreviewUI.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(108790);
                return;
              }
              ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
              AppMethodBeat.o(108790);
            }
          });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
          String str2 = this.dcO;
          if (this.fPB != null) {
            break label1521;
          }
          localObject1 = "";
          if (this.fPB != null) {
            break label1532;
          }
          localObject3 = "";
          localh.f(12067, new Object[] { Integer.valueOf(2), str2, str1, localObject1, localObject3 });
          AppMethodBeat.o(108815);
          return;
          ((View)localObject1).setVisibility(8);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bs.m(localIOException) });
          continue;
          Object localObject2 = cdl();
          if (this.ped != null) {
            this.ped.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.l(this.dcO, 1, this.pej.Version);
          com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject2, 0);
          continue;
          label1510:
          ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
          continue;
          label1521:
          localObject2 = this.fPB.field_designerID;
          continue;
          label1532:
          localObject3 = this.fPB.field_activityid;
          continue;
          label1544:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108822);
    this.pdW = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdW, 0);
    AppMethodBeat.o(108822);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agQ().ghe.a(412, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(521, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(239, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(368, this);
    com.tencent.mm.sdk.b.a.GpY.c(this.pdV);
    com.tencent.mm.sdk.b.a.GpY.c(this.peD);
    initView();
    String str = "";
    paramBundle = str;
    if (this.pei != null)
    {
      paramBundle = str;
      if (this.pei.EOk != null) {
        paramBundle = p.getString(this.pei.EOk.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12740, new Object[] { Integer.valueOf(4), paramBundle, this.fPB.field_groupId, "", Integer.valueOf(this.scene), Integer.valueOf(9), "", "", "", this.pel });
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.g.agQ().ghe.b(412, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(521, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(411, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(239, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(368, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.pdV);
    com.tencent.mm.sdk.b.a.GpY.d(this.peD);
    super.onDestroy();
    ap.aB(this.peB);
    ap.aB(this.peC);
    com.tencent.mm.plugin.report.service.h.wUl.f(12789, new Object[] { Integer.valueOf(7), this.fPB.JC(), Integer.valueOf(1), this.fPB.field_designerID, this.fPB.field_groupId, this.pex, "", "", "", this.fPB.field_activityid, Long.valueOf(this.pel) });
    AppMethodBeat.o(108814);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    if ((this.ped == null) || (paramInt < 0) || (paramInt >= this.ped.getCount()))
    {
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12789, new Object[] { Integer.valueOf(4), this.fPB.JC(), Integer.valueOf(1), this.fPB.field_designerID, this.fPB.field_groupId, "", "", "", "", this.fPB.field_activityid, Long.valueOf(this.pel) });
    paramAdapterView = this.ped.Bk(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    Object localObject = paramAdapterView.oYl;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.aeD(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108823);
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
      paramView.putExtra("extra_progress", paramAdapterView.FG);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bs.isNullOrNil((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108813);
    super.onPause();
    AppMethodBeat.o(108813);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108811);
    super.onResume();
    AppMethodBeat.o(108811);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(108818);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108818);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.l))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramn;
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.pej = paramString.ccC();
            if ((this.pej != null) && (!TextUtils.isEmpty(this.dcO)) && (this.dcO.equals(this.pej.ProductID)))
            {
              paramString = cdl();
              if (this.ped != null) {
                this.ped.a(paramString);
              }
              ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pej.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramn = this.dcO;
            if (this.pej == null) {}
            for (paramString = "";; paramString = this.pej.ProductID)
            {
              ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramn, paramString });
              AppMethodBeat.o(108818);
              return;
            }
          }
          if (paramInt2 == 1) {
            AppMethodBeat.o(108818);
          }
        }
        else if (paramInt2 == 5)
        {
          if ((this.pej != null) && (paramString.ccC() != null) && (!TextUtils.isEmpty(this.dcO)) && (this.dcO.equals(this.pej.ProductID)) && (this.pej.PackFlag != paramString.ccC().PackFlag))
          {
            this.pej.PackFlag = paramString.ccC().PackFlag;
            paramString = cdl();
            if (this.ped != null) {
              this.ped.a(paramString);
            }
            ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pej.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramn = this.dcO;
          if (this.pej == null) {}
          for (paramString = "";; paramString = this.pej.ProductID)
          {
            ac.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramn, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            ap.f(this.peC);
            ap.n(this.peB, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
            {
              paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
              com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYc.a(12, paramString.ccF());
              AppMethodBeat.o(108818);
              return;
              this.pei = ((i)paramn).ccA();
              cdk();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.j)paramn;
                paramn = (awn)paramString.rr.hvs.hvw;
                if ((paramn != null) && (paramn.EOx != null))
                {
                  paramn.EOx.EwS = ((int)(System.currentTimeMillis() / 1000L) + paramn.EOx.EwS);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GYc.a(paramString.pcl, paramn);
                }
                this.pev = paramn;
                cdk();
                AppMethodBeat.o(108818);
                return;
              }
              ac.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(108812);
    super.onStart();
    AppMethodBeat.o(108812);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */