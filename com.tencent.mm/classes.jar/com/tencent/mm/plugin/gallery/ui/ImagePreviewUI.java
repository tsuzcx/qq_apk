package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.l;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

@com.tencent.mm.ui.base.a(19)
@com.tencent.mm.ui.widget.pulldown.c(0)
@TargetApi(16)
public class ImagePreviewUI
  extends MMActivity
{
  private int AYg;
  private ArrayList<GalleryItem.MediaItem> BZG;
  private String BZJ;
  private long CaD;
  private int CaG;
  private HashMap<String, Integer> CaU;
  private TextView Can;
  private boolean Cat;
  private boolean Cau;
  private boolean Caw;
  private boolean Cax;
  private boolean CbU;
  private d CcL;
  private MMViewPager CcM;
  private RecyclerView CcN;
  private ArrayList<String> CcO;
  private ArrayList<String> CcP;
  private ArrayList<GalleryItem.MediaItem> CcQ;
  private Integer CcR;
  private ImageButton CcS;
  private TextView CcT;
  private MTimerHandler CcU;
  private float CcV;
  private ImageButton CcW;
  private boolean CcX;
  private TextView CcY;
  private ViewGroup CcZ;
  private ViewGroup Cda;
  private boolean Cdb;
  private boolean Cdc;
  private int Cdd;
  private int Cde;
  private TextView Cdf;
  private TextView Cdg;
  private TextView Cdh;
  private TextView Cdi;
  private View Cdj;
  private TextView Cdk;
  private ProgressBar Cdl;
  private boolean Cdm;
  boolean Cdn;
  private d.b Cdo;
  private String Cdp;
  private String Cdq;
  private int Cdr;
  private String Cds;
  private int Cdt;
  private String Cdu;
  private int mediaType;
  private int nrt;
  private String path;
  private boolean tNu;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.CcV = 0.0F;
    this.Cdb = true;
    this.Cdc = true;
    this.Cat = true;
    this.Cdd = 0;
    this.CaD = 0L;
    this.Cde = 10;
    this.Cdm = false;
    this.mediaType = 0;
    this.Cdn = false;
    this.Cdo = null;
    this.Cdq = "";
    this.CaU = new HashMap();
    this.Cdr = 300000;
    this.Cdt = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.etl().pag != 4) && (com.tencent.mm.plugin.gallery.model.e.etl().pag != 14) && (com.tencent.mm.plugin.gallery.model.e.etl().pag != 13)))
    {
      this.Cdb = true;
      this.CcZ.setVisibility(0);
      this.Cda.setVisibility(8);
      this.Cdl.setVisibility(8);
      a(paramString, paramMediaItem, false);
      aID(paramString);
      enableOptionMenu(true);
      this.CcT.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.Cdf.setVisibility(0);
      }
      for (;;)
      {
        if ((com.tencent.mm.plugin.gallery.model.e.etl().pag == 15) || (com.tencent.mm.plugin.gallery.model.e.etl().pag == 28)) {
          this.Cdf.setVisibility(8);
        }
        if (this.Cau) {
          this.Cdf.setVisibility(8);
        }
        aIB(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        Log.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.etl().pag), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!Util.isNullOrNil(paramString))) {
          this.Cdf.setVisibility(0);
        } else {
          this.Cdf.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.Cdf.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25) {
        this.Cdf.setVisibility(8);
      }
      aIB(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.Cdb = false;
      this.CcZ.setVisibility(8);
      this.Cda.setVisibility(0);
      this.Cdk.setVisibility(8);
      if (!aIC(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.Cdf.setVisibility(8);
    }
    if (!Util.isNullOrNil(localVideoMediaItem.maR))
    {
      Log.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.AAz, Integer.valueOf(localVideoMediaItem.maT), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.Cdm);
      a(this.Cdm, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.Cdb = true;
    this.CcZ.setVisibility(0);
    this.Cda.setVisibility(8);
    this.CcT.setVisibility(8);
    a(paramString, paramMediaItem, false);
    aID(paramString);
    paramMediaItem = new t(paramString, this.CcR.intValue(), localVideoMediaItem, new t.a()
    {
      public final void a(t paramAnonymoust)
      {
        AppMethodBeat.i(111579);
        if (paramAnonymoust.equals(ImagePreviewUI.A(ImagePreviewUI.this).getTag())) {
          ImagePreviewUI.A(ImagePreviewUI.this).setTag(null);
        }
        if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
        {
          AppMethodBeat.o(111579);
          return;
        }
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.BWt, ImagePreviewUI.B(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.B(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.Cdl.getTag()))
    {
      Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.Cdl.setTag(paramMediaItem);
    com.tencent.e.h.ZvG.be(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 15) {
      this.Cdf.setVisibility(8);
    }
    if (this.Cau) {
      this.Cdf.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    int i = com.tencent.mm.plugin.gallery.model.e.etl().BVD;
    int j = com.tencent.mm.plugin.gallery.model.e.etl().pag;
    if ((j != 16) && ((i == 2) || (i == 3)))
    {
      i = 1;
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 2) && (j == 4) && (!paramBoolean) && (i == 0)) {
        break label201;
      }
      if (this.AYg != 1) {
        break label148;
      }
      this.CcW.setVisibility(8);
      this.CcY.setVisibility(8);
    }
    for (;;)
    {
      if (this.CcP.contains(paramString)) {
        break label167;
      }
      this.CcW.setImageResource(b.h.radio_off);
      this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
      AppMethodBeat.o(111619);
      return;
      i = 0;
      break;
      label148:
      this.CcW.setVisibility(0);
      this.CcY.setVisibility(0);
    }
    label167:
    this.CcW.setImageResource(euP());
    this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_choosed_desc));
    AppMethodBeat.o(111619);
    return;
    label201:
    this.CcW.setVisibility(8);
    this.CcY.setVisibility(8);
    AppMethodBeat.o(111619);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111609);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(111609);
      return;
    }
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.e.az(this.CcQ)))
    {
      this.Cdk.setVisibility(8);
      this.CcT.setVisibility(8);
      this.Cda.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.Cdb = false;
    this.CcZ.setVisibility(8);
    this.Cda.setVisibility(0);
    this.Cdk.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 13)
    {
      this.Cda.setVisibility(8);
      this.CcZ.setVisibility(8);
      this.Cdg.setVisibility(8);
      this.Cdh.setVisibility(8);
      enableOptionMenu(true);
      AppMethodBeat.o(111611);
      return true;
    }
    if (c(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if (d(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if ((!paramBoolean) && (b(paramVideoMediaItem)))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    enableOptionMenu(true);
    this.Cdb = true;
    this.CcZ.setVisibility(0);
    this.Cda.setVisibility(8);
    this.CcT.setVisibility(0);
    this.Cdl.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    aID(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void aIA(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(111598);
    GalleryItem.MediaItem localMediaItem;
    Object localObject2;
    int i;
    int j;
    if (!this.CcP.contains(paramString))
    {
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.aIs(paramString);
      if (this.CcP.size() >= this.AYg)
      {
        if ((this.mediaType == 2) || ((!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_bubble_media_by_coordinate")))) {
          paramString = getResources().getQuantityString(b.g.gallery_pic_or_video_limit, this.AYg, new Object[] { Integer.valueOf(this.AYg) });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.cO(getContext(), paramString);
          this.CcW.setImageResource(b.h.radio_off);
          this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
          this.CcX = false;
          if (!Util.isNullOrNil(this.CcP)) {
            break;
          }
          AppMethodBeat.o(111598);
          return;
          if (this.mediaType == 1) {
            paramString = getResources().getQuantityString(b.g.gallery_video_limit, this.AYg, new Object[] { Integer.valueOf(this.AYg) });
          } else {
            paramString = getResources().getQuantityString(b.g.gallery_pic_limit, this.AYg, new Object[] { Integer.valueOf(this.AYg) });
          }
        }
      }
      if (!(localMediaItem instanceof GalleryItem.ImageMediaItem)) {
        break label1202;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(localMediaItem.AAz, (BitmapFactory.Options)localObject2);
      i = ((BitmapFactory.Options)localObject2).outWidth;
      j = ((BitmapFactory.Options)localObject2).outHeight;
    }
    for (;;)
    {
      if ((localMediaItem instanceof GalleryItem.VideoMediaItem))
      {
        localObject2 = (GalleryItem.VideoMediaItem)localMediaItem;
        i = ((GalleryItem.VideoMediaItem)localObject2).videoWidth;
        j = ((GalleryItem.VideoMediaItem)localObject2).videoHeight;
      }
      if (this.CcV != 0.0F) {
        if ((i == 0) || (j == 0))
        {
          i = 0;
          label325:
          if (i != 0) {
            break label458;
          }
          if (!(localMediaItem instanceof GalleryItem.ImageMediaItem)) {
            break label433;
          }
          paramString = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
        }
      }
      for (;;)
      {
        if (paramString != null) {
          com.tencent.mm.ui.base.h.cO(getContext(), paramString);
        }
        this.CcW.setImageResource(b.h.radio_off);
        this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
        this.CcX = false;
        break;
        float f = i / j;
        if ((f > this.CcV) || (f < 1.0F / this.CcV))
        {
          i = 0;
          break label325;
        }
        i = 1;
        break label325;
        label433:
        paramString = (String)localObject1;
        if ((localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          paramString = getResources().getString(b.i.gallery_select_video_ratio_not_support);
        }
      }
      label458:
      if (localMediaItem != null)
      {
        if ((localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aus(paramString)))
        {
          com.tencent.mm.ui.base.h.cO(this, getString(b.i.gallery_select_gif_to_big));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) && (!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_byp")))
        {
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aut(localMediaItem.AAz))
          {
            com.tencent.mm.ui.base.h.cO(this, getString(b.i.gallery_no_support_giant_gif_gamelife));
            AppMethodBeat.o(111598);
          }
        }
        else if ((localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          if ((!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localMediaItem).maT >= this.nrt * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cO(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.nrt) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
          {
            if (((GalleryItem.VideoMediaItem)localMediaItem).maT > this.nrt * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cO(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.nrt) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localMediaItem).maT < this.CaG * 1000)
            {
              com.tencent.mm.ui.base.h.cO(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(this.CaG) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.CcQ != null)
        {
          localObject1 = this.CcQ.iterator();
          i = 0;
          label853:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (GalleryItem.MediaItem)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).AAz.equalsIgnoreCase(localMediaItem.AAz))) {
              break label1199;
            }
            i = 1;
          }
        }
      }
      label1041:
      label1196:
      label1199:
      for (;;)
      {
        break label853;
        if (i == 0) {
          this.CcQ.add(localMediaItem);
        }
        this.CcP.add(paramString);
        this.CcW.setImageResource(euP());
        this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_choosed_desc));
        this.CcX = true;
        c(this.CcP.size(), this.CcR.intValue(), paramString, 0);
        break;
        this.CcW.setImageResource(b.h.radio_off);
        this.CcW.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
        this.CcX = false;
        while (this.CcP.remove(paramString)) {}
        if (this.CcQ != null)
        {
          localObject2 = this.CcQ.iterator();
          localObject1 = null;
          if (((Iterator)localObject2).hasNext())
          {
            localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localMediaItem == null) || (!localMediaItem.AAz.equalsIgnoreCase(paramString))) {
              break label1196;
            }
            localObject1 = localMediaItem;
          }
        }
        for (;;)
        {
          break label1041;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).AAz });
            this.CcQ.remove(localObject1);
          }
          c(this.CcP.size(), this.CcR.intValue(), paramString, 1);
          break;
          paramString = this.CcP.iterator();
          while (paramString.hasNext()) {
            if (!ImgUtil.isGif((String)paramString.next()))
            {
              AppMethodBeat.o(111598);
              return;
            }
          }
          this.tNu = true;
          AppMethodBeat.o(111598);
          return;
        }
      }
      label1202:
      j = 0;
      i = 0;
    }
  }
  
  private void aIB(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.CcP.size() >= 9) && (!this.CcP.contains(paramString)))
    {
      this.Cdf.setTextColor(getContext().getResources().getColor(b.b.white_text_color_disabled));
      this.Cdf.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.Cdf.setEnabled(true);
    this.Cdf.setTextColor(getContext().getResources().getColor(b.b.white_text_color));
    AppMethodBeat.o(111610);
  }
  
  private boolean aIC(String paramString)
  {
    AppMethodBeat.i(111613);
    if (u.bBQ(paramString) > 1073741824L)
    {
      this.Cdg.setText(getString(b.i.gallery_pic_video_too_large_title));
      this.Cdh.setText(getString(b.i.gallery_pic_video_too_large_desc));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private void aID(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.etl().pag)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.aIs(paramString);
      if ((localMediaItem != null) && (localMediaItem.getType() == 2))
      {
        localObject = Boolean.TRUE;
        i = 0;
        label131:
        if ((localMediaItem != null) || (!ImgUtil.isGif(paramString))) {
          break label223;
        }
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if (((this.Caw) && (i != 0)) || (!paramString.booleanValue())) {
        break label253;
      }
      this.CcS.setVisibility(8);
      this.Can.setVisibility(8);
      AppMethodBeat.o(111620);
      return;
      localBoolean = Boolean.TRUE;
      break;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 1) {
          break label131;
        }
      }
      i = 0;
      localObject = localBoolean;
      break label131;
      label223:
      paramString = (String)localObject;
      if (localMediaItem != null)
      {
        paramString = (String)localObject;
        if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
          paramString = Boolean.TRUE;
        }
      }
    }
    label253:
    this.CcS.setVisibility(0);
    this.Can.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    Log.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.maT) });
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.maT <= 1000)
    {
      this.Cdg.setText(getString(b.i.gallery_pic_video_too_short_title));
      this.Cdh.setText(getString(b.i.gallery_pic_video_too_short_desc));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.maT >= 300000)
    {
      this.Cdg.setText(getString(b.i.gallery_pic_video_too_long_title));
      this.Cdh.setText(getString(b.i.gallery_pic_video_too_long_desc));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.maT >= this.Cde * 1000 + 500)
    {
      this.Cdg.setText(getString(b.i.gallery_pic_edit_video));
      this.Cdh.setText(getString(b.i.gallery_pic_edit_des_config, new Object[] { Integer.valueOf(this.Cde) }));
      this.Cdk.setVisibility(0);
      AppMethodBeat.o(111614);
      return true;
    }
    AppMethodBeat.o(111614);
    return false;
  }
  
  private void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    Log.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.CbU))
    {
      this.CcN.getAdapter().d(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag != 13) {
        break label367;
      }
      paramInt2 = 1;
      label72:
      paramString = this.CcL.Th(this.CcR.intValue());
      if ((26 != com.tencent.mm.plugin.gallery.model.e.etl().pag) && (paramInt1 != 0) && (((!this.Cat) || (this.Cdm)) && ((paramInt2 == 0) || (this.CcL == null) || (paramString == null) || (paramString.getType() != 2)))) {
        break label372;
      }
    }
    label367:
    label372:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label377;
      }
      this.CcN.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.CcN.getAdapter()).aIE(paramString);
        ((g)this.CcN.getAdapter()).hB(paramInt1 - 1, this.CcR.intValue());
        this.CcN.getAdapter().cM(paramInt1 - 1);
        paramString = this.CcN;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramString, locala.aFh(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.CcN.getAdapter()).bf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.CcN.getAdapter()).remove(paramInt2);
      this.CcN.getAdapter().cN(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label377:
    this.CcN.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111616);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        Log.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.Cdg.setText(getString(b.i.gallery_pic_video_special_ratio));
      this.Cdh.setText(getString(b.i.gallery_pic_video_special_ratio_desc));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private boolean d(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(244744);
    Log.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    if ((paramVideoMediaItem == null) || (!com.tencent.mm.plugin.gallery.a.a.CeX.b(com.tencent.mm.plugin.gallery.model.e.etl().pag, paramVideoMediaItem)))
    {
      if (paramVideoMediaItem == null) {}
      for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.maR)
      {
        Log.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
        euO();
        AppMethodBeat.o(244744);
        return true;
      }
    }
    AppMethodBeat.o(244744);
    return false;
  }
  
  private void e(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.Cdn = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.etp().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.etp().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      Log.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.CcO != null)
      {
        this.CcO.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.CcO.addAll((Collection)localObject3);
        }
        localObject3 = this.CcL.Th(this.CcR.intValue());
        if (localObject3 == null)
        {
          Log.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.CcR, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).BVj = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).AAz = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).wAy = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).BVk = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.eto().add(localObject3);
        if (this.Cdo != null) {
          com.tencent.mm.plugin.gallery.model.e.etk().b(this.Cdo);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.etk();
        paramIntent = new d.b()
        {
          public final void aIr(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new MMHandler(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.h(ImagePreviewUI.this).ay(ImagePreviewUI.u(ImagePreviewUI.this));
                Object localObject = (g)ImagePreviewUI.r(ImagePreviewUI.this).getAdapter();
                ArrayList localArrayList = ImagePreviewUI.u(ImagePreviewUI.this);
                ((g)localObject).CdI.clear();
                ((g)localObject).CdI.addAll(localArrayList);
                ((RecyclerView.a)localObject).alc.notifyChanged();
                localObject = ImagePreviewUI.10.this.val$data.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original) + ImagePreviewUI.euQ());
                if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.a.e.aII(paramAnonymousString))) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                AppMethodBeat.o(111570);
              }
            });
            com.tencent.mm.plugin.gallery.model.e.etk().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String eth()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.a.e.a(this.Cdx, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.Cdx + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.Cdo = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.etk().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).BVl, ((GalleryItem.MediaItem)localObject3).BVm);
        Log.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      }
    }
    AppMethodBeat.o(111600);
  }
  
  private String euM()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.etl().pag)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    case 27: 
    default: 
      if ((this.CcP.size() == 0) || (this.AYg <= 1))
      {
        str = getString(b.i.app_send);
        AppMethodBeat.o(111601);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
    case 22: 
    case 29: 
      if ((this.Cdm) && (com.tencent.mm.plugin.gallery.a.e.az(this.CcQ)))
      {
        str = getString(b.i.gallery_pic_video_generate_video) + "(" + this.CcP.size() + "/" + this.AYg + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.CcP.size() == 0) || (this.AYg <= 1))
      {
        str = getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(b.i.gallery_pic_timeline_send) + "(" + this.CcP.size() + "/" + this.AYg + ")";
      AppMethodBeat.o(111601);
      return str;
    case 11: 
    case 24: 
      str = getString(b.i.emoji_store_use);
      AppMethodBeat.o(111601);
      return str;
    case 7: 
    case 15: 
    case 16: 
    case 25: 
    case 26: 
    case 28: 
      if (((!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25))
      {
        if ((this.CcP.size() == 0) || (this.AYg <= 1))
        {
          str = getString(b.i.app_nextstep);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(b.i.app_nextstep) + "(" + this.CcP.size() + "/" + this.AYg + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.CcP.size() == 0) || (this.AYg <= 1))
      {
        str = getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(b.i.gallery_pic_timeline_send) + "(" + this.CcP.size() + "/" + this.AYg + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(b.i.gallery_pic_chatting_send, new Object[] { Integer.valueOf(this.CcP.size()), Integer.valueOf(this.AYg) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> euN()
  {
    AppMethodBeat.i(111602);
    if (this.CbU)
    {
      localArrayList = this.CcP;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.CcP != null)
    {
      localArrayList = new ArrayList(this.CcP.size());
      Iterator localIterator = this.CcO.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.CcP.contains(str)) {
          localArrayList.add(str);
        }
      }
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(1);
    AppMethodBeat.o(111602);
    return localArrayList;
  }
  
  private boolean euO()
  {
    AppMethodBeat.i(111615);
    this.Cdg.setText(getString(b.i.gallery_pic_video_not_support));
    this.Cdh.setText(getString(b.i.gallery_pic_video_not_support_desc));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int euP()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 15)
    {
      i = b.h.checkbox_selected_game;
      AppMethodBeat.o(111622);
      return i;
    }
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
    {
      i = b.h.checkbox_selected_orange;
      AppMethodBeat.o(111622);
      return i;
    }
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 28)
    {
      i = b.h.checkbox_selected_finder_live;
      AppMethodBeat.o(111622);
      return i;
    }
    int i = b.h.checkbox_selected_small;
    AppMethodBeat.o(111622);
    return i;
  }
  
  private void goBack()
  {
    boolean bool2 = true;
    AppMethodBeat.i(111605);
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.tNu)
    {
      bool1 = true;
      if (!this.Cat) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", euN());
      localIntent.putExtra("show_photo_edit_tip", this.Cdn);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void l(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111612);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject1;
    if (paramMediaItem.getType() == 2)
    {
      localObject1 = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.Cdr = 300000;
      this.Cds = getString(b.i.gallery_pic_video_too_long_desc);
      Object localObject2;
      int i;
      if (this.Cdd == 3)
      {
        localObject2 = com.tencent.mm.n.a.jwk;
        this.Cdr = (com.tencent.mm.n.a.awa() * 1000);
        localObject2 = com.tencent.mm.n.a.jwk;
        i = com.tencent.mm.n.a.awa() / 60;
        this.Cds = getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(i) });
        this.Cdt = 1000;
        this.Cdu = getString(b.i.gallery_pic_video_too_short_desc);
        if (((this.BZJ != null) && ((this.BZJ.equals("album_business_bubble_media_by_coordinate")) || (this.BZJ.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25))
        {
          this.Cdr = (this.nrt * 1000 + 500);
          this.Cds = getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.nrt) });
          if (this.CaG != 0)
          {
            this.Cdt = (this.CaG * 1000);
            this.Cdu = getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(this.CaG) });
          }
        }
        if (Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).maR)) {
          break label653;
        }
        Log.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { ((GalleryItem.VideoMediaItem)localObject1).AAz, Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).maT), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoHeight), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoWidth) });
        if ((((GalleryItem.VideoMediaItem)localObject1).maT < this.Cdr) && ((((GalleryItem.VideoMediaItem)localObject1).maT <= 0) || (((GalleryItem.VideoMediaItem)localObject1).maT >= this.Cdt))) {
          break label518;
        }
        this.Cdj.setVisibility(0);
        localObject2 = this.Cdi;
        if (((GalleryItem.VideoMediaItem)localObject1).maT < this.Cdr) {
          break label510;
        }
      }
      label510:
      for (paramMediaItem = this.Cds;; paramMediaItem = this.Cdu)
      {
        ((TextView)localObject2).setText(paramMediaItem);
        this.CcY.setEnabled(false);
        this.CcW.setEnabled(false);
        this.CcY.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
        if (this.CcP.size() != 0) {
          break label740;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(111612);
        return;
        if (this.Cdd != 4) {
          break;
        }
        localObject2 = com.tencent.mm.n.a.jwk;
        this.Cdr = (com.tencent.mm.n.a.awb() * 1000);
        localObject2 = com.tencent.mm.n.a.jwk;
        i = com.tencent.mm.n.a.awb() / 60;
        this.Cds = getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(i) });
        break;
      }
      label518:
      if (d((GalleryItem.VideoMediaItem)localObject1))
      {
        this.Cdj.setVisibility(0);
        this.Cdi.setText(getString(b.i.gallery_pic_video_not_support_desc));
        this.CcY.setEnabled(false);
        this.CcW.setEnabled(false);
        this.CcY.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
        if (this.CcP.size() == 0)
        {
          enableOptionMenu(false);
          AppMethodBeat.o(111612);
        }
      }
      else
      {
        this.CcY.setEnabled(true);
        this.CcW.setEnabled(true);
        this.CcY.setTextColor(getResources().getColor(b.b.white_text_color));
        this.Cdj.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
        label653:
        paramMediaItem = new t(paramMediaItem.AAz, this.CcR.intValue(), (GalleryItem.VideoMediaItem)localObject1, new t.a()
        {
          public final void a(t paramAnonymoust)
          {
            AppMethodBeat.i(111580);
            if (paramAnonymoust.equals(ImagePreviewUI.A(ImagePreviewUI.this).getTag())) {
              ImagePreviewUI.A(ImagePreviewUI.this).setTag(null);
            }
            if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
            {
              AppMethodBeat.o(111580);
              return;
            }
            if (TextUtils.isEmpty(paramAnonymoust.BWt.maR))
            {
              paramAnonymoust = ImagePreviewUI.this.getString(b.i.gallery_pic_video_not_support_desc);
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              ImagePreviewUI.C(ImagePreviewUI.this).setText(paramAnonymoust);
              ImagePreviewUI.p(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.p(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color_disabled));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
                ImagePreviewUI.this.enableOptionMenu(false);
              }
              AppMethodBeat.o(111580);
              return;
            }
            if ((paramAnonymoust.BWt.maT >= ImagePreviewUI.D(ImagePreviewUI.this)) || ((paramAnonymoust.BWt.maT > 0) && (paramAnonymoust.BWt.maT < ImagePreviewUI.E(ImagePreviewUI.this))))
            {
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              TextView localTextView = ImagePreviewUI.C(ImagePreviewUI.this);
              if (paramAnonymoust.BWt.maT >= ImagePreviewUI.D(ImagePreviewUI.this)) {}
              for (paramAnonymoust = ImagePreviewUI.F(ImagePreviewUI.this);; paramAnonymoust = ImagePreviewUI.G(ImagePreviewUI.this))
              {
                localTextView.setText(paramAnonymoust);
                ImagePreviewUI.p(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.p(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color_disabled));
                if (ImagePreviewUI.d(ImagePreviewUI.this).size() != 0) {
                  break;
                }
                ImagePreviewUI.this.enableOptionMenu(false);
                AppMethodBeat.o(111580);
                return;
              }
            }
            ImagePreviewUI.p(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.p(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color));
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
            AppMethodBeat.o(111580);
          }
        });
        if (paramMediaItem.equals(this.Cdl.getTag()))
        {
          Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
          AppMethodBeat.o(111612);
          return;
        }
        this.Cdl.setTag(paramMediaItem);
        com.tencent.e.h.ZvG.be(paramMediaItem);
      }
      label740:
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.CcY.setEnabled(true);
      this.CcW.setEnabled(true);
      this.CcY.setTextColor(getResources().getColor(b.b.white_text_color));
      if ((this.tNu) && (this.CcP.contains(paramMediaItem.AAz)) && (u.bBQ(paramMediaItem.AAz) > 26214400L))
      {
        this.Cdj.setVisibility(0);
        this.Cdi.setText(getString(b.i.gallery_select_image_to_big));
        AppMethodBeat.o(111612);
        return;
      }
      this.Cdj.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject1 = new com.tencent.mm.plugin.gif.f(paramMediaItem.AAz);
      long l = u.bBQ(paramMediaItem.AAz);
      try
      {
        if (((!this.CcP.contains(paramMediaItem.AAz)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.e.awI())) && (localObject1.Dna[0] <= com.tencent.mm.plugin.gallery.a.e.awH()) && (localObject1.Dna[1] <= com.tencent.mm.plugin.gallery.a.e.awH())) {
          break label1035;
        }
        this.CcY.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
        this.CcY.setEnabled(false);
        this.CcW.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        Log.e("MicroMsg.ImagePreviewUI", Util.stackTraceToString(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label1035:
    this.CcY.setTextColor(getResources().getColor(b.b.white_text_color));
    this.CcY.setEnabled(true);
    this.CcW.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.CcL == null)
    {
      Log.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.CcL.Th(this.CcR.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.Cdj.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111578);
          ImagePreviewUI.a(ImagePreviewUI.this, localMediaItem);
          AppMethodBeat.o(111578);
        }
      }, 400L);
      AppMethodBeat.o(111603);
      return;
    }
    this.Cdj.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    Log.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.Cdb);
    if (this.Cdb)
    {
      localObject = findViewById(b.e.cropimage_operator_ll);
      if (localObject != null) {
        break label134;
      }
      if (!this.Cdb) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      Log.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(b.e.gallery_edit_layout);
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag != 15) {
        break;
      }
      AppMethodBeat.o(111604);
      return;
    }
    label134:
    if (((paramBoolean) && (((View)localObject).getVisibility() == 0)) || ((!paramBoolean) && (((View)localObject).getVisibility() == 8)))
    {
      AppMethodBeat.o(111604);
      return;
    }
    if (paramBoolean)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, b.a.fast_faded_in));
    }
    while ((paramBoolean) && (this.CcN.getVisibility() == 8) && (this.CcP.size() > 0) && (26 != com.tencent.mm.plugin.gallery.model.e.etl().pag))
    {
      this.CcN.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, b.a.fast_faded_in);
      this.CcN.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, b.a.fast_faded_out));
    }
    if ((!paramBoolean) && (this.CcN.getVisibility() == 0))
    {
      this.CcN.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, b.a.fast_faded_out);
      this.CcN.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (com.tencent.mm.compatible.e.b.cr(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    ar.p(ar.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(111596);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.image_gallery_plugin;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111597);
    setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    this.Cdg = ((TextView)findViewById(b.e.gallery_edit_tv));
    this.Cdh = ((TextView)findViewById(b.e.gallery_edit_tv_des));
    this.Cdi = ((TextView)findViewById(b.e.item_legal_tip));
    this.Cdj = findViewById(b.e.item_legal_tip_layout);
    this.Cdj.postDelayed(new ImagePreviewUI.12(this), 100L);
    this.Cdk = ((TextView)findViewById(b.e.gallery_edit_tv_btn));
    this.Cdl = ((ProgressBar)findViewById(b.e.video_edit_progressbar));
    this.AYg = getIntent().getIntExtra("max_select_count", 9);
    this.Cde = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 4)
    {
      bool1 = true;
      this.Cat = bool1;
      localObject1 = getIntent();
      this.CcO = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.CcQ = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.mediaType = ((Intent)localObject1).getIntExtra("media_type", this.mediaType);
      this.CcP = new ArrayList();
      this.CcV = ((Intent)localObject1).getFloatExtra("key_support_max_ratio", 0.0F);
      if (this.CcO != null) {
        this.CcP.addAll(this.CcO);
      }
      this.BZG = com.tencent.mm.plugin.gallery.model.e.etn();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.BZG != null) {
        break label451;
      }
    }
    label451:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.BZG != null))
      {
        this.CbU = true;
        this.CcR = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        Log.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.CcR });
        if (this.CcR.intValue() >= 0) {}
      }
      else
      {
        this.CcR = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.SO(this.CcR.intValue());
      if ((this.CbU) || ((this.CcP != null) && (this.CcP.size() != 0))) {
        break label456;
      }
      Log.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label456:
    this.CcS = ((ImageButton)findViewById(b.e.original_image));
    this.Can = ((TextView)findViewById(b.e.original_image_tip));
    this.CcT = ((TextView)findViewById(b.e.video_edit_button));
    this.tNu = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.Cau = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.Caw = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.Cax = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.Cdd = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.Cdm = com.tencent.mm.plugin.gallery.a.e.evc();
    Log.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.Cdm) });
    Object localObject2;
    label658:
    label679:
    int i;
    if (this.tNu)
    {
      this.CcS.setImageResource(b.h.radio_on);
      this.CcS.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
      if (this.Cax) {
        this.CcS.setImageResource(b.h.radio_default_on);
      }
      localObject2 = this.CcS;
      if (this.Cax) {
        break label1789;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.Can;
      if (this.Cax) {
        break label1794;
      }
      bool1 = true;
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.CcP != null) && (this.CcP.size() == 1))
      {
        localObject2 = (String)this.CcP.get(0);
        if (((String)localObject2).endsWith(".jpg")) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              boolean bool1 = true;
              AppMethodBeat.i(111569);
              try
              {
                String str1 = this.val$path;
                String str2 = ImagePreviewUI.this.getIntent().getStringExtra("GalleryUI_ToUser");
                if (ImagePreviewUI.m(ImagePreviewUI.this)) {}
                for (;;)
                {
                  com.tencent.mm.plugin.gallery.a.e.b(str1, str2, bool1, true);
                  AppMethodBeat.o(111569);
                  return;
                  boolean bool2 = ImagePreviewUI.b(ImagePreviewUI.this);
                  if (bool2) {
                    bool1 = false;
                  }
                }
                return;
              }
              catch (Exception localException)
              {
                AppMethodBeat.o(111569);
              }
            }
          });
        }
      }
      this.Can.setText(getContext().getString(b.i.gallery_pic_original));
      this.CcS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = ImagePreviewUI.this;
          boolean bool;
          if (!ImagePreviewUI.b(ImagePreviewUI.this))
          {
            bool = true;
            ImagePreviewUI.b(paramAnonymousView, bool);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label209;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_on);
            ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            }
          }
          for (;;)
          {
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original) + ImagePreviewUI.euQ());
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111583);
            return;
            bool = false;
            break;
            label209:
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_off);
            ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
          }
        }
      });
      this.CcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (Util.isNullOrNil(paramAnonymousView))
          {
            Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111584);
            return;
          }
          Log.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          localObject = new StringBuilder();
          s.bqA();
          localObject = s.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          s.bqA();
          paramAnonymousView = RecordConfigProvider.ay(paramAnonymousView, (String)localObject, s.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.mfk = com.tencent.mm.modelcontrol.e.bkp().bks();
          paramAnonymousView.HLb = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.etl().pag;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).avX();
          ((UICustomParam.a)localObject).avW();
          ((UICustomParam.a)localObject).dZ(true);
          paramAnonymousView.HKT = ((UICustomParam.a)localObject).jwj;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111584);
        }
      });
      this.Cdk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (Util.isNullOrNil(paramAnonymousView))
          {
            Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111585);
            return;
          }
          localObject = new StringBuilder();
          s.bqA();
          localObject = s.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          s.bqA();
          paramAnonymousView = RecordConfigProvider.ay(paramAnonymousView, (String)localObject, s.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.HLb = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.mfk = com.tencent.mm.modelcontrol.e.bkp().bks();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.etl().pag;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).avX();
          ((UICustomParam.a)localObject).avW();
          ((UICustomParam.a)localObject).dZ(true);
          paramAnonymousView.HKT = ((UICustomParam.a)localObject).jwj;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111585);
        }
      });
      this.Can.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111586);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ImagePreviewUI.c(ImagePreviewUI.this).performClick();
          if (ImagePreviewUI.b(ImagePreviewUI.this)) {
            ImagePreviewUI.f(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111586);
            return;
            ImagePreviewUI.f(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
          }
        }
      });
      setBackBtn(new ImagePreviewUI.24(this));
      this.BZJ = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.nrt = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.CaG = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = w.b.WaA;
      switch (com.tencent.mm.plugin.gallery.model.e.etl().pag)
      {
      default: 
        label928:
        addTextOptionMenu(0, euM(), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 0;
            AppMethodBeat.i(111590);
            if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
            {
              ImagePreviewUI.this.setResult(1);
              paramAnonymousMenuItem = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!Util.isNullOrNil(paramAnonymousMenuItem)) {
                a.a.BTR.an(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              ImagePreviewUI.this.finish();
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
            Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
            int i;
            if ((localObject != null) && (((ArrayList)localObject).size() == 0))
            {
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).Th(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
              {
                ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).AAz);
                localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
                if (!Util.isNullOrNil((String)localObject)) {
                  a.a.BTR.an((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
                }
                i = 0;
              }
            }
            for (;;)
            {
              if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
              {
                paramAnonymousMenuItem.putStringArrayListExtra("preview_image_list", ImagePreviewUI.l(ImagePreviewUI.this));
                ImagePreviewUI.this.setResult(25, paramAnonymousMenuItem);
                ImagePreviewUI.this.finish();
              }
              if (!ImagePreviewUI.b(ImagePreviewUI.this)) {}
              final boolean bool2;
              for (final boolean bool1 = true;; bool1 = false)
              {
                bool2 = ImagePreviewUI.m(ImagePreviewUI.this);
                if (i != 0) {
                  break label384;
                }
                ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousMenuItem, bool2, bool1);
                AppMethodBeat.o(111590);
                return true;
                ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                i = 300;
                break;
              }
              label384:
              localObject = com.tencent.mm.plugin.gallery.model.e.etm();
              paramAnonymousMenuItem = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111588);
                  ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousMenuItem, bool2, bool1);
                  AppMethodBeat.o(111588);
                }
                
                public final String toString()
                {
                  AppMethodBeat.i(111589);
                  String str = super.toString() + "|addTextOptionMenu";
                  AppMethodBeat.o(111589);
                  return str;
                }
              };
              if (i < 0) {
                i = j;
              }
              for (;;)
              {
                ((com.tencent.mm.plugin.gallery.model.g)localObject).etE().postDelayed(paramAnonymousMenuItem, i);
                AppMethodBeat.o(111590);
                return true;
              }
              i = 0;
            }
          }
        }, null, (w.b)localObject1);
        if (26 == com.tencent.mm.plugin.gallery.model.e.etl().pag) {
          removeOptionMenu(0);
        }
        this.CcW = ((ImageButton)findViewById(b.e.photos_select_checkbox));
        this.CcW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111591);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if (Util.isNullOrNil(paramAnonymousView))
            {
              Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111591);
              return;
            }
            ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original) + ImagePreviewUI.euQ());
            ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
            a.a.BTR.an(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111591);
          }
        });
        this.CcY = ((TextView)findViewById(b.e.photos_select_tv));
        this.CcY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111560);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            if (ImagePreviewUI.o(ImagePreviewUI.this)) {
              ImagePreviewUI.p(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111560);
              return;
              ImagePreviewUI.p(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
            }
          }
        });
        if (this.AYg == 1)
        {
          this.CcW.setVisibility(8);
          this.CcY.setVisibility(8);
        }
        this.CcZ = ((ViewGroup)findViewById(b.e.cropimage_operator_ll));
        this.Cda = ((ViewGroup)findViewById(b.e.gallery_edit_layout));
        if (this.CcZ != null)
        {
          this.CcZ.setVisibility(8);
          this.CcZ.setOnClickListener(new ImagePreviewUI.3(this));
        }
        if (this.Cda != null)
        {
          this.Cda.setVisibility(8);
          this.Cda.setOnClickListener(new ImagePreviewUI.4(this));
        }
        this.Cdf = ((TextView)findViewById(b.e.photo_edit_button));
        this.Cdf.setOnClickListener(new ImagePreviewUI.5(this));
        this.CcN = ((RecyclerView)findViewById(b.e.image_preview_recycler_view));
        this.CcN.getItemAnimator().ali = 66L;
        this.CcN.a(new ImagePreviewUI.6(this));
        localObject1 = new SpeedyLinearLayoutManager();
        ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
        this.CcN.setLayoutManager((RecyclerView.LayoutManager)localObject1);
        i = getResources().getDisplayMetrics().widthPixels / 7;
        localObject1 = new g(this, this.CcP, i, this.CbU);
        this.CcN.setAdapter((RecyclerView.a)localObject1);
        this.CcN.post(new ImagePreviewUI.7(this));
        if ((this.CcP.size() > 0) && (26 != com.tencent.mm.plugin.gallery.model.e.etl().pag))
        {
          this.CcN.setVisibility(0);
          label1321:
          this.CcN.setItemAnimator(new androidx.recyclerview.widget.g());
          ((g)localObject1).CdM.a(this.CcN);
          ((g)localObject1).CdJ = new g.b()
          {
            public final void Tk(int paramAnonymousInt)
            {
              AppMethodBeat.i(111566);
              Log.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.s(ImagePreviewUI.this)) });
              ((g)ImagePreviewUI.r(ImagePreviewUI.this).getAdapter()).hB(paramAnonymousInt, paramAnonymousInt);
              ImagePreviewUI.t(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
              if (!ImagePreviewUI.s(ImagePreviewUI.this))
              {
                com.tencent.mm.plugin.gallery.model.e.BUA = true;
                AppMethodBeat.o(111566);
                return;
              }
              com.tencent.mm.plugin.gallery.model.e.BUy = true;
              AppMethodBeat.o(111566);
            }
            
            public final void an(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(111568);
              Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
              if (!ImagePreviewUI.s(ImagePreviewUI.this))
              {
                com.tencent.mm.plugin.gallery.a.e.e(ImagePreviewUI.u(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
                d locald = ImagePreviewUI.h(ImagePreviewUI.this);
                int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
                Log.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
                if (!locald.CbU)
                {
                  com.tencent.mm.plugin.gallery.a.e.e(locald.CbT, paramAnonymousInt1, paramAnonymousInt2);
                  locald.fYT = paramAnonymousInt3;
                  locald.CbW = ((View)locald.WnN.get(i));
                  locald.WnL.remove(locald.CbW);
                  locald.WnM.clear();
                  locald.WnN.clear();
                  locald.CbX = true;
                  locald.notifyDataSetChanged();
                }
                ImagePreviewUI.t(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
                ((g)ImagePreviewUI.r(ImagePreviewUI.this).getAdapter()).hB(paramAnonymousInt3, paramAnonymousInt3);
                com.tencent.mm.plugin.gallery.model.e.BUz = true;
                AppMethodBeat.o(111568);
                return;
              }
              com.tencent.mm.plugin.gallery.a.e.e(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
              com.tencent.mm.plugin.gallery.model.e.BUx = true;
              AppMethodBeat.o(111568);
            }
            
            public final void hA(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(111567);
              Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
              AppMethodBeat.o(111567);
            }
          };
          this.CcM = ((MMViewPager)findViewById(b.e.gallery));
          this.CcM.setVerticalFadingEdgeEnabled(false);
          this.CcM.setHorizontalFadingEdgeEnabled(false);
          this.CcM.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
          {
            public final void onPageScrollStateChanged(int paramAnonymousInt)
            {
              AppMethodBeat.i(111574);
              if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
                ImagePreviewUI.h(ImagePreviewUI.this).Cca.onPageScrollStateChanged(paramAnonymousInt);
              }
              AppMethodBeat.o(111574);
            }
            
            public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
            
            public final void onPageSelected(int paramAnonymousInt)
            {
              boolean bool2 = true;
              AppMethodBeat.i(111573);
              com.tencent.mm.plugin.gallery.model.e.SO(paramAnonymousInt);
              String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
              ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
              boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
              ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
              Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
              int i;
              if (bool1)
              {
                i = ImagePreviewUI.euR();
                ((ImageButton)localObject).setImageResource(i);
                ImageButton localImageButton = ImagePreviewUI.e(ImagePreviewUI.this);
                if (!bool1) {
                  break label387;
                }
                localObject = ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_choosed_desc);
                label111:
                localImageButton.setContentDescription((CharSequence)localObject);
                if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
                  break label405;
                }
                ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_on);
                ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
                label164:
                if (ImagePreviewUI.v(ImagePreviewUI.this)) {
                  ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_default_on);
                }
                localObject = ImagePreviewUI.c(ImagePreviewUI.this);
                if (ImagePreviewUI.v(ImagePreviewUI.this)) {
                  break label444;
                }
                bool1 = true;
                label208:
                ((ImageButton)localObject).setEnabled(bool1);
                localObject = ImagePreviewUI.f(ImagePreviewUI.this);
                if (ImagePreviewUI.v(ImagePreviewUI.this)) {
                  break label449;
                }
              }
              label387:
              label405:
              label444:
              label449:
              for (bool1 = bool2;; bool1 = false)
              {
                ((TextView)localObject).setEnabled(bool1);
                ImagePreviewUI.this.setMMTitle(paramAnonymousInt + 1 + "/" + ImagePreviewUI.h(ImagePreviewUI.this).getCount());
                ImagePreviewUI.h(ImagePreviewUI.this).CbZ.onPageSelected(paramAnonymousInt);
                Log.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
                localObject = com.tencent.mm.plugin.gallery.model.e.aIs(str);
                if ((ImagePreviewUI.w(ImagePreviewUI.this).getVisibility() == 0) || (ImagePreviewUI.x(ImagePreviewUI.this).getVisibility() == 0))
                {
                  ImagePreviewUI.a(ImagePreviewUI.this, str, (GalleryItem.MediaItem)localObject);
                  ImagePreviewUI.a(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
                }
                ImagePreviewUI.h(ImagePreviewUI.this).stopAll();
                AppMethodBeat.o(111573);
                return;
                i = b.h.radio_off;
                break;
                localObject = ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc);
                break label111;
                ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_off);
                ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
                break label164;
                bool1 = false;
                break label208;
              }
            }
          });
          this.CcM.setSingleClickOverListener(new MMViewPager.f()
          {
            public final void bwB()
            {
              AppMethodBeat.i(111576);
              ImagePreviewUI.y(ImagePreviewUI.this);
              AppMethodBeat.o(111576);
            }
            
            public final void euS() {}
          });
          this.CcL = new d(this);
          ((g)this.CcN.getAdapter()).CdG = this.CcL;
          if (this.CbU) {
            break label1835;
          }
          this.CcL.ay(this.CcO);
          this.CcL.CbU = false;
          if (this.CcO.size() <= 0) {
            break label1944;
          }
          localObject1 = (String)this.CcO.get(this.CcR.intValue());
        }
        break;
      }
    }
    for (;;)
    {
      this.CcM.setAdapter(this.CcL);
      this.CcM.setCurrentItem(this.CcR.intValue());
      this.CcL.bPt = this.CcR.intValue();
      i = euN().indexOf(this.CcL.getItem(this.CcR.intValue()));
      ((g)this.CcN.getAdapter()).hB(i, this.CcR.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.aIs((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      l((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.CcR.intValue() + 1 + "/" + this.CcL.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
      {
        ((ViewGroup)this.CcN.getParent()).removeView(this.CcN);
        this.CcN.setVisibility(8);
        findViewById(b.e.orignal_image_layout).setVisibility(4);
        findViewById(b.e.gallery_edit_tv_des).setVisibility(4);
        findViewById(b.e.photo_edit_button).setVisibility(4);
        findViewById(b.e.gallery_edit_tv).setVisibility(4);
        findViewById(b.e.video_edit_button).setVisibility(4);
        findViewById(b.e.gallery_edit_tv_btn).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.CcS.setImageResource(b.h.radio_off);
      this.CcS.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
      break;
      label1789:
      bool1 = false;
      break label658;
      label1794:
      bool1 = false;
      break label679;
      localObject1 = w.b.Way;
      break label928;
      localObject1 = w.b.Waz;
      break label928;
      localObject1 = w.b.WaE;
      break label928;
      this.CcN.setVisibility(8);
      break label1321;
      label1835:
      localObject1 = this.CcL;
      localObject2 = this.BZG;
      ((d)localObject1).BZG.clear();
      ((d)localObject1).BZG.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.CcL.CbU = true;
      if (this.CcR.intValue() >= this.BZG.size()) {
        this.CcR = Integer.valueOf(0);
      }
      if (this.BZG.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.BZG.get(this.CcR.intValue())).AAz;
      } else {
        label1944:
        localObject1 = "";
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(111599);
    Log.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    Object localObject;
    while (paramInt1 == 4372) {
      if ((paramIntent == null) || (this.CcN == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.CcP.size() > 0)
        {
          aIA((String)this.CcP.get(0));
        }
        else
        {
          Log.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.CcP.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).fvU().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              setResult(-1, paramIntent);
            }
            if (paramIntent != null)
            {
              setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
              finish();
            }
          }
        }
      }
      else
      {
        CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList4 = ((g)this.CcN.getAdapter()).CdI;
        ArrayList localArrayList3 = this.CcP;
        this.Cdq = (this.Cdq + localCaptureVideoNormalModel.fvU().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
        paramInt1 = 0;
        int i;
        String str;
        for (;;)
        {
          i = j;
          if (localArrayList4 == null) {
            break;
          }
          i = j;
          if (paramInt1 >= localArrayList4.size()) {
            break;
          }
          str = (String)localArrayList4.get(paramInt1);
          if (!str.equalsIgnoreCase(Util.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.Cdp))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList1.add(localObject);
          paramInt1 += 1;
        }
        while ((localArrayList3 != null) && (i < localArrayList3.size()))
        {
          str = (String)localArrayList3.get(i);
          if (!str.equalsIgnoreCase(Util.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.Cdp))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        u.deleteFile(this.Cdp);
        paramIntent.putExtra("max_select_count", 9);
        paramIntent.putExtra("isPreviewPhoto", true);
        paramIntent.putExtra("raw_photo_path", this.path);
        paramIntent.putExtra("after_photo_edit", localCaptureVideoNormalModel.thumbPath);
        paramIntent.putStringArrayListExtra("preview_image_list", localArrayList1);
        paramIntent.putStringArrayListExtra("preview_select_image_list", localArrayList2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("raw_photo_path", this.path);
        ((Bundle)localObject).putString("after_photo_edit", localCaptureVideoNormalModel.thumbPath);
        paramIntent.putExtra("report_info", (Bundle)localObject);
        e(paramInt2, paramIntent);
        AppMethodBeat.o(111599);
        return;
      }
    }
    if (paramInt1 == 4381)
    {
      if (paramInt2 == -1)
      {
        if (this.Cat)
        {
          paramIntent = RecordConfigProvider.jP("", "");
          paramIntent.HLb = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).wwk = 1;
          paramIntent.HLk = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).avX();
          ((UICustomParam.a)localObject).avW();
          ((UICustomParam.a)localObject).dZ(true);
          paramIntent.HKT = ((UICustomParam.a)localObject).jwj;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.etl().pag)
        {
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111599);
        }
      }
      else
      {
        Toast.makeText(this, b.i.loading_failed, 1).show();
        AppMethodBeat.o(111599);
      }
    }
    else if (paramIntent != null)
    {
      setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
      finish();
    }
    AppMethodBeat.o(111599);
  }
  
  @TargetApi(16)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111593);
    final long l = Util.currentTicks();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    ar.bs(this);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111559);
        ImagePreviewUI.a(ImagePreviewUI.this, true);
        Log.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(111559);
      }
    });
    Log.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    Log.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.etl().pag == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      Log.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.eto().clear();
    }
    if (this.CcL != null) {
      this.CcL.release();
    }
    com.tencent.mm.plugin.gallery.model.e.au(null);
    ab.fax.YG().YF();
    if (this.Cdo != null) {
      com.tencent.mm.plugin.gallery.model.e.etk().b(this.Cdo);
    }
    AppMethodBeat.o(111607);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111606);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(111606);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111606);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(111595);
    if (this.CcU != null) {
      this.CcU.stopTimer();
    }
    this.CcL.stopAll();
    super.onPause();
    AppMethodBeat.o(111595);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111594);
    super.onResume();
    AppMethodBeat.o(111594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */