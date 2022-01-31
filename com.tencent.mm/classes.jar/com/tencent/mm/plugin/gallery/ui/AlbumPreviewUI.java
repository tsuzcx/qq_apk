package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI
  extends MMActivity
  implements i.c
{
  static long start = 0L;
  private String czp;
  private ProgressDialog eeN;
  private int eez;
  private int gNT;
  private ServiceConnection kDI;
  private boolean kFQ;
  private double latitude;
  private double longitude;
  private com.tencent.mm.plugin.gallery.stub.a ndL;
  private String ndQ;
  private boolean neA;
  private boolean neB;
  private boolean neC;
  private boolean neD;
  private boolean neE;
  private int neF;
  private int neG;
  boolean neH;
  private int neI;
  private int neJ;
  private long neK;
  private long neL;
  private int neM;
  private String neN;
  private i.b neO;
  private boolean neP;
  private long neQ;
  private a.a neR;
  private boolean neS;
  private HashMap<String, Integer> neT;
  HashSet<String> neU;
  private GridView nei;
  private TextView nej;
  private boolean nek;
  private boolean nel;
  private TextView nem;
  private a nen;
  private TextView neo;
  private TextView nep;
  private TextView neq;
  private ImageFolderMgrView ner;
  private TextView nes;
  private ImageButton neu;
  private String nev;
  private String jdField_new;
  private int nex;
  private String ney;
  private boolean nez;
  private String toUser;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(21417);
    this.nez = false;
    this.neA = false;
    this.neB = false;
    this.neC = false;
    this.kFQ = false;
    this.neD = false;
    this.neE = false;
    this.neH = false;
    this.neI = 0;
    this.neJ = 0;
    this.ndL = null;
    this.neK = 0L;
    this.neM = -1;
    this.neP = true;
    this.kDI = new AlbumPreviewUI.1(this);
    this.neQ = -1L;
    this.neR = new a.a()
    {
      private View.OnClickListener bTw;
      
      public final View getView()
      {
        AppMethodBeat.i(21403);
        View localView = View.inflate(AlbumPreviewUI.this.getContext(), 2130969017, null);
        localView.setOnClickListener(this.bTw);
        TextView localTextView = (TextView)localView.findViewById(2131822416);
        if ((com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 2) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 13)) {
          localTextView.setText(2131300322);
        }
        for (;;)
        {
          localView.setLayerType(1, null);
          AppMethodBeat.o(21403);
          return localView;
          if (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 1) {
            localTextView.setText(2131300321);
          }
        }
      }
    };
    this.neS = false;
    this.neT = new HashMap();
    AppMethodBeat.o(21417);
  }
  
  private static int[] D(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(21424);
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem != null) {
        if ((!bo.isNullOrNil(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
          arrayOfInt[2] += 1;
        } else if (localMediaItem.getType() == 2) {
          arrayOfInt[3] += 1;
        } else if (localMediaItem.getType() == 1) {
          arrayOfInt[1] += 1;
        }
      }
    }
    AppMethodBeat.o(21424);
    return arrayOfInt;
  }
  
  private void a(GalleryItem.AlbumItem paramAlbumItem)
  {
    AppMethodBeat.i(21425);
    if (paramAlbumItem == null)
    {
      AppMethodBeat.o(21425);
      return;
    }
    if (bo.bf(this.jdField_new, "").equals(paramAlbumItem.ndl))
    {
      ab.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(21425);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.bDV().addAll(this.nen.ndN);
    ab.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.ndl, paramAlbumItem.Xi() });
    this.nev = paramAlbumItem.Xi();
    this.jdField_new = paramAlbumItem.ndl;
    if (paramAlbumItem.ndm != null) {
      this.nex = paramAlbumItem.ndm.getType();
    }
    if (bo.isNullOrNil(this.nev))
    {
      ab.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.nev = this.jdField_new;
    }
    Object localObject2;
    if (!bo.isNullOrNil(this.jdField_new))
    {
      localObject1 = this.nen;
      localObject2 = this.neR;
      if (localObject2 == null)
      {
        ab.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        this.nem.setText(this.jdField_new);
      }
    }
    for (;;)
    {
      this.nen.ndM.clear();
      wQ(this.nen.ndN.size());
      this.nen.notifyDataSetChanged();
      if (this.eeN != null) {
        this.eeN.dismiss();
      }
      getString(2131297087);
      this.eeN = h.b(this, getString(2131297112), true, new AlbumPreviewUI.12(this));
      start = System.currentTimeMillis();
      localObject2 = this.jdField_new;
      if (paramAlbumItem.ndm != null) {
        break label358;
      }
      AppMethodBeat.o(21425);
      return;
      ((a)localObject1).ndR.remove(localObject2);
      break;
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.nen.a(this.neR);
      }
      updateTitle();
      this.nex = com.tencent.mm.plugin.gallery.model.e.bDQ().ndz;
    }
    label358:
    int i = paramAlbumItem.ndm.getType();
    int j = com.tencent.mm.plugin.gallery.model.e.bDQ().ndz;
    ab.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Object localObject1 = localObject2;
    if (j != 2)
    {
      localObject1 = localObject2;
      if (paramAlbumItem.ndm.getType() == 2) {
        localObject1 = "";
      }
    }
    if (bo.isNullOrNil(paramAlbumItem.ndl)) {
      i = 3;
    }
    this.neQ = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.bDQ().i((String)localObject1, i, this.neQ);
    AppMethodBeat.o(21425);
  }
  
  private boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(21436);
    if (paramMediaItem == null)
    {
      ab.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(21436);
      return false;
    }
    if (this.ndL == null)
    {
      ab.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
      AppMethodBeat.o(21436);
      return false;
    }
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 3)
    {
      if (!new File(paramMediaItem.fQn).exists())
      {
        h.bN(this, getString(2131300310));
        AppMethodBeat.o(21436);
        return false;
      }
      try
      {
        if (this.ndL.PD(paramMediaItem.fQn) > 300)
        {
          h.bN(this, getString(2131300312));
          AppMethodBeat.o(21436);
          return false;
        }
      }
      catch (RemoteException paramMediaItem)
      {
        ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMediaItem, "", new Object[0]);
        AppMethodBeat.o(21436);
        return true;
      }
    }
    AppMethodBeat.o(21436);
    return true;
  }
  
  private void bEq()
  {
    AppMethodBeat.i(21428);
    if (!n.c(getContext(), com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131303074), 1).show();
      AppMethodBeat.o(21428);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.bDR().wL(0);
    System.gc();
    AppMethodBeat.o(21428);
  }
  
  private void bEr()
  {
    AppMethodBeat.i(21434);
    if (!this.neS)
    {
      AppMethodBeat.o(21434);
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
    ab.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.jdField_new + ", " + this.nev);
    localSharedPreferences.edit().putString(com.tencent.mm.plugin.gallery.model.e.bDQ().ndz, this.jdField_new + "|" + this.nev + "|" + this.nex).commit();
    AppMethodBeat.o(21434);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(21423);
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 3)
    {
      setMMTitle(2131300271);
      this.nem.setText(2131300271);
      AppMethodBeat.o(21423);
      return;
    }
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 1)
    {
      setMMTitle(2131300317);
      this.nem.setText(2131300270);
      AppMethodBeat.o(21423);
      return;
    }
    setMMTitle(2131300272);
    this.nem.setText(2131300272);
    AppMethodBeat.o(21423);
  }
  
  private void wQ(int paramInt)
  {
    AppMethodBeat.i(21431);
    if (paramInt == 0)
    {
      this.nej.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label70;
      }
      this.nej.setText(2131300290);
    }
    for (;;)
    {
      updateOptionMenuText(0, wR(paramInt));
      AppMethodBeat.o(21431);
      return;
      this.nej.setEnabled(true);
      enableOptionMenu(true);
      break;
      label70:
      this.nej.setText(getString(2131300290) + "(" + paramInt + ")");
    }
  }
  
  private String wR(int paramInt)
  {
    AppMethodBeat.i(21432);
    switch (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      if ((paramInt == 0) || (this.neF <= 1))
      {
        str = getString(2131297067);
        AppMethodBeat.o(21432);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
      if ((paramInt == 0) || (this.neF <= 1))
      {
        str = getString(2131300291);
        AppMethodBeat.o(21432);
        return str;
      }
      str = getString(2131300291) + "(" + paramInt + "/" + this.neF + ")";
      AppMethodBeat.o(21432);
      return str;
    case 7: 
    case 15: 
      if ((!bo.isNullOrNil(this.ndQ)) && (this.ndQ.equals("album_business_bubble_media_by_coordinate")))
      {
        if ((paramInt == 0) || (this.neF <= 1))
        {
          str = getString(2131297013);
          AppMethodBeat.o(21432);
          return str;
        }
        str = getString(2131297013) + "(" + paramInt + "/" + this.neF + ")";
        AppMethodBeat.o(21432);
        return str;
      }
      if ((paramInt == 0) || (this.neF <= 1))
      {
        str = getString(2131300291);
        AppMethodBeat.o(21432);
        return str;
      }
      str = getString(2131300291) + "(" + paramInt + "/" + this.neF + ")";
      AppMethodBeat.o(21432);
      return str;
    case 14: 
      if ((paramInt == 0) || (this.neF <= 1))
      {
        str = getString(2131300291);
        AppMethodBeat.o(21432);
        return str;
      }
      str = getString(2131300291) + "(" + paramInt + "/" + this.neF + ")";
      AppMethodBeat.o(21432);
      return str;
    }
    String str = getString(2131300283, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.neF) });
    AppMethodBeat.o(21432);
    return str;
  }
  
  protected void PE(String paramString) {}
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    AppMethodBeat.i(21426);
    switch (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21426);
      return;
      if ((bo.isNullOrNil(this.czp)) || ("medianote".equals(this.toUser))) {
        continue;
      }
      if (bo.yB() - this.neK < 1000L)
      {
        ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
        AppMethodBeat.o(21426);
        return;
      }
      ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
      Object localObject = (GalleryItem.MediaItem)this.nen.ndM.get(paramInt);
      if (((GalleryItem.MediaItem)localObject).getType() == 2) {
        continue;
      }
      try
      {
        com.tencent.mm.plugin.gallery.stub.a locala = this.ndL;
        localObject = ((GalleryItem.MediaItem)localObject).fQn;
        String str = this.toUser;
        if (this.nez) {}
        for (;;)
        {
          locala.a((String)localObject, str, bool1, 0, paramBoolean);
          AppMethodBeat.o(21426);
          return;
          boolean bool2 = this.kFQ;
          if (bool2) {
            bool1 = false;
          }
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public final void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(21433);
    if (paramLong != this.neQ)
    {
      ab.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.neQ) });
      ab.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(21433);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList != null) {
      localLinkedList.addAll(paramLinkedList);
    }
    if (this.nen == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), bo.dtY().toString() });
      if (this.nen != null)
      {
        paramLinkedList = new AlbumPreviewUI.a((byte)0);
        paramLinkedList.nfd = new WeakReference(this.nen);
        paramLinkedList.nfe = new WeakReference(this.eeN);
        paramLinkedList.nff = new WeakReference(this.nep);
        paramLinkedList.nfg = new WeakReference(this.nei);
        paramLinkedList.nfh = localLinkedList;
        paramLinkedList.nfi = new WeakReference(this.neN);
        com.tencent.mm.plugin.gallery.model.e.bDR().d(paramLinkedList);
      }
      AppMethodBeat.o(21433);
      return;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970614;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21427);
    Object localObject1 = getIntent().getExtras();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ab.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    ab.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
    this.ndQ = getIntent().getStringExtra("album_business_tag");
    this.gNT = getIntent().getIntExtra("album_video_max_duration", 10);
    this.czp = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.neF = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 4)
    {
      bool = true;
      this.nez = bool;
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 5) {
        break label1122;
      }
      bool = true;
      label195:
      this.neB = bool;
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 9) {
        break label1127;
      }
      bool = true;
      label213:
      this.neC = bool;
      this.nev = getIntent().getStringExtra("folder_path");
      this.jdField_new = getIntent().getStringExtra("folder_name");
      if (bo.isNullOrNil(this.nev))
      {
        ab.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
        this.nev = this.jdField_new;
      }
      this.kFQ = getIntent().getBooleanExtra("key_send_raw_image", false);
      this.neD = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.nes = ((TextView)findViewById(2131822824));
      this.neu = ((ImageButton)findViewById(2131822823));
      this.nes.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21408);
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          AppMethodBeat.o(21408);
        }
      });
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 3) {
        break label1132;
      }
      this.neu.setVisibility(0);
      this.nes.setVisibility(0);
      label371:
      if (!this.kFQ) {
        break label1153;
      }
      this.neu.setImageResource(2131231906);
      label388:
      this.neu.setOnClickListener(new AlbumPreviewUI.14(this));
      this.neo = ((TextView)findViewById(2131824062));
      this.nep = ((TextView)findViewById(2131827452));
      this.neq = ((TextView)findViewById(2131827453));
      this.nej = ((TextView)findViewById(2131827458));
      if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 0) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 5) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 10) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 11)) {
        break label1166;
      }
      findViewById(2131827457).setVisibility(8);
      this.nej.setVisibility(8);
    }
    for (;;)
    {
      this.ner = ((ImageFolderMgrView)findViewById(2131827459));
      localObject1 = this.ner;
      com.tencent.mm.plugin.gallery.model.e.bDQ().b((i.a)localObject1);
      com.tencent.mm.plugin.gallery.model.e.bDQ().a((i.a)localObject1);
      com.tencent.mm.plugin.gallery.model.e.bDQ().bEl();
      this.ner.setListener(new AlbumPreviewUI.17(this));
      this.ney = getIntent().getStringExtra("send_btn_string");
      findViewById(2131827455).setOnClickListener(new AlbumPreviewUI.18(this));
      this.nem = ((TextView)findViewById(2131827456));
      if (this.neB) {
        showOptionMenu(false);
      }
      enableOptionMenu(false);
      this.nei = ((GridView)findViewById(2131827451));
      this.nei.setOnItemClickListener(new AlbumPreviewUI.2(this));
      this.nen = new a(this, new AlbumPreviewUI.3(this));
      if (!bo.isNullOrNil(this.ndQ))
      {
        ab.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.ndQ });
        this.nen.ndQ = this.ndQ;
        this.nen.gNT = this.gNT;
        if (this.ndQ.equals("album_business_bubble_media_by_coordinate"))
        {
          com.tencent.mm.plugin.gallery.model.e.bDQ().ndy.bDM();
          this.neN = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0D);
          if ((d > 0.0D) && (com.tencent.mm.modelgeo.a.p(this.longitude)) && (com.tencent.mm.modelgeo.a.q(this.latitude)))
          {
            this.neO = new AlbumPreviewUI.4(this, d);
            localObject1 = com.tencent.mm.plugin.gallery.model.e.bDQ();
            localObject2 = this.neO;
            if (localObject2 != null) {
              ((l)localObject1).ndx.add(localObject2);
            }
            this.nen.ndS = false;
          }
        }
      }
      if ((this.nez) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 14)) {
        this.nen.ndS = true;
      }
      if (this.neD) {
        this.nen.ndS = true;
      }
      this.nei.setNumColumns(4);
      this.nei.setOnScrollListener(new AlbumPreviewUI.5(this));
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.nen.a(this.neR);
      }
      this.nen.ndP = com.tencent.mm.plugin.gallery.model.e.bDQ().ndz;
      this.nen.ndK = this.neF;
      ab.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
      this.nei.setAdapter(this.nen);
      updateTitle();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21398);
          ab.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.setResult(-2);
          if ((AlbumPreviewUI.y(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.y(AlbumPreviewUI.this).Zb))
          {
            AlbumPreviewUI.y(AlbumPreviewUI.this).bEv();
            AppMethodBeat.o(21398);
            return true;
          }
          AlbumPreviewUI.this.finish();
          AppMethodBeat.o(21398);
          return true;
        }
      });
      localObject1 = (ViewGroup)findViewById(2131821003);
      if ((localObject1 instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject1).setListener(new AlbumPreviewUI.7(this));
      }
      AppMethodBeat.o(21427);
      return;
      bool = false;
      break;
      label1122:
      bool = false;
      break label195;
      label1127:
      bool = false;
      break label213;
      label1132:
      this.neu.setVisibility(8);
      this.nes.setVisibility(8);
      break label371;
      label1153:
      this.neu.setImageResource(2131231905);
      break label388;
      label1166:
      this.nej.setVisibility(0);
      this.nej.setOnClickListener(new AlbumPreviewUI.15(this));
      if (((com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 1) || (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 2) || (com.tencent.mm.plugin.gallery.model.e.bDQ().ndz == 3)) && (this.neF > 0))
      {
        localObject1 = new AlbumPreviewUI.16(this);
        if (!bo.isNullOrNil(this.ney)) {
          addTextOptionMenu(0, this.ney, (MenuItem.OnMenuItemClickListener)localObject1);
        } else if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) {
          addTextOptionMenu(0, wR(0), (MenuItem.OnMenuItemClickListener)localObject1, null, q.b.zbI);
        } else {
          addTextOptionMenu(0, wR(0), (MenuItem.OnMenuItemClickListener)localObject1, null, q.b.zby);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21430);
    ab.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(21430);
        return;
      }
      localObject1 = n.h(getContext().getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.esr);
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(21430);
        return;
      }
      ab.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 0) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 5) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 11))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        ab.i("MicroMsg.AlbumPreviewUI", "take photo finish");
        setResult(-1, (Intent)localObject2);
        finish();
        localObject1 = paramIntent;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("show_photo_edit_tip", false)))
      {
        paramIntent = getSharedPreferences("photo_edit_pref", 0);
        if (!paramIntent.getBoolean("has_show_tip", false))
        {
          this.neq.setVisibility(0);
          this.neq.setText(getString(2131302094));
          localObject1 = AnimationUtils.loadAnimation(getContext(), 2131034181);
          this.neq.startAnimation((Animation)localObject1);
          ((Animation)localObject1).setAnimationListener(new AlbumPreviewUI.9(this));
          paramIntent.edit().putBoolean("has_show_tip", true).commit();
        }
      }
      AppMethodBeat.o(21430);
      return;
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      localObject1 = new Intent(this, ImagePreviewUI.class);
      ((Intent)localObject1).putExtra("isTakePhoto", true);
      ((Intent)localObject1).putExtra("max_select_count", 1);
      ((Intent)localObject1).putExtra("send_raw_img", this.kFQ);
      ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.czp);
      ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
      startActivityForResult((Intent)localObject1, 4370);
      localObject1 = paramIntent;
      continue;
      if (4370 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(21430);
          return;
        }
        if (paramIntent.getBooleanExtra("GalleryUI_IsSendImgBackground", false))
        {
          ab.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(21430);
          return;
        }
        localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
        {
          ab.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
          AppMethodBeat.o(21430);
          return;
        }
        ab.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
        setResult(-1, paramIntent);
        finish();
        localObject1 = paramIntent;
      }
      else if (4371 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(21430);
          return;
        }
        if (paramIntent != null) {
          paramIntent.putExtra("from_record", true);
        }
        ab.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
        setResult(-1, paramIntent);
        finish();
        localObject1 = paramIntent;
      }
      else if (4372 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(21430);
          return;
        }
        localObject1 = paramIntent;
        if (paramIntent == null) {
          localObject1 = new Intent();
        }
        ab.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
        paramIntent = new ArrayList();
        localObject2 = getIntent().getStringExtra("video_full_path");
        if (!bo.isNullOrNil((String)localObject2))
        {
          paramIntent.add(localObject2);
          ((Intent)localObject1).putExtra("key_select_video_list", paramIntent);
          ((Intent)localObject1).putExtra("key_selected_video_is_from_sys_camera", true);
        }
        setResult(-1, (Intent)localObject1);
        finish();
      }
      else if (4373 == paramInt1)
      {
        if (paramIntent != null)
        {
          paramIntent.putExtra("GalleryUI_IsSendImgBackground", true);
          ab.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
        }
        ab.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
        setResult(-1, paramIntent);
        this.neH = true;
        finish();
        localObject1 = paramIntent;
      }
      else
      {
        String str;
        if (4378 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            AppMethodBeat.o(21430);
            return;
          }
          localObject1 = paramIntent;
          if (paramIntent == null) {
            localObject1 = new Intent();
          }
          ab.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (CaptureDataManager.CaptureVideoNormalModel)((Intent)localObject1).getParcelableExtra("KSEGMENTMEDIAINFO");
          if (paramIntent == null)
          {
            ab.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(21430);
            return;
          }
          localObject2 = new ArrayList();
          str = paramIntent.videoPath;
          if (!bo.isNullOrNil(str))
          {
            ((ArrayList)localObject2).add(str);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.qbk.booleanValue()) && (!bo.isNullOrNil(paramIntent.thumbPath)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.thumbPath);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4375 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            AppMethodBeat.o(21430);
            return;
          }
          localObject1 = paramIntent;
          if (paramIntent == null) {
            localObject1 = new Intent();
          }
          ab.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
          if (paramIntent == null)
          {
            ab.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(21430);
            return;
          }
          localObject2 = new ArrayList();
          str = paramIntent.oFI;
          if (!bo.isNullOrNil(str))
          {
            ((ArrayList)localObject2).add(str);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.oFG) && (!bo.isNullOrNil(paramIntent.oFO)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.oFO);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4376 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            ab.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
            finish();
            localObject1 = paramIntent;
          }
          else
          {
            localObject1 = paramIntent;
            if (paramIntent != null)
            {
              localObject1 = (GalleryItem.AlbumItem)paramIntent.getParcelableExtra("select_folder_name");
              a((GalleryItem.AlbumItem)localObject1);
              setMMTitle(bo.bf(((GalleryItem.AlbumItem)localObject1).ndl, getString(2131300271)));
              localObject1 = paramIntent;
            }
          }
        }
        else if (4377 == paramInt1)
        {
          localObject1 = paramIntent;
          if (paramInt2 == -1)
          {
            setResult(-1, paramIntent);
            bEr();
            finish();
            localObject1 = paramIntent;
          }
        }
        else if (paramInt1 == 4379)
        {
          localObject1 = paramIntent;
          if (paramInt2 == -1)
          {
            localObject1 = paramIntent;
            if (paramIntent != null)
            {
              localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).qbl.q("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.nel = true;
              setResult(-1, paramIntent);
              bEr();
              finish();
              localObject1 = paramIntent;
            }
          }
        }
        else
        {
          switch (paramInt2)
          {
          default: 
            localObject1 = paramIntent;
            break;
          case -2: 
            ab.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
            finish();
            localObject1 = paramIntent;
            break;
          case -1: 
            localObject1 = paramIntent;
            if (paramIntent == null)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
              ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.nen.bEn());
            }
            ab.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
            this.nel = true;
            setResult(-1, (Intent)localObject1);
            bEr();
            finish();
            break;
          case 0: 
            localObject1 = paramIntent;
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getStringArrayListExtra("preview_image_list");
              localObject2 = new StringBuilder("paths is null ? ");
              if (localObject1 == null)
              {
                bool = true;
                label1593:
                localObject2 = ((StringBuilder)localObject2).append(bool).append("   adapter is null ? ");
                if (this.nen != null) {
                  break label1719;
                }
                bool = true;
                label1618:
                ab.i("MicroMsg.AlbumPreviewUI", bool);
                if ((localObject1 != null) && (this.nen != null))
                {
                  this.nen.C((ArrayList)localObject1);
                  this.nen.notifyDataSetChanged();
                  wQ(((ArrayList)localObject1).size());
                }
                if (paramIntent.getBooleanExtra("CropImage_Compress_Img", true)) {
                  break label1725;
                }
              }
              label1719:
              label1725:
              for (boolean bool = true;; bool = false)
              {
                this.kFQ = bool;
                if (!this.kFQ) {
                  break label1731;
                }
                this.neu.setImageResource(2131231906);
                localObject1 = paramIntent;
                break;
                bool = false;
                break label1593;
                bool = false;
                break label1618;
              }
              label1731:
              this.neu.setImageResource(2131231905);
              localObject1 = paramIntent;
            }
            break;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21418);
    super.onCreate(paramBundle);
    this.neL = System.currentTimeMillis();
    ab.i("MicroMsg.AlbumPreviewUI", "onCreate");
    if (paramBundle != null)
    {
      ab.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.neG = paramBundle.getInt("constants_key");
      com.tencent.mm.plugin.gallery.model.e.bDQ().hQK = this.neG;
    }
    setNavigationbarColor(getContext().getResources().getColor(2131689915));
    getString(2131297087);
    this.eeN = h.b(this, getString(2131297112), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    start = System.currentTimeMillis();
    int i = getIntent().getIntExtra("query_source_type", 3);
    int j = getIntent().getIntExtra("query_media_type", 1);
    ab.i("MicroMsg.AlbumPreviewUI", "query souce: " + i + ", queryType: " + j);
    com.tencent.mm.plugin.gallery.model.e.bDQ().wM(j);
    com.tencent.mm.plugin.gallery.model.e.bDQ().hQK = i;
    this.neP = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVQ, true);
    initView();
    ab.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
    com.tencent.mm.plugin.gallery.model.e.bDQ().ndw.add(this);
    this.neQ = System.currentTimeMillis();
    paramBundle = com.tencent.mm.plugin.gallery.model.e.bDQ();
    String str = this.jdField_new;
    long l = this.neQ;
    paramBundle.i(str, paramBundle.ndz, l);
    bindService(new Intent(getContext(), GalleryStubService.class), this.kDI, 1);
    o.La(1);
    AppMethodBeat.o(21418);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: sipush 21421
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 1337	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   10: ldc 244
    //   12: ldc_w 1338
    //   15: invokestatic 587	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 705	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ner	Lcom/tencent/mm/plugin/gallery/ui/ImageFolderMgrView;
    //   22: ifnull +23 -> 45
    //   25: aload_0
    //   26: getfield 705	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ner	Lcom/tencent/mm/plugin/gallery/ui/ImageFolderMgrView;
    //   29: astore 4
    //   31: invokestatic 455	com/tencent/mm/plugin/gallery/model/e:bDQ	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   34: ifnull +11 -> 45
    //   37: invokestatic 455	com/tencent/mm/plugin/gallery/model/e:bDQ	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   40: aload 4
    //   42: invokevirtual 871	com/tencent/mm/plugin/gallery/model/l:b	(Lcom/tencent/mm/plugin/gallery/model/i$a;)V
    //   45: invokestatic 566	com/tencent/mm/plugin/gallery/model/e:bDR	()Lcom/tencent/mm/plugin/gallery/model/g;
    //   48: invokevirtual 1341	com/tencent/mm/plugin/gallery/model/g:bEg	()V
    //   51: invokestatic 566	com/tencent/mm/plugin/gallery/model/e:bDR	()Lcom/tencent/mm/plugin/gallery/model/g;
    //   54: astore 4
    //   56: aload 4
    //   58: invokevirtual 1345	com/tencent/mm/plugin/gallery/model/g:bEf	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   61: aconst_null
    //   62: invokevirtual 1350	com/tencent/mm/sdk/platformtools/ak:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   65: aload 4
    //   67: aconst_null
    //   68: putfield 1354	com/tencent/mm/plugin/gallery/model/g:faV	Lcom/tencent/mm/sdk/platformtools/ak;
    //   71: invokestatic 455	com/tencent/mm/plugin/gallery/model/e:bDQ	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   74: ifnull +41 -> 115
    //   77: invokestatic 455	com/tencent/mm/plugin/gallery/model/e:bDQ	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   80: getfield 1321	com/tencent/mm/plugin/gallery/model/l:ndw	Ljava/util/HashSet;
    //   83: aload_0
    //   84: invokevirtual 1355	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: invokestatic 455	com/tencent/mm/plugin/gallery/model/e:bDQ	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 957	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neO	Lcom/tencent/mm/plugin/gallery/model/i$b;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnull +14 -> 115
    //   104: aload 4
    //   106: getfield 960	com/tencent/mm/plugin/gallery/model/l:ndx	Ljava/util/HashSet;
    //   109: aload 5
    //   111: invokevirtual 1355	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 124	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neI	I
    //   119: ifgt +10 -> 129
    //   122: aload_0
    //   123: getfield 126	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neJ	I
    //   126: ifle +265 -> 391
    //   129: ldc 244
    //   131: ldc_w 1357
    //   134: iconst_2
    //   135: anewarray 262	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield 124	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neI	I
    //   144: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_0
    //   151: getfield 126	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neJ	I
    //   154: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokestatic 300	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_0
    //   162: getfield 128	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ndL	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   165: sipush 11187
    //   168: new 531	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 594	java/lang/StringBuilder:<init>	()V
    //   175: aload_0
    //   176: getfield 124	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neI	I
    //   179: invokevirtual 597	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 1359
    //   185: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_0
    //   189: getfield 126	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neJ	I
    //   192: invokevirtual 597	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 546	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokeinterface 1362 3 0
    //   203: aload_0
    //   204: getfield 130	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neK	J
    //   207: lconst_0
    //   208: lcmp
    //   209: ifgt +10 -> 219
    //   212: aload_0
    //   213: getfield 1238	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:nel	Z
    //   216: ifeq +32 -> 248
    //   219: aload_0
    //   220: getfield 128	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ndL	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   223: aload_0
    //   224: getfield 887	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ney	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 330	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:nen	Lcom/tencent/mm/plugin/gallery/ui/a;
    //   231: getfield 359	com/tencent/mm/plugin/gallery/ui/a:ndN	Ljava/util/ArrayList;
    //   234: invokestatic 1364	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:D	(Ljava/util/ArrayList;)[I
    //   237: aload_0
    //   238: getfield 116	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kFQ	Z
    //   241: aload_0
    //   242: getfield 626	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:nek	Z
    //   245: invokestatic 1367	com/tencent/mm/plugin/gallery/model/e:a	(Lcom/tencent/mm/plugin/gallery/stub/a;Ljava/lang/String;[IZZ)V
    //   248: aload_0
    //   249: getfield 128	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:ndL	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   252: astore 4
    //   254: aload_0
    //   255: getfield 330	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:nen	Lcom/tencent/mm/plugin/gallery/ui/a;
    //   258: getfield 359	com/tencent/mm/plugin/gallery/ui/a:ndN	Ljava/util/ArrayList;
    //   261: invokevirtual 178	java/util/ArrayList:size	()I
    //   264: istore_1
    //   265: aload_0
    //   266: getfield 116	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kFQ	Z
    //   269: istore_3
    //   270: aload_0
    //   271: getfield 130	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:neK	J
    //   274: lconst_0
    //   275: lcmp
    //   276: ifgt +169 -> 445
    //   279: aload_0
    //   280: getfield 1238	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:nel	Z
    //   283: ifeq +119 -> 402
    //   286: goto +159 -> 445
    //   289: aload 4
    //   291: iload_1
    //   292: iload_3
    //   293: iload_2
    //   294: invokestatic 1370	com/tencent/mm/plugin/gallery/model/e:a	(Lcom/tencent/mm/plugin/gallery/stub/a;IZZ)V
    //   297: getstatic 1376	com/tencent/mm/api/s:bWe	Lcom/tencent/mm/api/s$b;
    //   300: invokeinterface 1382 1 0
    //   305: invokevirtual 1385	com/tencent/mm/api/s:Aa	()V
    //   308: invokestatic 282	com/tencent/mm/plugin/gallery/model/e:bDT	()Ljava/util/HashSet;
    //   311: invokevirtual 1386	java/util/HashSet:clear	()V
    //   314: invokestatic 1389	com/tencent/mm/plugin/gallery/model/e:bDU	()Ljava/util/ArrayList;
    //   317: invokevirtual 399	java/util/ArrayList:clear	()V
    //   320: invokestatic 353	com/tencent/mm/plugin/gallery/model/e:bDV	()Ljava/util/LinkedHashSet;
    //   323: invokevirtual 1390	java/util/LinkedHashSet:clear	()V
    //   326: aload_0
    //   327: aload_0
    //   328: getfield 141	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kDI	Landroid/content/ServiceConnection;
    //   331: invokevirtual 1394	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:unbindService	(Landroid/content/ServiceConnection;)V
    //   334: iconst_2
    //   335: invokestatic 1332	com/tencent/mm/plugin/webview/ui/tools/widget/o:La	(I)V
    //   338: invokestatic 1398	com/tencent/mm/plugin/gallery/model/e:bDP	()Lcom/tencent/mm/plugin/gallery/model/c;
    //   341: aconst_null
    //   342: invokevirtual 1403	com/tencent/mm/plugin/gallery/model/c:b	(Lcom/tencent/mm/plugin/gallery/model/d$b;)V
    //   345: sipush 21421
    //   348: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: return
    //   352: astore 4
    //   354: ldc 244
    //   356: ldc_w 1405
    //   359: iconst_1
    //   360: anewarray 262	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload 4
    //   367: invokevirtual 1408	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   370: aastore
    //   371: invokestatic 1410	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: ldc 244
    //   376: aload 4
    //   378: ldc_w 335
    //   381: iconst_0
    //   382: anewarray 262	java/lang/Object
    //   385: invokestatic 514	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: goto -185 -> 203
    //   391: ldc 244
    //   393: ldc_w 1412
    //   396: invokestatic 349	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: goto -196 -> 203
    //   402: iconst_0
    //   403: istore_2
    //   404: goto -115 -> 289
    //   407: astore 4
    //   409: ldc 244
    //   411: aload 4
    //   413: ldc_w 335
    //   416: iconst_0
    //   417: anewarray 262	java/lang/Object
    //   420: invokestatic 514	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -126 -> 297
    //   426: astore 4
    //   428: ldc 244
    //   430: aload 4
    //   432: ldc_w 1414
    //   435: iconst_0
    //   436: anewarray 262	java/lang/Object
    //   439: invokestatic 514	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: goto -108 -> 334
    //   445: iconst_1
    //   446: istore_2
    //   447: goto -158 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	AlbumPreviewUI
    //   264	28	1	i	int
    //   293	154	2	bool1	boolean
    //   269	24	3	bool2	boolean
    //   29	261	4	localObject	Object
    //   352	25	4	localException	Exception
    //   407	5	4	localRemoteException	RemoteException
    //   426	5	4	localThrowable	java.lang.Throwable
    //   97	13	5	localb	i.b
    // Exception table:
    //   from	to	target	type
    //   161	203	352	java/lang/Exception
    //   203	219	407	android/os/RemoteException
    //   219	248	407	android/os/RemoteException
    //   248	286	407	android/os/RemoteException
    //   289	297	407	android/os/RemoteException
    //   326	334	426	java/lang/Throwable
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21429);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ab.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.ner != null) && (this.ner.Zb))
      {
        this.ner.bEv();
        AppMethodBeat.o(21429);
        return true;
      }
      finish();
      AppMethodBeat.o(21429);
      return true;
    }
    if (paramInt == 82)
    {
      this.neJ += 1;
      if (this.ner != null) {
        this.ner.bEv();
      }
      AppMethodBeat.o(21429);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21429);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21419);
    super.onPause();
    ab.i("MicroMsg.AlbumPreviewUI", "on onPause");
    this.neE = true;
    ab.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.neA);
    if (this.neA) {
      bEr();
    }
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.ner != null) && (this.ner.Zb))
    {
      localImageFolderMgrView = this.ner;
      if (localImageFolderMgrView.Zb) {
        break label134;
      }
      ab.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.eez);
      this.eez = 0;
      AppMethodBeat.o(21419);
      return;
      label134:
      if (localImageFolderMgrView.nfL)
      {
        ab.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.nfH.setVisibility(8);
        localImageFolderMgrView.Zb = false;
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(21435);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21435);
      return;
    }
    ab.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21435);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(21435);
        return;
      }
      h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131300273), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21407);
          AlbumPreviewUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          AppMethodBeat.o(21407);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21420);
    super.onResume();
    ab.i("MicroMsg.AlbumPreviewUI", "on resume");
    this.neE = false;
    AppMethodBeat.o(21420);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(21422);
    this.neG = com.tencent.mm.plugin.gallery.model.e.bDQ().hQK;
    paramBundle.putInt("constants_key", this.neG);
    AppMethodBeat.o(21422);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */