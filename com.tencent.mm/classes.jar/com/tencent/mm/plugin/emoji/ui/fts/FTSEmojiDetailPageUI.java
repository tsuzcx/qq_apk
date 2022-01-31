package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

public class FTSEmojiDetailPageUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private int bIl;
  private String bJd;
  private String bNm;
  private String bTY;
  private int dTK;
  private String designerName;
  private com.tencent.mm.ui.tools.j gGp;
  private ProgressBar hJa;
  private EmojiInfo hNs;
  private d.a iYo = new FTSEmojiDetailPageUI.10(this);
  private String iYv;
  private ImageView jfA;
  private View jfB;
  private boolean jfC;
  private boolean jfD;
  private String jfE;
  private String jfF;
  private String jfG;
  private String jfH;
  private String jfI;
  private String jfJ;
  private String jfK;
  private com.tencent.mm.sdk.b.c jfL = new FTSEmojiDetailPageUI.9(this);
  private com.tencent.mm.as.a.c.i jfM = new FTSEmojiDetailPageUI.11(this);
  private n.d jfN = new FTSEmojiDetailPageUI.3(this);
  private MMAnimateView jfw;
  private Button jfx;
  private Button jfy;
  private TextView jfz;
  private int scene;
  private int type;
  
  private boolean aJu()
  {
    return (!bk.bl(this.jfK)) && (this.bIl == 1);
  }
  
  private void fi(boolean paramBoolean)
  {
    if (paramBoolean) {
      setMMTitle(this.hNs.getName());
    }
    Object localObject1;
    label143:
    Object localObject2;
    switch (this.type)
    {
    default: 
      if (e.bK(this.bTY))
      {
        this.hJa.setVisibility(8);
        this.jfw.setVisibility(0);
        localObject1 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.hNs.Wv());
        if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo))
        {
          y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
          this.jfw.h(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1), "");
          localObject2 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.hNs.Wv());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.hNs;
          }
          if (((EmojiInfo)localObject1).field_catalog != EmojiGroupInfo.uCS) {
            break label460;
          }
          this.jfx.setEnabled(false);
          this.jfx.setText(f.h.app_added);
          label199:
          localObject1 = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.hNs.Wv());
          if (localObject1 != null) {
            break label793;
          }
          localObject1 = this.hNs;
        }
      }
      break;
    }
    label793:
    for (;;)
    {
      if ((((EmojiInfo)localObject1).field_catalog == EmojiInfo.uCZ) || (bk.bl(((EmojiInfo)localObject1).field_groupId)) || ((!bk.bl(((EmojiInfo)localObject1).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(((EmojiInfo)localObject1).field_groupId))) || (this.type == 4)) {
        this.jfy.setEnabled(true);
      }
      for (;;)
      {
        if (this.jfC) {
          this.jfx.setVisibility(8);
        }
        return;
        com.tencent.mm.as.o.ON().a(this.jfF, this.jfA);
        this.jfz.setText(this.jfG);
        this.bTY = this.hNs.cwL();
        break;
        com.tencent.mm.as.o.ON().a(this.jfJ, this.jfA);
        this.jfz.setText(this.designerName);
        this.bTY = this.hNs.cwL();
        break;
        this.jfA.setVisibility(8);
        if (!bk.bl(this.jfI))
        {
          this.jfz.setText(this.jfI);
          break;
        }
        this.jfz.setText(f.h.search_emoji_network_source);
        break;
        y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
        this.jfw.setImageFilePath(this.bTY);
        break label143;
        label460:
        this.jfx.setText(f.h.emoji_store_add_emoji);
        if (e.bK(this.bTY))
        {
          this.jfx.setEnabled(true);
          break label199;
        }
        this.jfx.setEnabled(false);
        break label199;
        localObject1 = this.hNs.field_groupId;
        com.tencent.mm.kernel.g.DO().dJT.a(423, this);
        localObject1 = new h((String)localObject1, (byte)0);
        com.tencent.mm.kernel.g.DO().dJT.a((m)localObject1, 0);
        continue;
        if (paramBoolean) {
          if (this.type == 4)
          {
            localObject1 = new com.tencent.mm.vfs.b(getCacheDir(), com.tencent.mm.a.g.o(this.hNs.field_encrypturl.getBytes()));
            if (((com.tencent.mm.vfs.b)localObject1).exists())
            {
              this.hNs.field_md5 = e.aeY(com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).mUri));
              localObject2 = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), "", this.hNs.field_md5);
              if (!e.bK((String)localObject2)) {
                e.r(com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr()), (String)localObject2);
              }
              this.bTY = ((String)localObject2);
              fi(false);
            }
            else
            {
              localObject2 = new c.a();
              ((c.a)localObject2).erf = true;
              ((c.a)localObject2).erh = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr());
              ((c.a)localObject2).erJ = new Object[] { com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr()) };
              localObject1 = ((c.a)localObject2).OV();
              com.tencent.mm.plugin.emoji.model.i.aHr().a(this.hNs.field_encrypturl, null, (com.tencent.mm.as.a.a.c)localObject1, this.jfM);
            }
          }
          else
          {
            this.jfw.setVisibility(8);
            this.hJa.setVisibility(0);
            this.jfx.setText(f.h.emoji_store_add_emoji);
            this.jfy.setText(f.h.retransmits);
            this.jfx.setEnabled(false);
            this.jfy.setEnabled(false);
            com.tencent.mm.plugin.emoji.model.i.aHO().i(this.hNs);
          }
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return f.f.fts_emoji_detail_page_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      Object localObject = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      paramIntent = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.hNs.Wv());
      String str2;
      if (paramIntent == null)
      {
        str2 = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), "", this.hNs.Wv());
        if (e.bK(str2))
        {
          if (!com.tencent.mm.sdk.platformtools.o.Za(str2)) {
            break label270;
          }
          paramInt1 = EmojiInfo.uDb;
          paramIntent = new EmojiInfo();
          paramIntent.field_md5 = this.hNs.Wv();
          paramIntent.field_catalog = EmojiInfo.uCT;
          paramIntent.field_type = paramInt1;
          paramIntent.field_size = ((int)e.aeQ(str2));
          paramIntent.field_temp = 1;
          if (!bk.bl(this.hNs.field_activityid)) {
            paramIntent.field_activityid = this.hNs.field_activityid;
          }
          paramIntent.field_designerID = this.hNs.field_designerID;
          paramIntent.field_thumbUrl = this.hNs.field_thumbUrl;
          paramIntent = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.o(paramIntent);
        }
      }
      for (;;)
      {
        localObject = bk.G(bk.aM((String)localObject, "").split(",")).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if (paramIntent != null)
          {
            com.tencent.mm.plugin.emoji.model.i.aHP().a(str2, paramIntent, null);
            if (!bk.bl(str1)) {
              com.tencent.mm.plugin.messenger.a.g.bhI().dO(str1, str2);
            }
          }
        }
        label270:
        paramInt1 = EmojiInfo.uDa;
        break;
        paramIntent.field_designerID = this.hNs.field_designerID;
        paramIntent.field_thumbUrl = this.hNs.field_thumbUrl;
      }
      com.tencent.mm.ui.widget.snackbar.b.h(this, this.mController.uMN.getString(f.h.app_sent));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jfx = ((Button)findViewById(f.e.emoji_add_btn));
    this.jfy = ((Button)findViewById(f.e.emoji_send_btn));
    this.jfw = ((MMAnimateView)findViewById(f.e.emoji_image_iv));
    this.hJa = ((ProgressBar)findViewById(f.e.loading_pb));
    this.jfz = ((TextView)findViewById(f.e.emoji_source_title_tv));
    this.jfA = ((ImageView)findViewById(f.e.emoji_source_iv));
    this.jfB = findViewById(f.e.bottom_bar);
    setBackBtn(new FTSEmojiDetailPageUI.1(this));
    this.jfx.setOnClickListener(new FTSEmojiDetailPageUI.5(this));
    this.jfy.setOnClickListener(new FTSEmojiDetailPageUI.6(this));
    this.jfB.setOnClickListener(new FTSEmojiDetailPageUI.7(this));
    addIconOptionMenu(0, f.d.mm_title_btn_menu, new FTSEmojiDetailPageUI.8(this));
    this.type = getIntent().getIntExtra("extra_type", 0);
    this.scene = getIntent().getIntExtra("extra_scence", 0);
    this.hNs = new EmojiInfo();
    this.hNs.field_designerID = getIntent().getStringExtra("id");
    this.hNs.field_name = getIntent().getStringExtra("extra_emoji_name");
    this.hNs.field_aeskey = getIntent().getStringExtra("extra_aeskey");
    this.hNs.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
    this.hNs.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
    this.hNs.field_md5 = getIntent().getStringExtra("extra_md5");
    this.hNs.field_groupId = getIntent().getStringExtra("extra_product_id");
    this.bJd = this.hNs.field_groupId;
    this.jfG = getIntent().getStringExtra("extra_product_name");
    this.jfF = getIntent().getStringExtra("productUrl");
    this.jfH = getIntent().getStringExtra("extra_article_url");
    this.jfI = getIntent().getStringExtra("extra_article_name");
    this.bNm = this.hNs.field_designerID;
    this.designerName = getIntent().getStringExtra("name");
    this.jfJ = getIntent().getStringExtra("headurl");
    this.jfK = getIntent().getStringExtra("weapp_user_name");
    this.dTK = getIntent().getIntExtra("weapp_version", 0);
    this.bIl = getIntent().getIntExtra("source_type", 0);
    this.jfE = getIntent().getStringExtra("searchID");
    this.iYv = getIntent().getStringExtra("docID");
    this.jfC = getIntent().getBooleanExtra("disableAddSticker", false);
    this.jfD = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
    paramBundle = getIntent().getStringExtra("activityId");
    if (!bk.bl(paramBundle)) {
      this.hNs.field_activityid = paramBundle;
    }
    com.tencent.mm.sdk.b.a.udP.c(this.jfL);
    com.tencent.mm.plugin.emoji.model.i.aHO().iYa = this.iYo;
    ao.v(this.scene, this.jfE, this.iYv);
    fi(true);
    y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[] { this.bTY });
    ao.v(this.scene, this.jfE, this.iYv);
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.jfL);
    com.tencent.mm.plugin.emoji.model.i.aHO().iYa = null;
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    fi(false);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof h))
    {
      com.tencent.mm.kernel.g.DO().dJT.b(423, this);
      paramString = (h)paramm;
      if ((paramString == null) || (bk.bl(paramString.iZD)) || (this.hNs == null) || (bk.bl(this.hNs.field_groupId)) || (!this.hNs.field_groupId.equalsIgnoreCase(paramString.iZD))) {
        break label104;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.jfy.setEnabled(true);
      }
    }
    else
    {
      return;
    }
    this.jfy.setEnabled(false);
    return;
    label104:
    y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI
 * JD-Core Version:    0.7.0.1
 */