package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

@com.tencent.mm.ui.base.a(19)
@TargetApi(16)
public class ImagePreviewUI
  extends MMActivity
{
  private int jbG;
  private boolean opQ;
  private String path;
  private int rXO;
  private ArrayList<GalleryItem.MediaItem> sOJ;
  private String sOM;
  private boolean sPA;
  private long sPG;
  private int sPJ;
  private HashMap<String, Integer> sPW;
  private HashSet<String> sPX;
  private TextView sPq;
  private boolean sPw;
  private boolean sPx;
  private boolean sPz;
  private boolean sQR;
  private d sRI;
  private MMViewPager sRJ;
  private RecyclerView sRK;
  private ArrayList<String> sRL;
  private ArrayList<String> sRM;
  private ArrayList<GalleryItem.MediaItem> sRN;
  private Integer sRO;
  private ImageButton sRP;
  private TextView sRQ;
  private au sRR;
  private ImageButton sRS;
  private TextView sRT;
  private ViewGroup sRU;
  private ViewGroup sRV;
  private boolean sRW;
  private boolean sRX;
  private int sRY;
  private int sRZ;
  private TextView sSa;
  private TextView sSb;
  private TextView sSc;
  private TextView sSd;
  private View sSe;
  private TextView sSf;
  private ProgressBar sSg;
  private boolean sSh;
  boolean sSi;
  private d.b sSj;
  private String sSk;
  private String sSl;
  private int sSm;
  private String sSn;
  private int sSo;
  private String sSp;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.sRW = true;
    this.sRX = true;
    this.sPw = true;
    this.sRY = 0;
    this.sPG = 0L;
    this.sRZ = 10;
    this.sSh = false;
    this.sSi = false;
    this.sSj = null;
    this.sSl = "";
    this.sPW = new HashMap();
    this.sSm = 300000;
    this.sSo = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 4) && (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 14) && (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 13)))
    {
      this.sRW = true;
      this.sRU.setVisibility(0);
      this.sRV.setVisibility(8);
      this.sSg.setVisibility(8);
      a(paramString, paramMediaItem, false);
      agF(paramString);
      enableOptionMenu(true);
      this.sRQ.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.sSa.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 15) {
          this.sSa.setVisibility(8);
        }
        if (this.sPx) {
          this.sSa.setVisibility(8);
        }
        agC(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        ac.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.cMt().kxr), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!bs.isNullOrNil(paramString))) {
          this.sSa.setVisibility(0);
        } else {
          this.sSa.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.sSa.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25) {
        this.sSa.setVisibility(8);
      }
      agC(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.sRW = false;
      this.sRU.setVisibility(8);
      this.sRV.setVisibility(0);
      this.sSf.setVisibility(8);
      if (!agD(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.sSa.setVisibility(8);
    }
    if (!bs.isNullOrNil(localVideoMediaItem.hTu))
    {
      ac.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.sKh, Integer.valueOf(localVideoMediaItem.hTw), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.sSh);
      a(this.sSh, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.sRW = true;
    this.sRU.setVisibility(0);
    this.sRV.setVisibility(8);
    this.sRQ.setVisibility(8);
    a(paramString, paramMediaItem, false);
    agF(paramString);
    paramMediaItem = new t(paramString, this.sRO.intValue(), localVideoMediaItem, new t.a()
    {
      public final void a(t paramAnonymoust)
      {
        AppMethodBeat.i(111579);
        if (paramAnonymoust.equals(ImagePreviewUI.y(ImagePreviewUI.this).getTag())) {
          ImagePreviewUI.y(ImagePreviewUI.this).setTag(null);
        }
        if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
        {
          AppMethodBeat.o(111579);
          return;
        }
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.sLo, ImagePreviewUI.z(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.z(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.sSg.getTag()))
    {
      ac.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.sSg.setTag(paramMediaItem);
    com.tencent.e.h.JZN.aS(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 15) {
      this.sSa.setVisibility(8);
    }
    if (this.sPx) {
      this.sSa.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 4) || (paramBoolean))
    {
      if (this.rXO == 1)
      {
        this.sRS.setVisibility(8);
        this.sRT.setVisibility(8);
      }
      while (!this.sRM.contains(paramString))
      {
        this.sRS.setImageResource(2131691077);
        AppMethodBeat.o(111619);
        return;
        this.sRS.setVisibility(0);
        this.sRT.setVisibility(0);
      }
      this.sRS.setImageResource(cNT());
      AppMethodBeat.o(111619);
      return;
    }
    this.sRS.setVisibility(8);
    this.sRT.setVisibility(8);
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
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.d.ag(this.sRN)))
    {
      this.sSf.setVisibility(8);
      this.sRQ.setVisibility(8);
      this.sRV.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.sRW = false;
    this.sRU.setVisibility(8);
    this.sRV.setVisibility(0);
    this.sSf.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 13)
    {
      this.sRV.setVisibility(8);
      this.sRU.setVisibility(8);
      this.sSb.setVisibility(8);
      this.sSc.setVisibility(8);
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
    this.sRW = true;
    this.sRU.setVisibility(0);
    this.sRV.setVisibility(8);
    this.sRQ.setVisibility(0);
    this.sSg.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    agF(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void agB(String paramString)
  {
    AppMethodBeat.i(111598);
    Object localObject1;
    Object localObject2;
    int i;
    label459:
    Object localObject3;
    if (!this.sRM.contains(paramString))
    {
      if (this.sRM.size() >= this.rXO)
      {
        localObject1 = getResources().getQuantityString(2131623950, this.rXO, new Object[] { Integer.valueOf(this.rXO) });
        paramString = (String)localObject1;
        if (!bs.isNullOrNil(this.sOM))
        {
          paramString = (String)localObject1;
          if (this.sOM.equals("album_business_bubble_media_by_coordinate")) {
            paramString = getResources().getQuantityString(2131623951, this.rXO, new Object[] { Integer.valueOf(this.rXO) });
          }
        }
        com.tencent.mm.ui.base.h.cg(getContext(), paramString);
        this.sRS.setImageResource(2131691077);
        if (!bs.gY(this.sRM)) {
          break label700;
        }
        AppMethodBeat.o(111598);
        return;
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.e.ags(paramString);
      if (localObject1 != null)
      {
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().XY(paramString)))
        {
          com.tencent.mm.ui.base.h.cg(this, getString(2131759800));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          if ((!bs.isNullOrNil(this.sOM)) && (this.sOM.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localObject1).hTw >= this.jbG * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cg(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.jbG) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25)
          {
            if (((GalleryItem.VideoMediaItem)localObject1).hTw > this.jbG * 1000)
            {
              com.tencent.mm.ui.base.h.cg(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.jbG) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).hTw < this.sPJ * 1000)
            {
              com.tencent.mm.ui.base.h.cg(getContext(), getContext().getResources().getString(2131759821, new Object[] { Integer.valueOf(this.sPJ) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.sRN != null)
        {
          localObject2 = this.sRN.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!((GalleryItem.MediaItem)localObject3).sKh.equalsIgnoreCase(((GalleryItem.MediaItem)localObject1).sKh))) {
              break label754;
            }
            i = 1;
          }
        }
      }
    }
    label600:
    label751:
    label754:
    for (;;)
    {
      break label459;
      if (i == 0) {
        this.sRN.add(localObject1);
      }
      this.sRM.add(paramString);
      this.sRS.setImageResource(cNT());
      b(this.sRM.size(), this.sRO.intValue(), paramString, 0);
      break;
      this.sRS.setImageResource(2131691077);
      while (this.sRM.remove(paramString)) {}
      if (this.sRN != null)
      {
        localObject1 = null;
        localObject3 = this.sRN.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).sKh.equalsIgnoreCase(paramString))) {
            break label751;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break label600;
        if (localObject1 != null)
        {
          ac.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).sKh });
          this.sRN.remove(localObject1);
        }
        b(this.sRM.size(), this.sRO.intValue(), paramString, 1);
        break;
        paramString = this.sRM.iterator();
        while (paramString.hasNext()) {
          if (!s.aKD((String)paramString.next()))
          {
            AppMethodBeat.o(111598);
            return;
          }
        }
        this.opQ = true;
        AppMethodBeat.o(111598);
        return;
      }
    }
  }
  
  private void agC(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.sRM.size() >= 9) && (!this.sRM.contains(paramString)))
    {
      this.sSa.setTextColor(getContext().getResources().getColor(2131101183));
      this.sSa.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.sSa.setEnabled(true);
    this.sSa.setTextColor(getContext().getResources().getColor(2131101182));
    AppMethodBeat.o(111610);
  }
  
  private boolean agD(String paramString)
  {
    AppMethodBeat.i(111613);
    if (com.tencent.mm.vfs.i.aSp(paramString) > 1073741824L)
    {
      this.sSb.setText(getString(2131759794));
      this.sSc.setText(getString(2131759793));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private boolean agE(String paramString)
  {
    AppMethodBeat.i(111618);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (this.sPX == null)
    {
      this.sPX = new HashSet();
      this.sPX.add(".h264");
      this.sPX.add(".h26l");
      this.sPX.add(".264");
      this.sPX.add(".avc");
      this.sPX.add(".mov");
      this.sPX.add(".mp4");
      this.sPX.add(".m4a");
      this.sPX.add(".3gp");
      this.sPX.add(".3g2");
      this.sPX.add(".mj2");
      this.sPX.add(".m4v");
    }
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (!this.sPX.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    AppMethodBeat.o(111618);
    return false;
  }
  
  private void agF(String paramString)
  {
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.cMt().kxr)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.ags(paramString);
      localObject = localBoolean;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 2) {
          localObject = Boolean.TRUE;
        }
      }
      if ((localMediaItem == null) && (s.aKD(paramString))) {
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if ((!paramString.booleanValue()) || (this.sPz)) {
        break label192;
      }
      this.sRP.setVisibility(8);
      this.sPq.setVisibility(8);
      AppMethodBeat.o(111620);
      return;
      localBoolean = Boolean.TRUE;
      break;
      paramString = (String)localObject;
      if (localMediaItem != null)
      {
        paramString = (String)localObject;
        if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
          paramString = Boolean.TRUE;
        }
      }
    }
    label192:
    this.sRP.setVisibility(0);
    this.sPq.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    ac.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.sQR))
    {
      this.sRK.getAdapter().b(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 13) {
        break label356;
      }
      paramInt2 = 1;
      label72:
      paramString = this.sRI.Gd(this.sRO.intValue());
      if ((paramInt1 != 0) && (((!this.sPw) || (this.sSh)) && ((paramInt2 == 0) || (this.sRI == null) || (paramString == null) || (paramString.getType() != 2)))) {
        break label361;
      }
    }
    label356:
    label361:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label366;
      }
      this.sRK.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.sRK.getAdapter()).agG(paramString);
        ((g)this.sRK.getAdapter()).fU(paramInt1 - 1, this.sRO.intValue());
        this.sRK.getAdapter().ck(paramInt1 - 1);
        paramString = this.sRK;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.aeD(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.sRK.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.sRK.getAdapter()).remove(paramInt2);
      this.sRK.getAdapter().cl(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label366:
    this.sRK.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    ac.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.hTw) });
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.hTw <= 1000)
    {
      this.sSb.setText(getString(2131759798));
      this.sSc.setText(getString(2131759797));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.hTw >= 300000)
    {
      this.sSb.setText(getString(2131759796));
      this.sSc.setText(getString(2131759795));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.hTw >= this.sRZ * 1000 + 500)
    {
      this.sSb.setText(getString(2131759781));
      this.sSc.setText(getString(2131759780, new Object[] { Integer.valueOf(this.sRZ) }));
      this.sSf.setVisibility(0);
      AppMethodBeat.o(111614);
      return true;
    }
    AppMethodBeat.o(111614);
    return false;
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111616);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        ac.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.sSb.setText(getString(2131759791));
      this.sSc.setText(getString(2131759792));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private String cNQ()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.cMt().kxr)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    default: 
      if ((this.sRM.size() == 0) || (this.rXO <= 1))
      {
        str = getString(2131755884);
        AppMethodBeat.o(111601);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
    case 22: 
      if ((this.sSh) && (com.tencent.mm.plugin.gallery.a.d.ag(this.sRN)))
      {
        str = getString(2131759788) + "(" + this.sRM.size() + "/" + this.rXO + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.sRM.size() == 0) || (this.rXO <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.sRM.size() + "/" + this.rXO + ")";
      AppMethodBeat.o(111601);
      return str;
    case 11: 
    case 24: 
      str = getString(2131758387);
      AppMethodBeat.o(111601);
      return str;
    case 7: 
    case 15: 
    case 25: 
      if (((!bs.isNullOrNil(this.sOM)) && (this.sOM.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25))
      {
        if ((this.sRM.size() == 0) || (this.rXO <= 1))
        {
          str = getString(2131755830);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(2131755830) + "(" + this.sRM.size() + "/" + this.rXO + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.sRM.size() == 0) || (this.rXO <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.sRM.size() + "/" + this.rXO + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(2131759775, new Object[] { Integer.valueOf(this.sRM.size()), Integer.valueOf(this.rXO) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> cNR()
  {
    AppMethodBeat.i(111602);
    if (this.sQR)
    {
      localArrayList = this.sRM;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.sRM != null)
    {
      localArrayList = new ArrayList(this.sRM.size());
      Iterator localIterator = this.sRL.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.sRM.contains(str)) {
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
  
  private boolean cNS()
  {
    AppMethodBeat.i(111615);
    this.sSb.setText(getString(2131759789));
    this.sSc.setText(getString(2131759790));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int cNT()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 15)
    {
      AppMethodBeat.o(111622);
      return 2131689937;
    }
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25)
    {
      AppMethodBeat.o(111622);
      return 2131691475;
    }
    AppMethodBeat.o(111622);
    return 2131689936;
  }
  
  private boolean d(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111617);
    ac.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.hTu)) && (com.tencent.mm.plugin.o.f.dcU())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (bs.isNullOrNil(paramVideoMediaItem.sKh)) || (agE(paramVideoMediaItem.sKh)) || (i == 0) || ((!bs.isNullOrNil(paramVideoMediaItem.hTv)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.hTv))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.hTu)
        {
          ac.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          cNS();
          AppMethodBeat.o(111617);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.hTu)) {
            break label168;
          }
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(111617);
      return false;
      label168:
      i = 0;
    }
  }
  
  private void e(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.sSi = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.cMx().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.cMx().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      ac.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.sRL != null)
      {
        this.sRL.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.sRL.addAll((Collection)localObject3);
        }
        localObject3 = this.sRI.Gd(this.sRO.intValue());
        if (localObject3 == null)
        {
          ac.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.sRO, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).sKi = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).sKh = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).qCJ = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).sKj = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.cMw().add(localObject3);
        if (this.sSj != null) {
          com.tencent.mm.plugin.gallery.model.e.cMs().b(this.sSj);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.cMs();
        paramIntent = new ImagePreviewUI.10(this, paramIntent, (String)localObject1);
        this.sSj = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.cMs().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).sKk, ((GalleryItem.MediaItem)localObject3).sKl);
        ac.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      }
    }
    AppMethodBeat.o(111600);
  }
  
  private void goBack()
  {
    boolean bool2 = true;
    AppMethodBeat.i(111605);
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.opQ)
    {
      bool1 = true;
      if (!this.sPw) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", cNR());
      localIntent.putExtra("show_photo_edit_tip", this.sSi);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111612);
    if (paramMediaItem == null)
    {
      ac.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject;
    if (paramMediaItem.getType() == 2)
    {
      GalleryItem.VideoMediaItem localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.sSm = 300000;
      this.sSn = getString(2131759795);
      this.sSo = 1000;
      this.sSp = getString(2131759797);
      if (((this.sOM != null) && ((this.sOM.equals("album_business_bubble_media_by_coordinate")) || (this.sOM.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25))
      {
        this.sSm = (this.jbG * 1000 + 500);
        this.sSn = getString(2131759822, new Object[] { Integer.valueOf(this.jbG) });
        if (this.sPJ != 0)
        {
          this.sSo = (this.sPJ * 1000);
          this.sSp = getString(2131759821, new Object[] { Integer.valueOf(this.sPJ) });
        }
      }
      if (!bs.isNullOrNil(localVideoMediaItem.hTu))
      {
        ac.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.sKh, Integer.valueOf(localVideoMediaItem.hTw), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        if ((localVideoMediaItem.hTw >= this.sSm) || ((localVideoMediaItem.hTw > 0) && (localVideoMediaItem.hTw < this.sSo)))
        {
          this.sSe.setVisibility(0);
          localObject = this.sSd;
          if (localVideoMediaItem.hTw >= this.sSm) {}
          for (paramMediaItem = this.sSn;; paramMediaItem = this.sSp)
          {
            ((TextView)localObject).setText(paramMediaItem);
            this.sRT.setEnabled(false);
            this.sRS.setEnabled(false);
            this.sRT.setTextColor(getResources().getColor(2131101183));
            if (this.sRM.size() != 0) {
              break;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(111612);
            return;
          }
        }
        this.sRT.setEnabled(true);
        this.sRS.setEnabled(true);
        this.sRT.setTextColor(getResources().getColor(2131101182));
        this.sSe.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
      }
      paramMediaItem = new t(paramMediaItem.sKh, this.sRO.intValue(), localVideoMediaItem, new t.a()
      {
        public final void a(t paramAnonymoust)
        {
          AppMethodBeat.i(111580);
          if (paramAnonymoust.equals(ImagePreviewUI.y(ImagePreviewUI.this).getTag())) {
            ImagePreviewUI.y(ImagePreviewUI.this).setTag(null);
          }
          if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
          {
            AppMethodBeat.o(111580);
            return;
          }
          if (TextUtils.isEmpty(paramAnonymoust.sLo.hTu))
          {
            paramAnonymoust = ImagePreviewUI.this.getString(2131759790);
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            ImagePreviewUI.A(ImagePreviewUI.this).setText(paramAnonymoust);
            ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
            ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
            ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101183));
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.this.enableOptionMenu(false);
            }
            AppMethodBeat.o(111580);
            return;
          }
          if ((paramAnonymoust.sLo.hTw >= ImagePreviewUI.C(ImagePreviewUI.this)) || ((paramAnonymoust.sLo.hTw > 0) && (paramAnonymoust.sLo.hTw < ImagePreviewUI.D(ImagePreviewUI.this))))
          {
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
            if (paramAnonymoust.sLo.hTw >= ImagePreviewUI.C(ImagePreviewUI.this)) {}
            for (paramAnonymoust = ImagePreviewUI.E(ImagePreviewUI.this);; paramAnonymoust = ImagePreviewUI.F(ImagePreviewUI.this))
            {
              localTextView.setText(paramAnonymoust);
              ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101183));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() != 0) {
                break;
              }
              ImagePreviewUI.this.enableOptionMenu(false);
              AppMethodBeat.o(111580);
              return;
            }
          }
          ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(true);
          ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(true);
          ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101182));
          ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
          AppMethodBeat.o(111580);
        }
      });
      if (paramMediaItem.equals(this.sSg.getTag()))
      {
        ac.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
        AppMethodBeat.o(111612);
        return;
      }
      this.sSg.setTag(paramMediaItem);
      com.tencent.e.h.JZN.aS(paramMediaItem);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.sRT.setEnabled(true);
      this.sRS.setEnabled(true);
      this.sRT.setTextColor(getResources().getColor(2131101182));
      if ((this.opQ) && (this.sRM.contains(paramMediaItem.sKh)) && (com.tencent.mm.vfs.i.aSp(paramMediaItem.sKh) > 26214400L))
      {
        this.sSe.setVisibility(0);
        this.sSd.setText(getString(2131759802));
        AppMethodBeat.o(111612);
        return;
      }
      this.sSe.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.sKh);
      long l = com.tencent.mm.vfs.i.aSp(paramMediaItem.sKh);
      try
      {
        if (((!this.sRM.contains(paramMediaItem.sKh)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.d.ZG())) && (localObject.txk[0] <= com.tencent.mm.plugin.gallery.a.d.ZF()) && (localObject.txk[1] <= com.tencent.mm.plugin.gallery.a.d.ZF())) {
          break label830;
        }
        this.sRT.setTextColor(getResources().getColor(2131101183));
        this.sRT.setEnabled(false);
        this.sRS.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        ac.e("MicroMsg.ImagePreviewUI", bs.m(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label830:
    this.sRT.setTextColor(getResources().getColor(2131101182));
    this.sRT.setEnabled(true);
    this.sRS.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void mB(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.sRI == null)
    {
      ac.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.sRI.Gd(this.sRO.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.sSe.postDelayed(new Runnable()
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
    this.sSe.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void mC(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    ac.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.sRW);
    if (this.sRW)
    {
      localObject = findViewById(2131298881);
      if (localObject != null) {
        break label134;
      }
      if (!this.sRW) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      ac.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(2131300337);
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 15) {
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
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772047));
    }
    while ((paramBoolean) && (this.sRK.getVisibility() == 8) && (this.sRM.size() > 0))
    {
      this.sRK.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2130772047);
      this.sRK.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772048));
    }
    if ((!paramBoolean) && (this.sRK.getVisibility() == 0))
    {
      this.sRK.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2130772048);
      this.sRK.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (b.ca(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    aj.m(aj.a(getWindow(), null), getBodyView());
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
    return 2131494473;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111597);
    setActionbarColor(getResources().getColor(2131100399));
    setNavigationbarColor(getResources().getColor(2131100399));
    this.sSb = ((TextView)findViewById(2131300338));
    this.sSc = ((TextView)findViewById(2131300340));
    this.sSd = ((TextView)findViewById(2131301163));
    this.sSe = findViewById(2131301164);
    this.sSe.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111575);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(com.tencent.mm.compatible.util.i.aU(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(2131165252)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(111575);
      }
    }, 100L);
    this.sSf = ((TextView)findViewById(2131300339));
    this.sSg = ((ProgressBar)findViewById(2131306335));
    this.rXO = getIntent().getIntExtra("max_select_count", 9);
    this.sRZ = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 4)
    {
      bool1 = true;
      this.sPw = bool1;
      localObject1 = getIntent();
      this.sRL = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.sRN = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.sRM = new ArrayList();
      if (this.sRL != null) {
        this.sRM.addAll(this.sRL);
      }
      this.sOJ = com.tencent.mm.plugin.gallery.model.e.cMv();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.sOJ != null) {
        break label422;
      }
    }
    label422:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.sOJ != null))
      {
        this.sQR = true;
        this.sRO = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        ac.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.sRO });
        if (this.sRO.intValue() >= 0) {}
      }
      else
      {
        this.sRO = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.FO(this.sRO.intValue());
      if ((this.sQR) || ((this.sRM != null) && (this.sRM.size() != 0))) {
        break label427;
      }
      ac.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label427:
    this.sRP = ((ImageButton)findViewById(2131303090));
    this.sPq = ((TextView)findViewById(2131303091));
    this.sRQ = ((TextView)findViewById(2131306334));
    this.opQ = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.sPx = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.sPz = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.sPA = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.sRY = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.sSh = com.tencent.mm.plugin.gallery.a.d.cOd();
    ac.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.sSh) });
    Object localObject2;
    label612:
    label633:
    int i;
    if (this.opQ)
    {
      this.sRP.setImageResource(2131691078);
      if (this.sPA) {
        this.sRP.setImageResource(2131691075);
      }
      localObject2 = this.sRP;
      if (this.sPA) {
        break label1672;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.sPq;
      if (this.sPA) {
        break label1677;
      }
      bool1 = true;
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.sRM != null) && (this.sRM.size() == 1))
      {
        localObject2 = (String)this.sRM.get(0);
        if (((String)localObject2).endsWith(".jpg")) {
          ap.f(new Runnable()
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
                  com.tencent.mm.plugin.gallery.a.d.c(str1, str2, bool1, true);
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
      this.sPq.setText(getContext().getString(2131759782));
      this.sRP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          paramAnonymousView = ImagePreviewUI.this;
          boolean bool;
          if (!ImagePreviewUI.b(ImagePreviewUI.this))
          {
            bool = true;
            ImagePreviewUI.b(paramAnonymousView, bool);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label143;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691078);
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            }
          }
          for (;;)
          {
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cNU());
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            AppMethodBeat.o(111583);
            return;
            bool = false;
            break;
            label143:
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691077);
          }
        }
      });
      this.sRQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bs.isNullOrNil(paramAnonymousView))
          {
            ac.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111584);
            return;
          }
          ac.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          Object localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aJx();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aJx();
          paramAnonymousView = RecordConfigProvider.ak(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.wqt = com.tencent.mm.modelcontrol.d.aDL().aDO();
          paramAnonymousView.wqC = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cMt().kxr;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).YX();
          ((UICustomParam.a)localObject).YW();
          ((UICustomParam.a)localObject).cN(true);
          paramAnonymousView.wqu = ((UICustomParam.a)localObject).fKH;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          AppMethodBeat.o(111584);
        }
      });
      this.sSf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bs.isNullOrNil(paramAnonymousView))
          {
            ac.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111585);
            return;
          }
          Object localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aJx();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aJx();
          paramAnonymousView = RecordConfigProvider.ak(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.wqC = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.wqt = com.tencent.mm.modelcontrol.d.aDL().aDO();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cMt().kxr;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).YX();
          ((UICustomParam.a)localObject).YW();
          ((UICustomParam.a)localObject).cN(true);
          paramAnonymousView.wqu = ((UICustomParam.a)localObject).fKH;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          AppMethodBeat.o(111585);
        }
      });
      this.sPq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111586);
          ImagePreviewUI.c(ImagePreviewUI.this).performClick();
          AppMethodBeat.o(111586);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(111587);
          ImagePreviewUI.j(ImagePreviewUI.this);
          AppMethodBeat.o(111587);
          return true;
        }
      });
      this.sOM = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.jbG = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.sPJ = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = s.b.Hoy;
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 15) {
        break label1682;
      }
      localObject1 = s.b.How;
      label856:
      addTextOptionMenu(0, cNQ(), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          AppMethodBeat.i(111590);
          if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
          {
            ImagePreviewUI.this.setResult(1);
            paramAnonymousMenuItem = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if (!bs.isNullOrNil(paramAnonymousMenuItem)) {
              a.a.sIP.ae(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            }
            ImagePreviewUI.this.finish();
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
          Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
          int i;
          if ((localObject != null) && (((ArrayList)localObject).size() == 0))
          {
            localObject = ImagePreviewUI.h(ImagePreviewUI.this).Gd(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).sKh);
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!bs.isNullOrNil((String)localObject)) {
                a.a.sIP.ae((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              i = 0;
            }
          }
          for (;;)
          {
            if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25)
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
            localObject = com.tencent.mm.plugin.gallery.model.e.cMu();
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
              ((com.tencent.mm.plugin.gallery.model.g)localObject).cMM().postDelayed(paramAnonymousMenuItem, i);
              AppMethodBeat.o(111590);
              return true;
            }
            i = 0;
          }
        }
      }, null, (s.b)localObject1);
      this.sRS = ((ImageButton)findViewById(2131303251));
      this.sRS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111591);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bs.isNullOrNil(paramAnonymousView))
          {
            ac.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111591);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cNU());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          a.a.sIP.ae(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          AppMethodBeat.o(111591);
        }
      });
      this.sRT = ((TextView)findViewById(2131303253));
      this.sRT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111560);
          ImagePreviewUI.e(ImagePreviewUI.this).performClick();
          AppMethodBeat.o(111560);
        }
      });
      if (this.rXO == 1)
      {
        this.sRS.setVisibility(8);
        this.sRT.setVisibility(8);
      }
      this.sRU = ((ViewGroup)findViewById(2131298881));
      this.sRV = ((ViewGroup)findViewById(2131300337));
      if (this.sRU != null)
      {
        this.sRU.setVisibility(8);
        this.sRU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111561);
            AppMethodBeat.o(111561);
          }
        });
      }
      if (this.sRV != null)
      {
        this.sRV.setVisibility(8);
        this.sRV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111562);
            AppMethodBeat.o(111562);
          }
        });
      }
      this.sSa = ((TextView)findViewById(2131303244));
      this.sSa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111563);
          ImagePreviewUI.o(ImagePreviewUI.this);
          AppMethodBeat.o(111563);
        }
      });
      this.sRK = ((RecyclerView)findViewById(2131300956));
      this.sRK.getItemAnimator().arm = 66L;
      this.sRK.a(new RecyclerView.h()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
        {
          AppMethodBeat.i(111564);
          int i = (int)ai.getContext().getResources().getDimension(2131165480);
          paramAnonymousRect.left = (i / 2);
          paramAnonymousRect.bottom = i;
          paramAnonymousRect.top = i;
          paramAnonymousRect.right = (i / 2);
          AppMethodBeat.o(111564);
        }
      });
      localObject1 = new SpeedyLinearLayoutManager();
      ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
      this.sRK.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new g(this, this.sRM, i, this.sQR);
      this.sRK.setAdapter((RecyclerView.a)localObject1);
      this.sRK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111565);
          int i = (int)ai.getContext().getResources().getDimension(2131165480);
          int j = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
          ImagePreviewUI.p(ImagePreviewUI.this).getLayoutParams().height = (i * 2 + j);
          RecyclerView localRecyclerView = ImagePreviewUI.p(ImagePreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(ImagePreviewUI.g(ImagePreviewUI.this).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(111565);
        }
      });
      if (this.sRM.size() <= 0) {
        break label1701;
      }
      this.sRK.setVisibility(0);
      label1221:
      this.sRK.setItemAnimator(new v());
      ((g)localObject1).sSH.j(this.sRK);
      ((g)localObject1).sSE = new g.b()
      {
        public final void Gg(int paramAnonymousInt)
        {
          AppMethodBeat.i(111566);
          ac.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).fU(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.sJy = true;
            AppMethodBeat.o(111566);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.sJw = true;
          AppMethodBeat.o(111566);
        }
        
        public final void af(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111568);
          ac.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            d locald = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            ac.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!locald.sQR)
            {
              com.tencent.mm.plugin.gallery.a.d.swap(locald.sQQ, paramAnonymousInt1, paramAnonymousInt2);
              locald.dzl = paramAnonymousInt3;
              locald.sQT = ((View)locald.HBb.get(i));
              locald.HAZ.remove(locald.sQT);
              locald.HBa.clear();
              locald.HBb.clear();
              locald.sQU = true;
              locald.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).fU(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.sJx = true;
            AppMethodBeat.o(111568);
            return;
          }
          com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.sJv = true;
          AppMethodBeat.o(111568);
        }
        
        public final void fT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111567);
          ac.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(111567);
        }
      };
      this.sRJ = ((MMViewPager)findViewById(2131300335));
      this.sRJ.setVerticalFadingEdgeEnabled(false);
      this.sRJ.setHorizontalFadingEdgeEnabled(false);
      this.sRJ.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(111574);
          if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
            ImagePreviewUI.h(ImagePreviewUI.this).sQY.onPageScrollStateChanged(paramAnonymousInt);
          }
          AppMethodBeat.o(111574);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          boolean bool2 = true;
          AppMethodBeat.i(111573);
          com.tencent.mm.plugin.gallery.model.e.FO(paramAnonymousInt);
          String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
          boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
          ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
          Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
          int i;
          if (bool1)
          {
            i = ImagePreviewUI.cNV();
            ((ImageButton)localObject).setImageResource(i);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label316;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691078);
            label105:
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691075);
            }
            localObject = ImagePreviewUI.c(ImagePreviewUI.this);
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              break label331;
            }
            bool1 = true;
            label148:
            ((ImageButton)localObject).setEnabled(bool1);
            localObject = ImagePreviewUI.f(ImagePreviewUI.this);
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              break label336;
            }
          }
          label316:
          label331:
          label336:
          for (bool1 = bool2;; bool1 = false)
          {
            ((TextView)localObject).setEnabled(bool1);
            ImagePreviewUI.this.setMMTitle(paramAnonymousInt + 1 + "/" + ImagePreviewUI.h(ImagePreviewUI.this).getCount());
            ImagePreviewUI.h(ImagePreviewUI.this).sQX.onPageSelected(paramAnonymousInt);
            ac.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
            localObject = com.tencent.mm.plugin.gallery.model.e.ags(str);
            if ((ImagePreviewUI.u(ImagePreviewUI.this).getVisibility() == 0) || (ImagePreviewUI.v(ImagePreviewUI.this).getVisibility() == 0))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, str, (GalleryItem.MediaItem)localObject);
              ImagePreviewUI.a(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
            }
            AppMethodBeat.o(111573);
            return;
            i = 2131691077;
            break;
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691077);
            break label105;
            bool1 = false;
            break label148;
          }
        }
      });
      this.sRJ.setSingleClickOverListener(new MMViewPager.e()
      {
        public final void aOd()
        {
          AppMethodBeat.i(111576);
          ImagePreviewUI.w(ImagePreviewUI.this);
          AppMethodBeat.o(111576);
        }
        
        public final void cNW() {}
      });
      this.sRI = new d(this);
      ((g)this.sRK.getAdapter()).sSB = this.sRI;
      if (this.sQR) {
        break label1713;
      }
      this.sRI.af(this.sRL);
      this.sRI.sQR = false;
      if (this.sRL.size() <= 0) {
        break label1822;
      }
      localObject1 = (String)this.sRL.get(this.sRO.intValue());
    }
    for (;;)
    {
      this.sRJ.setAdapter(this.sRI);
      this.sRJ.setCurrentItem(this.sRO.intValue());
      this.sRI.cUq = this.sRO.intValue();
      i = cNR().indexOf(this.sRI.getItem(this.sRO.intValue()));
      ((g)this.sRK.getAdapter()).fU(i, this.sRO.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.ags((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      i((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.sRO.intValue() + 1 + "/" + this.sRI.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25)
      {
        ((ViewGroup)this.sRK.getParent()).removeView(this.sRK);
        this.sRK.setVisibility(8);
        findViewById(2131303094).setVisibility(4);
        findViewById(2131300340).setVisibility(4);
        findViewById(2131303244).setVisibility(4);
        findViewById(2131300338).setVisibility(4);
        findViewById(2131306334).setVisibility(4);
        findViewById(2131300339).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.sRP.setImageResource(2131691077);
      break;
      label1672:
      bool1 = false;
      break label612;
      label1677:
      bool1 = false;
      break label633;
      label1682:
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 25) {
        break label856;
      }
      localObject1 = s.b.Hox;
      break label856;
      label1701:
      this.sRK.setVisibility(8);
      break label1221;
      label1713:
      localObject1 = this.sRI;
      localObject2 = this.sOJ;
      ((d)localObject1).sOJ.clear();
      ((d)localObject1).sOJ.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.sRI.sQR = true;
      if (this.sRO.intValue() >= this.sOJ.size()) {
        this.sRO = Integer.valueOf(0);
      }
      if (this.sOJ.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.sOJ.get(this.sRO.intValue())).sKh;
      } else {
        label1822:
        localObject1 = "";
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(111599);
    ac.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    Object localObject;
    while (paramInt1 == 4372) {
      if ((paramIntent == null) || (this.sRK == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.sRM.size() > 0)
        {
          agB((String)this.sRM.get(0));
        }
        else
        {
          ac.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.sRM.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).dvk().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((g)this.sRK.getAdapter()).sSD;
        ArrayList localArrayList3 = this.sRM;
        this.sSl = (this.sSl + localCaptureVideoNormalModel.dvk().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
          if (!str.equalsIgnoreCase(bs.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bs.nullAsNil(this.sSk))) {}
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
          if (!str.equalsIgnoreCase(bs.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bs.nullAsNil(this.sSk))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        com.tencent.mm.vfs.i.deleteFile(this.sSk);
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
        if (this.sPw)
        {
          paramIntent = RecordConfigProvider.iw("", "");
          paramIntent.wqC = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).qwN = 1;
          paramIntent.wqK = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).YX();
          ((UICustomParam.a)localObject).YW();
          ((UICustomParam.a)localObject).cN(true);
          paramIntent.wqu = ((UICustomParam.a)localObject).fKH;
          paramIntent.D(3, VLogPreviewPluginLayout.class.getName());
          paramIntent.D(4, VLogPreviewPluginLayout.class.getName());
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, 2130772137, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.cMt().kxr)
        {
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111599);
        }
      }
      else
      {
        Toast.makeText(this, 2131760707, 1).show();
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
    long l = bs.Gn();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new ao().post(new ImagePreviewUI.1(this, l));
    ac.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bs.aO(l)) });
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    ac.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      ac.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.cMw().clear();
    }
    if (this.sRI != null) {
      this.sRI.release();
    }
    com.tencent.mm.plugin.gallery.model.e.ab(null);
    y.cGI.Ix().Iw();
    if (this.sSj != null) {
      com.tencent.mm.plugin.gallery.model.e.cMs().b(this.sSj);
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
    if (this.sRR != null) {
      this.sRR.stopTimer();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */