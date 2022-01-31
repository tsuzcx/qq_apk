package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ah.f, h.a, h.b
{
  private ListView Nn;
  private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
  private String bJd;
  private String dpj;
  private EmojiInfo hNs;
  private com.tencent.mm.sdk.b.c jbE = new CustomSmileyPreviewUI.6(this);
  private com.tencent.mm.plugin.emoji.f.h jbF;
  com.tencent.mm.plugin.emoji.a.f jbM;
  private View jbN;
  private ImageView jbO;
  private TextView jbP;
  private TextView jbQ;
  private aeu jbR;
  private vj jbS = new vj();
  private String jbT;
  private ScaleRelativeLayout jbU;
  private TextView jbV;
  private MMEmojiView jbW;
  private com.tencent.mm.plugin.emoji.model.h jbX;
  private afa jbY;
  private final int jbZ = 131077;
  protected final int jbt = 131074;
  private final int jbu = 131075;
  private final int jbv = 131076;
  private final String jbw = "product_id";
  private final String jbx = "progress";
  private final String jby = "status";
  private long jca;
  String jcb;
  private String jcc;
  private boolean jcd = false;
  private com.tencent.mm.sdk.b.c jce = new CustomSmileyPreviewUI.7(this);
  ah mHandler = new CustomSmileyPreviewUI.1(this);
  
  private static void a(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)paramCustomSmileyPreviewUI.getResources().getDimension(f.c.HintTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    if ((bk.bl(paramString)) || (paramEmojiInfo == null)) {}
    do
    {
      do
      {
        return;
        if ((bk.bl(paramString)) || (paramEmojiInfo.field_catalog == EmojiGroupInfo.uCR) || (paramEmojiInfo.field_catalog == EmojiGroupInfo.uCQ) || ((paramEmojiInfo.field_type == EmojiInfo.uDd) && (paramEmojiInfo.field_type == EmojiInfo.uDe)) || (!com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBd.acz(paramString))) {
          break;
        }
        if (this.Nn != null) {
          this.Nn.setVisibility(0);
        }
      } while (this.jbM == null);
      this.jbM.iVf = this.jcd;
      this.jbM.notifyDataSetChanged();
      return;
    } while (this.Nn == null);
    this.Nn.setVisibility(8);
  }
  
  private void aIO()
  {
    this.mHandler.post(new CustomSmileyPreviewUI.2(this));
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c aIP()
  {
    ArrayList localArrayList = new ArrayList();
    vn localvn = new vn();
    localvn.sSk = this.jbS.sSk;
    localvn.kSy = this.jbS.kSy;
    localvn.sSc = this.jbS.sSc;
    localvn.sSh = this.jbS.sSh;
    localvn.sSd = this.jbS.sSd;
    localvn.sSl = this.jbS.sSl;
    localvn.sSg = this.jbS.sSg;
    localvn.sSf = this.jbS.sSf;
    localvn.sSn = this.jbS.sSn;
    localvn.sSo = this.jbS.sSo;
    localvn.syc = this.jbS.syc;
    localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localvn));
    return new com.tencent.mm.plugin.emoji.a.a.c(localArrayList);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.aGI())) {}
    for (String str1 = "";; str1 = parama.aGI())
    {
      y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.aGH()) });
      this.jbX.a(parama);
      return;
    }
  }
  
  public final void aHM() {}
  
  protected final int getLayoutId()
  {
    return f.f.custom_smiley_preview;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jbF = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.DO().dJT.a(this.jbF, 0);
  }
  
  protected final void initView()
  {
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.jca = getIntent().getLongExtra("msg_id", 0L);
    this.jcb = getIntent().getStringExtra("msg_sender");
    this.jcc = getIntent().getStringExtra("msg_content");
    this.dpj = getIntent().getStringExtra("room_id");
    y.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str = bk.pm((String)localObject1);
    if (TextUtils.isEmpty(str))
    {
      y.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.jbU = ((ScaleRelativeLayout)findViewById(f.e.emoji_preview_root));
    this.jbV = ((TextView)findViewById(f.e.custom_smiley_emoji_desc));
    this.jbW = ((MMEmojiView)findViewById(f.e.custom_smiley_preview_emojiview));
    if (com.tencent.mm.sdk.a.b.cqk()) {
      this.jbW.setOnClickListener(new CustomSmileyPreviewUI.8(this));
    }
    if (this.jbW == null)
    {
      y.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
      finish();
      return;
    }
    this.hNs = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(str);
    Object localObject4;
    Object localObject3;
    Object localObject5;
    label417:
    int i;
    if (this.hNs.cwC())
    {
      localObject1 = EmojiInfo.bv(this, this.hNs.getName());
      if (localObject1 != null)
      {
        this.jbW.b((InputStream)localObject1, this.hNs.getName());
        this.jbW.setUpdateEmojiSize(true);
        this.jbW.post(new CustomSmileyPreviewUI.9(this));
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(this.hNs.Wv());
        if ((this.jbV != null) && (!bk.bl((String)localObject1)))
        {
          this.jbV.setText((CharSequence)localObject1);
          this.jbW.setContentDescription((CharSequence)localObject1);
        }
        localObject4 = getIntent().getStringExtra("custom_smiley_preview_appid");
        localObject1 = getIntent().getStringExtra("custom_smiley_preview_appname");
        localObject3 = (TextView)findViewById(f.e.appsource);
        localObject5 = com.tencent.mm.pluginsdk.model.app.g.by((String)localObject4, true);
        if ((localObject5 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName.trim().length() > 0)) {
          break label1159;
        }
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label1193;
        }
        if ((localObject1 != null) && (((String)localObject1).trim().length() != 0) && (!((String)localObject1).equals("weixinfile")) && (!((String)localObject1).equals("invalid_appname"))) {
          break label1169;
        }
        i = 0;
        label470:
        if (i == 0) {
          break label1193;
        }
        ((TextView)localObject3).setText(getString(f.h.emoji_source_from, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.mController.uMN, (com.tencent.mm.pluginsdk.model.app.f)localObject5, (String)localObject1) }));
        ((TextView)localObject3).setVisibility(0);
        ((View)localObject3).setOnClickListener(new CustomSmileyPreviewUI.5(this, com.tencent.mm.pluginsdk.model.app.p.f(this, (String)localObject4, "message")));
        localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((String)localObject4, 2, com.tencent.mm.cb.a.getDensity(this));
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label1174;
        }
        a(this, (TextView)localObject3, (Bitmap)localObject1);
        label568:
        setBackBtn(new CustomSmileyPreviewUI.11(this));
        if ((this.hNs.field_catalog == EmojiInfo.uCZ) || (this.hNs.cwC())) {
          break label1659;
        }
      }
    }
    label978:
    label1635:
    label1647:
    label1659:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if ((this.hNs.field_catalog != EmojiInfo.uCZ) && (!bk.bl(this.hNs.field_groupId)))
      {
        bool2 = bool1;
        if (!bk.bl(this.hNs.field_groupId))
        {
          bool2 = bool1;
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(this.hNs.field_groupId)) {}
        }
      }
      else
      {
        bool2 = true;
      }
      addIconOptionMenu(0, f.d.mm_title_btn_menu, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this);
          return true;
        }
      });
      showOptionMenu(bool2);
      this.jbN = findViewById(f.e.designer_bar_container);
      this.jbO = ((ImageView)this.jbN.findViewById(f.e.designer_icon));
      this.jbP = ((TextView)this.jbN.findViewById(f.e.designer_title));
      this.jbQ = ((TextView)this.jbN.findViewById(f.e.designer_detail));
      this.jbN.setVisibility(8);
      if ((this.hNs != null) && (!bk.bl(this.hNs.field_designerID)))
      {
        localObject1 = this.hNs.field_designerID;
        this.jbR = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBh.acG((String)localObject1);
        localObject1 = new com.tencent.mm.plugin.emoji.f.j(this.hNs.field_designerID);
        com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
      }
      if ((this.hNs != null) && (!bk.bl(this.hNs.field_activityid)))
      {
        localObject1 = this.hNs.field_activityid;
        this.jbY = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBe.acM((String)localObject1);
        localObject1 = this.hNs.field_activityid;
        localObject3 = this.hNs.field_md5;
        if ((this.jbY == null) || ((this.jbY != null) && (this.jbY.tcR != null) && (this.jbY.tcR.sRP < System.currentTimeMillis() / 1000L)))
        {
          localObject1 = new k((String)localObject1, (String)localObject3);
          com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
        }
      }
      else
      {
        aIO();
        this.jbN.setOnClickListener(new CustomSmileyPreviewUI.13(this));
        localObject4 = com.tencent.mm.plugin.report.service.h.nFQ;
        localObject5 = this.bJd;
        if (this.hNs != null) {
          break label1635;
        }
        localObject1 = "";
        label1019:
        if (this.hNs != null) {
          break label1647;
        }
      }
      for (localObject3 = "";; localObject3 = this.hNs.field_activityid)
      {
        for (;;)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject4).f(12067, new Object[] { Integer.valueOf(2), localObject5, str, localObject1, localObject3 });
          return;
          if (this.hNs == null) {}
          for (localObject1 = "null";; localObject1 = this.hNs.getName())
          {
            y.e("MicroMsg.emoji.CustomSmileyPreviewUI", "input stream is null. emoji name is:%s", new Object[] { localObject1 });
            break;
          }
          this.jbW.a(this.hNs, "");
          if ((this.hNs == null) || (this.hNs.cwK())) {
            break;
          }
          com.tencent.mm.plugin.emoji.e.b.aGZ();
          com.tencent.mm.plugin.emoji.e.b.a(this.hNs, true);
          break;
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject5).field_appName;
          break label417;
          i = 1;
          break label470;
          a(this, (TextView)localObject3, BitmapFactory.decodeResource(getResources(), f.d.nosdcard_watermark_icon));
          break label568;
          ((TextView)localObject3).setVisibility(8);
          this.bJd = this.hNs.field_groupId;
          localObject1 = new l(this.bJd);
          com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
          this.Nn = ((ListView)findViewById(16908298));
          this.jbM = new com.tencent.mm.plugin.emoji.a.f(this.mController.uMN);
          this.jbM.iVJ = this;
          this.jbM.iVe = true;
          this.jbM.iVh = false;
          this.Nn.setOnItemClickListener(this);
          this.Nn.setAdapter(this.jbM);
          this.jbM.iVH = this.Nn;
          if (!bk.bl(this.bJd))
          {
            localObject1 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBf.acI(this.bJd);
            if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.i)localObject1).field_content != null)) {
              localObject3 = new afe();
            }
          }
          try
          {
            ((afe)localObject3).aH(((com.tencent.mm.storage.emotion.i)localObject1).field_content);
            this.jbS = ((afe)localObject3).tcV;
            this.jbT = ((com.tencent.mm.storage.emotion.i)localObject1).field_lan;
            if ((this.jbS == null) || (bk.bl(this.jbT)) || (!this.jbT.equalsIgnoreCase(x.fB(this.mController.uMN))))
            {
              localObject1 = new com.tencent.mm.plugin.emoji.f.m(this.bJd, 1);
              com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
              this.jbX = new com.tencent.mm.plugin.emoji.model.h();
              this.jbX.hxz = this;
              this.jbX.iYq = this.jbM;
              this.jbX.iYt = 9;
              this.jbX.iYw = this;
              a(this.bJd, this.hNs);
              com.tencent.mm.kernel.g.DS().O(new Runnable()
              {
                public final void run()
                {
                  CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBd.acA(CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this)));
                  CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).sendEmptyMessage(2);
                }
              });
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              y.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bk.j(localIOException) });
              continue;
              localObject2 = aIP();
              if (this.jbM != null) {
                this.jbM.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
              }
              localObject2 = new com.tencent.mm.plugin.emoji.f.m(this.bJd, 1, this.jbS.hQQ);
              com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject2, 0);
            }
          }
        }
        y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
        break label978;
        Object localObject2 = this.hNs.field_designerID;
        break label1019;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DO().dJT.a(412, this);
    com.tencent.mm.kernel.g.DO().dJT.a(521, this);
    com.tencent.mm.kernel.g.DO().dJT.a(411, this);
    com.tencent.mm.kernel.g.DO().dJT.a(239, this);
    com.tencent.mm.kernel.g.DO().dJT.a(368, this);
    com.tencent.mm.sdk.b.a.udP.c(this.jbE);
    com.tencent.mm.sdk.b.a.udP.c(this.jce);
    initView();
    String str = "";
    paramBundle = str;
    if (this.jbR != null)
    {
      paramBundle = str;
      if (this.jbR.tcO != null) {
        paramBundle = com.tencent.mm.a.o.getString(this.jbR.tcO.tcH);
      }
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(4), paramBundle, "", "", Integer.valueOf(9), Integer.valueOf(9) });
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(412, this);
    com.tencent.mm.kernel.g.DO().dJT.b(521, this);
    com.tencent.mm.kernel.g.DO().dJT.b(411, this);
    com.tencent.mm.kernel.g.DO().dJT.b(239, this);
    com.tencent.mm.kernel.g.DO().dJT.b(368, this);
    com.tencent.mm.sdk.b.a.udP.d(this.jbE);
    com.tencent.mm.sdk.b.a.udP.d(this.jce);
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jbM == null) || (paramInt < 0) || (paramInt >= this.jbM.getCount())) {
      return;
    }
    paramAdapterView = this.jbM.pP(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    Object localObject = paramAdapterView.iVU;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      startActivity(paramAdapterView);
      return;
      paramView.putExtra("extra_id", ((vn)localObject).syc);
      paramView.putExtra("extra_name", ((vn)localObject).sSc);
      paramView.putExtra("extra_copyright", ((vn)localObject).sSm);
      paramView.putExtra("extra_coverurl", ((vn)localObject).sSk);
      paramView.putExtra("extra_description", ((vn)localObject).sSd);
      paramView.putExtra("extra_price", ((vn)localObject).sSf);
      paramView.putExtra("extra_type", ((vn)localObject).sSg);
      paramView.putExtra("extra_flag", ((vn)localObject).sSh);
      paramView.putExtra("preceding_scence", 4);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("download_entrance_scene", 9);
      paramView.putExtra("check_clickflag", true);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.xL);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bk.bl((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    switch (paramm.getType())
    {
    default: 
    case 412: 
    case 521: 
      do
      {
        do
        {
          do
          {
            return;
            paramString = (com.tencent.mm.plugin.emoji.f.m)paramm;
            if (paramInt1 != 0) {
              break;
            }
            if (paramInt2 == 0)
            {
              this.jbS = paramString.aIg();
              if ((this.jbS != null) && (!TextUtils.isEmpty(this.bJd)) && (this.bJd.equals(this.jbS.syc)))
              {
                paramString = aIP();
                if (this.jbM != null) {
                  this.jbM.a(paramString);
                }
                this.mHandler.sendEmptyMessage(0);
                y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.jbS.syc);
                return;
              }
              paramm = this.bJd;
              if (this.jbS == null) {}
              for (paramString = "";; paramString = this.jbS.syc)
              {
                y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramm, paramString });
                return;
              }
            }
          } while (paramInt2 != 1);
          return;
        } while (paramInt2 != 5);
        if ((this.jbS != null) && (paramString.aIg() != null) && (!TextUtils.isEmpty(this.bJd)) && (this.bJd.equals(this.jbS.syc)) && (this.jbS.sSh != paramString.aIg().sSh))
        {
          this.jbS.sSh = paramString.aIg().sSh;
          paramString = aIP();
          if (this.jbM != null) {
            this.jbM.a(paramString);
          }
          this.mHandler.sendEmptyMessage(0);
          y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.jbS.syc);
          return;
        }
        paramm = this.bJd;
        if (this.jbS == null) {}
        for (paramString = "";; paramString = this.jbS.syc)
        {
          y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramm, paramString });
          return;
        }
      } while (paramInt2 != 0);
      this.mHandler.sendEmptyMessage(2);
      this.mHandler.sendEmptyMessageDelayed(131077, 500L);
      return;
    case 411: 
      paramString = (com.tencent.mm.plugin.emoji.f.o)paramm;
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBe.a(12, paramString.aIi());
      return;
    case 239: 
      this.jbR = ((com.tencent.mm.plugin.emoji.f.j)paramm).aIe();
      aIO();
      return;
    }
    if (paramInt2 == 0)
    {
      paramString = (k)paramm;
      paramm = (afa)paramString.dmK.ecF.ecN;
      if ((paramm != null) && (paramm.tcR != null))
      {
        paramm.tcR.sRP = ((int)(System.currentTimeMillis() / 1000L) + paramm.tcR.sRP);
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBe.a(paramString.iZR, paramm);
      }
      this.jbY = paramm;
      aIO();
      return;
    }
    y.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */