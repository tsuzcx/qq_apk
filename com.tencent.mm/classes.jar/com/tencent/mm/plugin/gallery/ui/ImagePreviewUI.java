package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.x;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.api.q;
import com.tencent.mm.api.q.b;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
@TargetApi(16)
public class ImagePreviewUI
  extends MMActivity
{
  private ServiceConnection iAC = new ImagePreviewUI.1(this);
  private com.tencent.mm.plugin.gallery.stub.a kHB = null;
  private ArrayList<GalleryItem.MediaItem> kHC;
  private HashMap<String, Integer> kIE = new HashMap();
  private boolean kIW;
  private TextView kIg;
  private boolean kIm = true;
  private boolean kIq;
  private int kIt;
  private long kIy = 0L;
  private c kJB;
  private MMViewPager kJC;
  private RecyclerView kJD;
  private ArrayList<String> kJE;
  private ArrayList<String> kJF;
  private Integer kJG;
  private ImageButton kJH;
  private TextView kJI;
  private am kJJ;
  private ImageButton kJK;
  private TextView kJL;
  private ViewGroup kJM;
  private ViewGroup kJN;
  private boolean kJO = true;
  private boolean kJP = true;
  private int kJQ = 0;
  private int kJR = 10;
  private TextView kJS;
  private TextView kJT;
  private TextView kJU;
  private TextView kJV;
  private View kJW;
  private TextView kJX;
  private ProgressBar kJY;
  boolean kJZ = false;
  private HashSet<String> kKa;
  
  private void Et(String paramString)
  {
    if (!this.kJF.contains(paramString)) {
      if (this.kJF.size() >= this.kIt)
      {
        h.bC(this.mController.uMN, getResources().getQuantityString(R.j.gallery_pic_limit, this.kIt, new Object[] { Integer.valueOf(this.kIt) }));
        this.kJK.setImageResource(R.k.checkbox_unselected);
      }
    }
    for (;;)
    {
      paramString = this.kJF.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
      } while (o.Za((String)paramString.next()));
      return;
      GalleryItem.MediaItem localMediaItem = com.tencent.mm.plugin.gallery.model.c.Ep(paramString);
      if ((localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().AG(paramString)))
      {
        h.bC(this, getString(R.l.gallery_select_gif_to_big));
        return;
      }
      this.kJF.add(paramString);
      this.kJK.setImageResource(R.k.checkbox_selected);
      b(this.kJF.size(), this.kJG.intValue(), paramString, 0);
      continue;
      this.kJK.setImageResource(R.k.checkbox_unselected);
      while (this.kJF.remove(paramString)) {}
      b(this.kJF.size(), this.kJG.intValue(), paramString, 1);
    }
    this.kIq = true;
  }
  
  private void Eu(String paramString)
  {
    if ((this.kJF.size() >= 9) && (!this.kJF.contains(paramString)))
    {
      this.kJS.setTextColor(this.mController.uMN.getResources().getColor(R.e.white_text_color_disabled));
      this.kJS.setEnabled(false);
      return;
    }
    this.kJS.setEnabled(true);
    this.kJS.setTextColor(this.mController.uMN.getResources().getColor(R.e.white_text_color));
  }
  
  private void Ev(String paramString)
  {
    Boolean localBoolean2;
    GalleryItem.MediaItem localMediaItem;
    Boolean localBoolean1;
    switch (com.tencent.mm.plugin.gallery.model.c.aXb().aXE())
    {
    default: 
      localBoolean2 = Boolean.valueOf(false);
      localMediaItem = com.tencent.mm.plugin.gallery.model.c.Ep(paramString);
      localBoolean1 = localBoolean2;
      if (localMediaItem != null)
      {
        localBoolean1 = localBoolean2;
        if (localMediaItem.getType() == 2) {
          localBoolean1 = Boolean.valueOf(true);
        }
      }
      if ((localMediaItem == null) && (o.Za(paramString))) {
        paramString = Boolean.valueOf(true);
      }
      break;
    }
    for (;;)
    {
      if (!paramString.booleanValue()) {
        break label155;
      }
      this.kJH.setVisibility(8);
      this.kIg.setVisibility(8);
      return;
      localBoolean2 = Boolean.valueOf(true);
      break;
      paramString = localBoolean1;
      if (localMediaItem != null)
      {
        paramString = localBoolean1;
        if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
          paramString = Boolean.valueOf(true);
        }
      }
    }
    label155:
    this.kJH.setVisibility(0);
    this.kIg.setVisibility(0);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.c.aXb().aXE() != 4) && (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() != 13)))
    {
      this.kJO = true;
      this.kJM.setVisibility(0);
      this.kJN.setVisibility(8);
      this.kJY.setVisibility(8);
      b(paramString, paramMediaItem);
      Ev(paramString);
      enableOptionMenu(true);
      this.kJI.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
      {
        this.kJS.setVisibility(0);
        Eu(paramString);
      }
    }
    GalleryItem.VideoMediaItem localVideoMediaItem;
    label420:
    label423:
    for (;;)
    {
      return;
      boolean bool = getIntent().getBooleanExtra("preview_image", false);
      y.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.c.aXb().aXE()), Boolean.valueOf(bool), paramString });
      if ((paramMediaItem == null) && (!bk.bl(paramString)))
      {
        this.kJS.setVisibility(0);
        break;
      }
      this.kJS.setVisibility(8);
      break;
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
      {
        this.kJS.setVisibility(0);
        Eu(paramString);
        localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
        enableOptionMenu(false);
        this.kJO = false;
        this.kJM.setVisibility(8);
        this.kJN.setVisibility(0);
        this.kJX.setVisibility(8);
        if (com.tencent.mm.vfs.e.aeQ(paramString) <= 1073741824L) {
          break label420;
        }
        this.kJT.setText(getString(R.l.gallery_pic_video_too_large_title));
        this.kJU.setText(getString(R.l.gallery_pic_video_too_large_desc));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label423;
        }
        if (bk.bl(localVideoMediaItem.eAv)) {
          break label425;
        }
        y.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.eAu, Integer.valueOf(localVideoMediaItem.eAx), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        a(paramString, localVideoMediaItem);
        return;
        this.kJS.setVisibility(8);
        break;
      }
    }
    label425:
    enableOptionMenu(false);
    this.kJO = true;
    this.kJM.setVisibility(0);
    this.kJN.setVisibility(8);
    this.kJI.setVisibility(8);
    b(paramString, paramMediaItem);
    Ev(paramString);
    paramMediaItem = new m(paramString, this.kJG.intValue(), localVideoMediaItem, new ImagePreviewUI.17(this));
    if (com.tencent.mm.sdk.f.e.ad(paramMediaItem))
    {
      y.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      return;
    }
    com.tencent.mm.sdk.f.e.post(paramMediaItem, "video_analysis");
  }
  
  private void a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    enableOptionMenu(false);
    this.kJO = false;
    this.kJM.setVisibility(8);
    this.kJN.setVisibility(0);
    this.kJX.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 13)
    {
      this.kJN.setVisibility(8);
      this.kJM.setVisibility(8);
      this.kJT.setVisibility(8);
      this.kJU.setVisibility(8);
      enableOptionMenu(true);
      return;
    }
    int i;
    label210:
    int j;
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        y.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.kJT.setText(getString(R.l.gallery_pic_video_special_ratio));
      this.kJU.setText(getString(R.l.gallery_pic_video_special_ratio_desc));
      i = 1;
      if (i != 0) {
        break label515;
      }
      y.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
      if (paramVideoMediaItem == null) {
        break label871;
      }
      if ((!"video/hevc".equalsIgnoreCase(paramVideoMediaItem.eAv)) || (!com.tencent.mm.plugin.s.e.bio())) {
        break label517;
      }
      j = 1;
    }
    for (;;)
    {
      label257:
      String str;
      if ((paramVideoMediaItem != null) && (!bk.bl(paramVideoMediaItem.eAu)))
      {
        str = paramVideoMediaItem.eAu;
        if (bk.bl(str))
        {
          i = 1;
          label287:
          if ((i == 0) && (j != 0) && ((bk.bl(paramVideoMediaItem.eAw)) || ("audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.eAw)))) {
            break label744;
          }
        }
      }
      else
      {
        if (paramVideoMediaItem != null) {
          break label735;
        }
        str = null;
        label326:
        y.d("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { str });
        this.kJT.setText(getString(R.l.gallery_pic_video_not_support));
        this.kJU.setText(getString(R.l.gallery_pic_video_not_support_desc));
        i = 1;
        label374:
        if (i != 0) {
          break label747;
        }
        y.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.eAx) });
        if (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 13) {
          break label866;
        }
        if (paramVideoMediaItem.eAx > 1000) {
          break label749;
        }
        this.kJT.setText(getString(R.l.gallery_pic_video_too_short_title));
        this.kJU.setText(getString(R.l.gallery_pic_video_too_short_desc));
        i = 1;
      }
      label515:
      label517:
      label735:
      label866:
      for (;;)
      {
        if (i != 0) {
          break label869;
        }
        enableOptionMenu(true);
        this.kJO = true;
        this.kJM.setVisibility(0);
        this.kJN.setVisibility(8);
        this.kJI.setVisibility(0);
        this.kJY.setVisibility(8);
        b(paramString, paramVideoMediaItem);
        Ev(paramString);
        return;
        i = 0;
        break label210;
        break;
        if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.eAv)) {
          break label871;
        }
        j = 1;
        break label257;
        if (this.kKa == null)
        {
          this.kKa = new HashSet();
          this.kKa.add(".h264");
          this.kKa.add(".h26l");
          this.kKa.add(".264");
          this.kKa.add(".avc");
          this.kKa.add(".mov");
          this.kKa.add(".mp4");
          this.kKa.add(".m4a");
          this.kKa.add(".3gp");
          this.kKa.add(".3g2");
          this.kKa.add(".mj2");
          this.kKa.add(".m4v");
        }
        str = str.trim();
        i = str.lastIndexOf(".");
        if ((i < 0) || (i >= str.length()))
        {
          i = 1;
          break label287;
        }
        if (!this.kKa.contains(str.substring(i)))
        {
          i = 1;
          break label287;
        }
        i = 0;
        break label287;
        str = paramVideoMediaItem.eAv;
        break label326;
        label744:
        i = 0;
        break label374;
        label747:
        break;
        label749:
        if (paramVideoMediaItem.eAx >= 300000)
        {
          this.kJT.setText(getString(R.l.gallery_pic_video_too_long_title));
          this.kJU.setText(getString(R.l.gallery_pic_video_too_long_desc));
          i = 1;
        }
        else if (paramVideoMediaItem.eAx >= this.kJR * 1000 + 500)
        {
          this.kJT.setText(getString(R.l.gallery_pic_edit_video));
          this.kJU.setText(getString(R.l.gallery_pic_edit_des_config, new Object[] { Integer.valueOf(this.kJR) }));
          this.kJX.setVisibility(0);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
      label869:
      break;
      label871:
      j = 0;
    }
  }
  
  private String aXS()
  {
    switch (com.tencent.mm.plugin.gallery.model.c.aXb().aXE())
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    default: 
      if ((this.kJF.size() == 0) || (this.kIt <= 1)) {
        return getString(R.l.app_send);
      }
      break;
    case 4: 
    case 7: 
    case 8: 
    case 13: 
      if ((this.kJF.size() == 0) || (this.kIt <= 1)) {
        return getString(R.l.gallery_pic_timeline_send);
      }
      return getString(R.l.gallery_pic_timeline_send) + "(" + this.kJF.size() + "/" + this.kIt + ")";
    case 11: 
      return getString(R.l.emoji_store_use);
    }
    return getString(R.l.gallery_pic_chatting_send, new Object[] { Integer.valueOf(this.kJF.size()), Integer.valueOf(this.kIt) });
  }
  
  private ArrayList<String> aXT()
  {
    if (this.kIW) {
      return this.kJF;
    }
    ArrayList localArrayList = new ArrayList(this.kJF.size());
    Iterator localIterator = this.kJE.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.kJF.contains(str)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    y.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.kIW))
    {
      this.kJD.getAdapter().c(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() != 13) {
        break label268;
      }
    }
    label268:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      paramString = this.kJB.rZ(this.kJG.intValue());
      if ((paramInt1 != 0) && (((!this.kIm) && (paramInt2 == 0)) || (this.kJB == null) || (paramString == null) || (paramString.getType() != 2))) {
        break label273;
      }
      this.kJD.setVisibility(8);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((f)this.kJD.getAdapter()).kKm.add(paramString);
        ((f)this.kJD.getAdapter()).cX(paramInt1 - 1, this.kJG.intValue());
        this.kJD.getAdapter().bM(paramInt1 - 1);
        this.kJD.smoothScrollToPosition(paramInt1 - 1);
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((f)this.kJD.getAdapter()).kKm.indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((f)this.kJD.getAdapter()).kKm.remove(paramInt2);
      this.kJD.getAdapter().bN(paramInt2);
      break;
    }
    label273:
    this.kJD.setVisibility(0);
  }
  
  private void b(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() != 4))
    {
      if (this.kIt == 1)
      {
        this.kJK.setVisibility(8);
        this.kJL.setVisibility(8);
      }
      while (!this.kJF.contains(paramString))
      {
        this.kJK.setImageResource(R.k.checkbox_unselected);
        return;
        this.kJK.setVisibility(0);
        this.kJL.setVisibility(0);
      }
      this.kJK.setImageResource(R.k.checkbox_selected);
      return;
    }
    this.kJK.setVisibility(8);
    this.kJL.setVisibility(8);
  }
  
  private void c(GalleryItem.MediaItem paramMediaItem)
  {
    if (paramMediaItem == null) {
      y.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
    }
    do
    {
      return;
      if (paramMediaItem.getType() == 2)
      {
        GalleryItem.VideoMediaItem localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
        if (!bk.bl(localVideoMediaItem.eAv))
        {
          y.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.eAu, Integer.valueOf(localVideoMediaItem.eAx), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
          if ((localVideoMediaItem.eAx >= 300000) || ((localVideoMediaItem.eAx > 0) && (localVideoMediaItem.eAx < 1000)))
          {
            this.kJW.setVisibility(0);
            localObject = this.kJV;
            if (localVideoMediaItem.eAx >= 300000) {}
            for (paramMediaItem = getString(R.l.gallery_pic_video_too_long_desc);; paramMediaItem = getString(R.l.gallery_pic_video_too_short_desc))
            {
              ((TextView)localObject).setText(paramMediaItem);
              this.kJL.setEnabled(false);
              this.kJK.setEnabled(false);
              this.kJL.setTextColor(getResources().getColor(R.e.white_text_color_disabled));
              if (this.kJF.size() != 0) {
                break;
              }
              enableOptionMenu(false);
              return;
            }
          }
          this.kJL.setEnabled(true);
          this.kJK.setEnabled(true);
          this.kJL.setTextColor(getResources().getColor(R.e.white_text_color));
          this.kJW.setVisibility(8);
          return;
        }
        localObject = new m(paramMediaItem.eAu, this.kJG.intValue(), localVideoMediaItem, new ImagePreviewUI.18(this));
        if (com.tencent.mm.sdk.f.e.ad((Runnable)localObject))
        {
          y.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramMediaItem.eAu });
          return;
        }
        com.tencent.mm.sdk.f.e.post((Runnable)localObject, "video_analysis");
        return;
      }
      if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
      {
        this.kJL.setEnabled(true);
        this.kJK.setEnabled(true);
        this.kJL.setTextColor(getResources().getColor(R.e.white_text_color));
        if ((this.kIq) && (this.kJF.contains(paramMediaItem.eAu)) && (com.tencent.mm.vfs.e.aeQ(paramMediaItem.eAu) > 26214400L))
        {
          this.kJW.setVisibility(0);
          this.kJV.setText(getString(R.l.gallery_select_image_to_big));
          return;
        }
        this.kJW.setVisibility(8);
        return;
      }
    } while ((paramMediaItem.getType() != 1) || (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")));
    Object localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.eAu);
    long l = com.tencent.mm.vfs.e.aeQ(paramMediaItem.eAu);
    try
    {
      if (((this.kJF.contains(paramMediaItem.eAu)) && (l != 0L) && (l > this.kHB.Ah())) || (localObject.lhL[0] > this.kHB.Ag()) || (localObject.lhL[1] > this.kHB.Ag()))
      {
        this.kJL.setTextColor(getResources().getColor(R.e.white_text_color_disabled));
        this.kJL.setEnabled(false);
        this.kJK.setEnabled(false);
        return;
      }
    }
    catch (Exception paramMediaItem)
    {
      y.e("MicroMsg.ImagePreviewUI", bk.j(paramMediaItem));
      return;
    }
    this.kJL.setTextColor(getResources().getColor(R.e.white_text_color));
    this.kJL.setEnabled(true);
    this.kJK.setEnabled(true);
  }
  
  private void goBack()
  {
    boolean bool2 = true;
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.kIq)
    {
      bool1 = true;
      if (!this.kIm) {
        break label77;
      }
      bool1 = bool2;
    }
    label77:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", aXT());
      localIntent.putExtra("show_photo_edit_tip", this.kJZ);
      setResult(0, localIntent);
      finish();
      return;
      bool1 = false;
      break;
    }
  }
  
  private void gr(boolean paramBoolean)
  {
    if (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 4) {
      return;
    }
    if (this.kJB == null)
    {
      y.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      return;
    }
    GalleryItem.MediaItem localMediaItem = this.kJB.rZ(this.kJG.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.kJW.postDelayed(new ImagePreviewUI.16(this, localMediaItem), 400L);
      return;
    }
    this.kJW.setVisibility(8);
  }
  
  private void gs(boolean paramBoolean)
  {
    y.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.kJO);
    if (this.kJO)
    {
      localObject = findViewById(R.h.cropimage_operator_ll);
      if (localObject != null) {
        break label109;
      }
      if (!this.kJO) {
        break label102;
      }
      localObject = "normal";
      label66:
      y.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
    }
    label102:
    label109:
    do
    {
      do
      {
        return;
        localObject = findViewById(R.h.gallery_edit_layout);
        break;
        localObject = "edit_tips";
        break label66;
      } while (((paramBoolean) && (((View)localObject).getVisibility() == 0)) || ((!paramBoolean) && (((View)localObject).getVisibility() == 8)));
      if (paramBoolean)
      {
        ((View)localObject).setVisibility(0);
        ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_in));
      }
      while ((paramBoolean) && (this.kJD.getVisibility() == 8) && (this.kJF.size() > 0))
      {
        this.kJD.setVisibility(0);
        localObject = AnimationUtils.loadAnimation(this, R.a.fast_faded_in);
        this.kJD.startAnimation((Animation)localObject);
        return;
        ((View)localObject).setVisibility(8);
        ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_out));
      }
    } while ((paramBoolean) || (this.kJD.getVisibility() != 0));
    this.kJD.setVisibility(8);
    Object localObject = AnimationUtils.loadAnimation(this, R.a.fast_faded_out);
    this.kJD.startAnimation((Animation)localObject);
  }
  
  protected final void dealContentView(View paramView)
  {
    if (b.be(this))
    {
      setContentView(paramView);
      return;
    }
    ak.g(ak.a(getWindow(), null), this.mController.uMz);
    ((ViewGroup)this.mController.uMz.getParent()).removeView(this.mController.uMz);
    ((ViewGroup)getWindow().getDecorView()).addView(this.mController.uMz, 0);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.image_gallery_plugin;
  }
  
  protected final void initView()
  {
    this.kJT = ((TextView)findViewById(R.h.gallery_edit_tv));
    this.kJU = ((TextView)findViewById(R.h.gallery_edit_tv_des));
    this.kJV = ((TextView)findViewById(R.h.item_legal_tip));
    this.kJW = findViewById(R.h.item_legal_tip_layout);
    this.kJW.postDelayed(new ImagePreviewUI.21(this), 100L);
    this.kJX = ((TextView)findViewById(R.h.gallery_edit_tv_btn));
    this.kJY = ((ProgressBar)findViewById(R.h.video_edit_progressbar));
    this.kIt = getIntent().getIntExtra("max_select_count", 9);
    this.kJR = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 4)
    {
      bool1 = true;
      this.kIm = bool1;
      localObject1 = getIntent();
      this.kJE = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.kJF = new ArrayList();
      if (this.kJE != null) {
        this.kJF.addAll(this.kJE);
      }
      this.kHC = com.tencent.mm.plugin.gallery.model.c.aXd();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.kHC != null) {
        break label373;
      }
    }
    label373:
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.kHC != null))
      {
        this.kIW = true;
        this.kJG = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        y.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.kJG });
        if (this.kJG.intValue() >= 0) {}
      }
      else
      {
        this.kJG = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.c.rI(this.kJG.intValue());
      if ((this.kIW) || ((this.kJF != null) && (this.kJF.size() != 0))) {
        break label378;
      }
      y.e("MicroMsg.ImagePreviewUI", "not preview all items and imagepaths is null or empty");
      finish();
      return;
      bool1 = false;
      break;
    }
    label378:
    this.kJH = ((ImageButton)findViewById(R.h.orignal_image));
    this.kIg = ((TextView)findViewById(R.h.orignal_image_tip));
    this.kJI = ((TextView)findViewById(R.h.video_edit_button));
    this.kIq = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.kJQ = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    int i;
    if (this.kIq)
    {
      this.kJH.setImageResource(R.k.radio_on);
      if ((this.kJF != null) && (this.kJF.size() == 1))
      {
        localObject1 = (String)this.kJF.get(0);
        if (((String)localObject1).endsWith(".jpg")) {
          ai.d(new ImagePreviewUI.10(this, (String)localObject1));
        }
      }
      this.kIg.setText(this.mController.uMN.getString(R.l.gallery_pic_orignal));
      this.kJH.setOnClickListener(new ImagePreviewUI.22(this));
      this.kJI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).ke(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bk.bl(paramAnonymousView))
          {
            y.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("key_video_path", paramAnonymousView);
          localIntent.putExtra("key_need_clip_video_first", false);
          com.tencent.mm.br.d.b(ImagePreviewUI.this.mController.uMN, "mmsight", ".segment.MMSightEditUI", localIntent, 4370);
        }
      });
      this.kJX.setOnClickListener(new ImagePreviewUI.24(this));
      this.kIg.setOnClickListener(new ImagePreviewUI.25(this));
      setBackBtn(new ImagePreviewUI.26(this));
      a(0, aXS(), new ImagePreviewUI.27(this), s.b.uNx);
      this.kJK = ((ImageButton)findViewById(R.h.photos_select_checkbox));
      this.kJK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).ke(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bk.bl(paramAnonymousView))
          {
            y.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.mController.uMN.getString(R.l.gallery_pic_orignal) + ImagePreviewUI.aXU());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.m(ImagePreviewUI.this));
        }
      });
      this.kJL = ((TextView)findViewById(R.h.photos_select_tv));
      this.kJL.setOnClickListener(new ImagePreviewUI.3(this));
      if (this.kIt == 1)
      {
        this.kJK.setVisibility(8);
        this.kJL.setVisibility(8);
      }
      this.kJM = ((ViewGroup)findViewById(R.h.cropimage_operator_ll));
      this.kJN = ((ViewGroup)findViewById(R.h.gallery_edit_layout));
      if (this.kJM != null)
      {
        this.kJM.setVisibility(8);
        this.kJM.setOnClickListener(new ImagePreviewUI.4(this));
      }
      if (this.kJN != null)
      {
        this.kJN.setVisibility(8);
        this.kJN.setOnClickListener(new ImagePreviewUI.5(this));
      }
      this.kJS = ((TextView)findViewById(R.h.photo_edit_button));
      this.kJS.setOnClickListener(new ImagePreviewUI.6(this));
      this.kJD = ((RecyclerView)findViewById(R.h.image_preview_recycler_view));
      this.kJD.getItemAnimator().agR = 66L;
      this.kJD.a(new ImagePreviewUI.7(this));
      localObject1 = new g();
      ((g)localObject1).setOrientation(0);
      this.kJD.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new f(this, this.kJF, i, this.kIW);
      this.kJD.setAdapter((RecyclerView.a)localObject1);
      this.kJD.post(new ImagePreviewUI.8(this));
      if (this.kJF.size() <= 0) {
        break label1316;
      }
      this.kJD.setVisibility(0);
      label988:
      this.kJD.setItemAnimator(new x());
      ((f)localObject1).kKt.f(this.kJD);
      ((f)localObject1).kKn = new ImagePreviewUI.9(this);
      this.kJC = ((MMViewPager)findViewById(R.h.gallery));
      this.kJC.setVerticalFadingEdgeEnabled(false);
      this.kJC.setHorizontalFadingEdgeEnabled(false);
      this.kJC.setOnPageChangeListener(new ImagePreviewUI.13(this));
      this.kJC.setSingleClickOverListener(new ImagePreviewUI.14(this));
      this.kJB = new c(this);
      ((f)this.kJD.getAdapter()).kKk = this.kJB;
      if (this.kIW) {
        break label1328;
      }
      this.kJB.D(this.kJE);
      this.kJB.kIW = false;
      if (this.kJE.size() <= 0) {
        break label1437;
      }
      localObject1 = (String)this.kJE.get(this.kJG.intValue());
    }
    for (;;)
    {
      this.kJC.setAdapter(this.kJB);
      this.kJC.setCurrentItem(this.kJG.intValue());
      i = aXT().indexOf(this.kJB.ke(this.kJG.intValue()));
      ((f)this.kJD.getAdapter()).cX(i, this.kJG.intValue());
      Object localObject2 = com.tencent.mm.plugin.gallery.model.c.Ep((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      c((GalleryItem.MediaItem)localObject2);
      setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(this.kJG.intValue() + 1), Integer.valueOf(this.kJB.getCount()) }));
      return;
      this.kJH.setImageResource(R.k.radio_off);
      break;
      label1316:
      this.kJD.setVisibility(8);
      break label988;
      label1328:
      localObject1 = this.kJB;
      localObject2 = this.kHC;
      ((c)localObject1).kHC.clear();
      ((c)localObject1).kHC.addAll((Collection)localObject2);
      ((c)localObject1).reset();
      ((c)localObject1).notifyDataSetChanged();
      this.kJB.kIW = true;
      if (this.kJG.intValue() >= this.kHC.size()) {
        this.kJG = Integer.valueOf(0);
      }
      if (this.kHC.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.kHC.get(this.kJG.intValue())).eAu;
      } else {
        label1437:
        localObject1 = "";
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    for (;;)
    {
      if (paramInt1 == 4372) {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          this.kJZ = true;
          str1 = paramIntent.getStringExtra("before_photo_edit");
          localObject1 = com.tencent.mm.plugin.gallery.model.c.aXf().iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (str1.equals(((Bundle)((Iterator)localObject1).next()).getString("before_photo_edit")))
              {
                ((Iterator)localObject1).remove();
                continue;
                if (this.kJF.size() > 0)
                {
                  Et((String)this.kJF.get(0));
                  break;
                }
                y.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.kJF.size()) });
                break;
                if (paramInt1 != 4370) {
                  break;
                }
                if (paramInt2 == -1) {
                  setResult(-1, paramIntent);
                }
                if (paramIntent == null) {
                  break;
                }
                setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
                break;
              }
            }
          }
          com.tencent.mm.plugin.gallery.model.c.aXf().add(paramIntent.getBundleExtra("report_info"));
          localObject1 = paramIntent.getStringExtra("after_photo_edit");
          str2 = paramIntent.getStringExtra("tmp_photo_edit");
          y.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", new Object[] { str1, localObject1 });
          if (this.kJE != null)
          {
            this.kJE.clear();
            localObject2 = paramIntent.getStringArrayListExtra("preview_image_list");
            if (localObject2 != null) {
              this.kJE.addAll((Collection)localObject2);
            }
            localObject2 = this.kJB.rZ(this.kJG.intValue());
            if (localObject2 != null) {
              break label357;
            }
            y.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.kJG, str1, localObject1 });
          }
        }
      }
    }
    label357:
    while (paramIntent == null)
    {
      String str1;
      Object localObject1;
      String str2;
      Object localObject2;
      return;
      ((GalleryItem.MediaItem)localObject2).kGV = str1;
      ((GalleryItem.MediaItem)localObject2).eAu = ((String)localObject1);
      ((GalleryItem.MediaItem)localObject2).jSX = ((String)localObject1);
      ((GalleryItem.MediaItem)localObject2).kGW = str2;
      ((GalleryItem.MediaItem)localObject2).mMimeType = "edit";
      com.tencent.mm.plugin.gallery.model.c.aXe().add(localObject2);
      com.tencent.mm.plugin.gallery.model.c.aXa().a(new ImagePreviewUI.11(this, paramIntent));
      com.tencent.mm.plugin.gallery.model.c.aXa().b((String)localObject1, ((GalleryItem.MediaItem)localObject2).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject2).kGX);
      y.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      return;
    }
    setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
    finish();
  }
  
  @TargetApi(16)
  public void onCreate(Bundle paramBundle)
  {
    long l = bk.UZ();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new ah().post(new ImagePreviewUI.12(this, l));
    bindService(new Intent(this.mController.uMN, GalleryStubService.class), this.iAC, 1);
    initView();
    y.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bk.cp(l)) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      y.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      q.buU.rJ().rI();
    }
    if (this.kJB != null) {
      this.kJB.release();
    }
    com.tencent.mm.plugin.gallery.model.c.y(null);
    unbindService(this.iAC);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.kJJ != null) {
      this.kJJ.stopTimer();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */