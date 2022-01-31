package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
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
  implements g.b
{
  static long start = 0L;
  private String bRO;
  private int dmY;
  private ProgressDialog dnm;
  private ServiceConnection iAC = new AlbumPreviewUI.1(this);
  private com.tencent.mm.plugin.gallery.stub.a kHB = null;
  private GridView kHX;
  private TextView kHY;
  private boolean kHZ;
  private int kIA = -1;
  private long kIB = -1L;
  private a.a kIC = new AlbumPreviewUI.7(this);
  private boolean kID = false;
  private HashMap<String, Integer> kIE = new HashMap();
  private boolean kIa;
  private TextView kIb;
  private a kIc;
  private TextView kId;
  private TextView kIe;
  private ImageFolderMgrView kIf;
  private TextView kIg;
  private ImageButton kIh;
  private String kIi;
  private String kIj;
  private int kIk;
  private String kIl;
  private boolean kIm = false;
  private boolean kIn = false;
  private boolean kIo = false;
  private boolean kIp = false;
  private boolean kIq = false;
  private boolean kIr = false;
  private boolean kIs = false;
  private int kIt;
  private int kIu;
  boolean kIv = false;
  private int kIw = 0;
  private int kIx = 0;
  private long kIy = 0L;
  private long kIz;
  private String toUser;
  
  private static int[] B(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem != null) {
        if ((!bk.bl(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
          arrayOfInt[2] += 1;
        } else if (localMediaItem.getType() == 2) {
          arrayOfInt[3] += 1;
        } else if (localMediaItem.getType() == 1) {
          arrayOfInt[1] += 1;
        }
      }
    }
    return arrayOfInt;
  }
  
  private void a(GalleryItem.AlbumItem paramAlbumItem)
  {
    if (paramAlbumItem == null) {
      return;
    }
    if (bk.aM(this.kIj, "").equals(paramAlbumItem.kGT))
    {
      y.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      return;
    }
    c.aXg().addAll(this.kIc.kHD);
    y.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.kGT, paramAlbumItem.aXs() });
    this.kIi = paramAlbumItem.aXs();
    this.kIj = paramAlbumItem.kGT;
    if (paramAlbumItem.kGU != null) {
      this.kIk = paramAlbumItem.kGU.getType();
    }
    if (bk.bl(this.kIi))
    {
      y.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.kIi = this.kIj;
    }
    Object localObject1;
    Object localObject2;
    if (!bk.bl(this.kIj))
    {
      localObject1 = this.kIc;
      localObject2 = this.kIC;
      if (localObject2 == null)
      {
        y.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        label170:
        this.kIb.setText(this.kIj);
      }
    }
    for (;;)
    {
      this.kIc.kHC.clear();
      rU(this.kIc.kHD.size());
      this.kIc.notifyDataSetChanged();
      if (this.dnm != null) {
        this.dnm.dismiss();
      }
      getString(R.l.app_tip);
      this.dnm = h.b(this, getString(R.l.app_waiting), true, new AlbumPreviewUI.11(this));
      start = System.currentTimeMillis();
      localObject2 = this.kIj;
      if (paramAlbumItem.kGU == null) {
        break;
      }
      int i = paramAlbumItem.kGU.getType();
      int j = c.aXb().aXF();
      y.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = localObject2;
      if (j != 2)
      {
        localObject1 = localObject2;
        if (paramAlbumItem.kGU.getType() == 2) {
          localObject1 = "";
        }
      }
      if (bk.bl(paramAlbumItem.kGT)) {
        i = 3;
      }
      this.kIB = System.currentTimeMillis();
      c.aXb().e((String)localObject1, i, this.kIB);
      return;
      ((a)localObject1).kHG.remove(localObject2);
      break label170;
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.kIc.a(this.kIC);
      }
      updateTitle();
      this.kIk = c.aXb().aXF();
    }
  }
  
  private void aXM()
  {
    if (!this.kID) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
    y.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.kIj + ", " + this.kIi);
    localSharedPreferences.edit().putString(c.aXb().aXF(), this.kIj + "|" + this.kIi + "|" + this.kIk).commit();
  }
  
  private void awX()
  {
    if (!com.tencent.mm.pluginsdk.ui.tools.l.c(this.mController.uMN, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(this.mController.uMN, getString(R.l.selectcameraapp_none), 1).show();
      return;
    }
    c.aXc().rN(0);
    System.gc();
  }
  
  private boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    if (paramMediaItem == null)
    {
      y.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      return false;
    }
    if (this.kHB == null)
    {
      y.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
      return false;
    }
    if (c.aXb().aXE() == 3)
    {
      if (!new File(paramMediaItem.eAu).exists())
      {
        h.bB(this, getString(R.l.gallery_select_video_not_exit));
        return false;
      }
      try
      {
        if (this.kHB.Es(paramMediaItem.eAu) > 300)
        {
          h.bB(this, getString(R.l.gallery_select_video_to_long));
          return false;
        }
      }
      catch (RemoteException paramMediaItem)
      {
        y.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramMediaItem, "", new Object[0]);
      }
      return true;
    }
    return true;
  }
  
  private void rU(int paramInt)
  {
    if (paramInt == 0)
    {
      this.kHY.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label58;
      }
      this.kHY.setText(R.l.gallery_pic_preview);
    }
    for (;;)
    {
      updateOptionMenuText(0, rV(paramInt));
      return;
      this.kHY.setEnabled(true);
      enableOptionMenu(true);
      break;
      label58:
      this.kHY.setText(getString(R.l.gallery_pic_preview) + "(" + paramInt + ")");
    }
  }
  
  private String rV(int paramInt)
  {
    switch (c.aXb().aXE())
    {
    default: 
      if ((paramInt == 0) || (this.kIt <= 1)) {
        return getString(R.l.app_send);
      }
      break;
    case 4: 
    case 7: 
    case 8: 
    case 13: 
      if ((paramInt == 0) || (this.kIt <= 1)) {
        return getString(R.l.gallery_pic_timeline_send);
      }
      return getString(R.l.gallery_pic_timeline_send) + "(" + paramInt + "/" + this.kIt + ")";
    }
    return getString(R.l.gallery_pic_chatting_send, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kIt) });
  }
  
  private void updateTitle()
  {
    if (c.aXb().aXF() == 3)
    {
      setMMTitle(R.l.gallery_all_pic_and_video);
      this.kIb.setText(R.l.gallery_all_pic_and_video);
      return;
    }
    if (c.aXb().aXF() == 1)
    {
      setMMTitle(R.l.gallery_send_pic);
      this.kIb.setText(R.l.gallery_all_pic);
      return;
    }
    setMMTitle(R.l.gallery_all_video);
    this.kIb.setText(R.l.gallery_all_video);
  }
  
  public final void P(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    switch (c.aXb().aXF())
    {
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((bk.bl(this.bRO)) || ("medianote".equals(this.toUser)));
      if (bk.UZ() - this.kIy < 1000L)
      {
        y.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
        return;
      }
      y.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.kIc.kHC.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    try
    {
      com.tencent.mm.plugin.gallery.stub.a locala = this.kHB;
      localObject = ((GalleryItem.MediaItem)localObject).eAu;
      String str = this.toUser;
      if (this.kIm) {}
      for (;;)
      {
        locala.a((String)localObject, str, bool1, 0, paramBoolean);
        return;
        boolean bool2 = this.kIq;
        if (bool2) {
          bool1 = false;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void a(ArrayList<GalleryItem.MediaItem> paramArrayList, long paramLong)
  {
    if (paramLong != this.kIB)
    {
      y.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.kIB) });
      y.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add((GalleryItem.MediaItem)paramArrayList.next());
        }
      }
    } while (this.kIc == null);
    paramArrayList = new AlbumPreviewUI.a((byte)0);
    paramArrayList.kIL = new WeakReference(this.kIc);
    paramArrayList.kIM = new WeakReference(this.dnm);
    paramArrayList.kIN = localArrayList;
    c.aXc().d(paramArrayList);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.sd_card_media_folder_preview;
  }
  
  protected final void initView()
  {
    Object localObject = getIntent().getExtras().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      y.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, getIntent().getExtras().get(str) });
    }
    this.bRO = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.kIt = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (c.aXb().aXE() == 4)
    {
      bool = true;
      this.kIm = bool;
      if (c.aXb().aXE() != 5) {
        break label820;
      }
      bool = true;
      label141:
      this.kIo = bool;
      if (c.aXb().aXE() != 9) {
        break label825;
      }
      bool = true;
      label159:
      this.kIp = bool;
      this.kIi = getIntent().getStringExtra("folder_path");
      this.kIj = getIntent().getStringExtra("folder_name");
      if (bk.bl(this.kIi))
      {
        y.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
        this.kIi = this.kIj;
      }
      this.kIq = getIntent().getBooleanExtra("key_send_raw_image", false);
      this.kIr = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.kIg = ((TextView)findViewById(R.h.orignal_image_tip));
      this.kIh = ((ImageButton)findViewById(R.h.orignal_image));
      this.kIg.setOnClickListener(new AlbumPreviewUI.12(this));
      if (c.aXb().aXE() != 3) {
        break label830;
      }
      this.kIh.setVisibility(0);
      this.kIg.setVisibility(0);
      label317:
      if (!this.kIq) {
        break label851;
      }
      this.kIh.setImageResource(R.k.radio_on);
      label334:
      this.kIh.setOnClickListener(new AlbumPreviewUI.13(this));
      this.kId = ((TextView)findViewById(R.h.album_tips_bar));
      this.kIe = ((TextView)findViewById(R.h.album_photo_edit_tips_bar));
      this.kHY = ((TextView)findViewById(R.h.media_preview));
      if ((c.aXb().aXE() != 0) && (c.aXb().aXE() != 5) && (c.aXb().aXE() != 10) && (c.aXb().aXE() != 11)) {
        break label864;
      }
      findViewById(R.h.footer_line).setVisibility(8);
      this.kHY.setVisibility(8);
    }
    for (;;)
    {
      this.kIf = ((ImageFolderMgrView)findViewById(R.h.image_folder_mgr_view));
      localObject = this.kIf;
      c.aXb().b((g.a)localObject);
      c.aXb().a((g.a)localObject);
      c.aXb().aXG();
      this.kIf.setListener(new AlbumPreviewUI.16(this));
      this.kIl = getIntent().getStringExtra("send_btn_string");
      findViewById(R.h.media_folder).setOnClickListener(new AlbumPreviewUI.17(this));
      this.kIb = ((TextView)findViewById(R.h.media_folder_tv));
      if (this.kIo) {
        showOptionMenu(false);
      }
      enableOptionMenu(false);
      this.kHX = ((GridView)findViewById(R.h.media_in_folder_gv));
      this.kHX.setOnItemClickListener(new AlbumPreviewUI.2(this));
      this.kIc = new a(this, new AlbumPreviewUI.3(this));
      if (this.kIm) {
        this.kIc.kHH = true;
      }
      if (this.kIr) {
        this.kIc.kHH = true;
      }
      this.kHX.setNumColumns(4);
      this.kHX.setOnScrollListener(new AlbumPreviewUI.4(this));
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.kIc.a(this.kIC);
      }
      this.kIc.kHF = c.aXb().aXF();
      this.kIc.kHA = this.kIt;
      y.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
      this.kHX.setAdapter(this.kIc);
      updateTitle();
      setBackBtn(new AlbumPreviewUI.5(this));
      localObject = (ViewGroup)findViewById(R.h.root);
      if ((localObject instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject).setListener(new AlbumPreviewUI.6(this));
      }
      return;
      bool = false;
      break;
      label820:
      bool = false;
      break label141;
      label825:
      bool = false;
      break label159;
      label830:
      this.kIh.setVisibility(8);
      this.kIg.setVisibility(8);
      break label317;
      label851:
      this.kIh.setImageResource(R.k.radio_off);
      break label334;
      label864:
      this.kHY.setVisibility(0);
      this.kHY.setOnClickListener(new AlbumPreviewUI.14(this));
      if (((c.aXb().aXF() == 1) || (c.aXb().aXF() == 2) || (c.aXb().aXF() == 3)) && (this.kIt > 0))
      {
        localObject = new AlbumPreviewUI.15(this);
        if (!bk.bl(this.kIl)) {
          addTextOptionMenu(0, this.kIl, (MenuItem.OnMenuItemClickListener)localObject);
        } else {
          a(0, rV(0), (MenuItem.OnMenuItemClickListener)localObject, s.b.uNx);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (4369 == paramInt1) {
      if (-1 == paramInt2) {}
    }
    label1236:
    label1250:
    for (;;)
    {
      return;
      Object localObject1 = com.tencent.mm.pluginsdk.ui.tools.l.f(this.mController.uMN.getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.dzD);
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        return;
      }
      y.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      Object localObject2;
      if ((c.aXb().aXE() == 0) || (c.aXb().aXE() == 5) || (c.aXb().aXE() == 11))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        y.i("MicroMsg.AlbumPreviewUI", "take photo finish");
        setResult(-1, (Intent)localObject2);
        finish();
        localObject1 = paramIntent;
      }
      for (;;)
      {
        if ((localObject1 == null) || (!((Intent)localObject1).getBooleanExtra("show_photo_edit_tip", false))) {
          break label1250;
        }
        paramIntent = getSharedPreferences("photo_edit_pref", 0);
        if (paramIntent.getBoolean("has_show_tip", false)) {
          break;
        }
        this.kIe.setVisibility(0);
        this.kIe.setText(getString(R.l.photo_edit_tips));
        localObject1 = AnimationUtils.loadAnimation(this.mController.uMN, R.a.fast_faded_in);
        this.kIe.startAnimation((Animation)localObject1);
        ((Animation)localObject1).setAnimationListener(new AlbumPreviewUI.8(this));
        paramIntent.edit().putBoolean("has_show_tip", true).commit();
        return;
        localObject2 = new ArrayList(1);
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject1).putExtra("isTakePhoto", true);
        ((Intent)localObject1).putExtra("max_select_count", 1);
        ((Intent)localObject1).putExtra("send_raw_img", this.kIq);
        ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.bRO);
        ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
        startActivityForResult((Intent)localObject1, 4370);
        localObject1 = paramIntent;
        continue;
        if (4370 == paramInt1)
        {
          if (-1 != paramInt2) {
            break;
          }
          if (paramIntent.getBooleanExtra("GalleryUI_IsSendImgBackground", false))
          {
            y.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
            setResult(-1, paramIntent);
            finish();
            return;
          }
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
          {
            y.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
            return;
          }
          y.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
          setResult(-1, paramIntent);
          finish();
          localObject1 = paramIntent;
          continue;
        }
        if (4371 == paramInt1)
        {
          if (-1 != paramInt2) {
            break;
          }
          if (paramIntent != null) {
            paramIntent.putExtra("from_record", true);
          }
          y.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
          setResult(-1, paramIntent);
          finish();
          localObject1 = paramIntent;
          continue;
        }
        if (4372 == paramInt1)
        {
          if (-1 != paramInt2) {
            break;
          }
          localObject1 = paramIntent;
          if (paramIntent == null) {
            localObject1 = new Intent();
          }
          y.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
          paramIntent = new ArrayList();
          localObject2 = getIntent().getStringExtra("video_full_path");
          if (!bk.bl((String)localObject2))
          {
            paramIntent.add(localObject2);
            ((Intent)localObject1).putExtra("key_select_video_list", paramIntent);
            ((Intent)localObject1).putExtra("key_selected_video_is_from_sys_camera", true);
          }
          setResult(-1, (Intent)localObject1);
          finish();
          continue;
        }
        if (4373 == paramInt1)
        {
          if (paramIntent != null)
          {
            paramIntent.putExtra("GalleryUI_IsSendImgBackground", true);
            y.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
          }
          y.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
          setResult(-1, paramIntent);
          this.kIv = true;
          finish();
          localObject1 = paramIntent;
        }
        else
        {
          if (4375 == paramInt1)
          {
            if (-1 != paramInt2) {
              break;
            }
            localObject1 = paramIntent;
            if (paramIntent == null) {
              localObject1 = new Intent();
            }
            y.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
            paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
            if (paramIntent == null)
            {
              y.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
              setResult(1);
              finish();
              return;
            }
            localObject2 = new ArrayList();
            String str = paramIntent.mfj;
            if (!bk.bl(str))
            {
              ((ArrayList)localObject2).add(str);
              ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
            }
            if ((paramIntent.mfh) && (!bk.bl(paramIntent.mfp)))
            {
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(paramIntent.mfp);
              ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
            }
            setResult(-1, (Intent)localObject1);
            finish();
            continue;
          }
          if (4376 == paramInt1)
          {
            if (-1 != paramInt2)
            {
              y.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
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
                setMMTitle(bk.aM(((GalleryItem.AlbumItem)localObject1).kGT, getString(R.l.gallery_all_pic_and_video)));
                localObject1 = paramIntent;
              }
            }
          }
          else {
            switch (paramInt2)
            {
            default: 
              localObject1 = paramIntent;
              break;
            case -2: 
              y.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
              finish();
              localObject1 = paramIntent;
              break;
            case -1: 
              localObject1 = paramIntent;
              if (paramIntent == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.kIc.aXJ());
              }
              y.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.kIa = true;
              setResult(-1, (Intent)localObject1);
              aXM();
              finish();
              break;
            case 0: 
              localObject1 = paramIntent;
              if (paramIntent != null)
              {
                localObject1 = paramIntent.getStringArrayListExtra("preview_image_list");
                if (localObject1 != null)
                {
                  this.kIc.A((ArrayList)localObject1);
                  this.kIc.notifyDataSetChanged();
                  rU(((ArrayList)localObject1).size());
                }
                if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true)) {}
                for (boolean bool = true;; bool = false)
                {
                  this.kIq = bool;
                  if (!this.kIq) {
                    break label1236;
                  }
                  this.kIh.setImageResource(R.k.radio_on);
                  localObject1 = paramIntent;
                  break;
                }
                this.kIh.setImageResource(R.k.radio_off);
                localObject1 = paramIntent;
              }
              break;
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kIz = System.currentTimeMillis();
    y.i("MicroMsg.AlbumPreviewUI", "onCreate");
    if (paramBundle != null)
    {
      y.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.kIu = paramBundle.getInt("constants_key");
      c.aXb().rP(this.kIu);
    }
    getString(R.l.app_tip);
    this.dnm = h.b(this, getString(R.l.app_waiting), true, new AlbumPreviewUI.10(this));
    int i = getIntent().getIntExtra("query_source_type", 3);
    int j = getIntent().getIntExtra("query_media_type", 1);
    y.i("MicroMsg.AlbumPreviewUI", "query souce: " + i + ", queryType: " + j);
    c.aXb().rO(j);
    c.aXb().rP(i);
    initView();
    c.aXb().kHn.add(this);
    this.kIB = System.currentTimeMillis();
    paramBundle = c.aXb();
    String str = this.kIj;
    long l = this.kIB;
    paramBundle.e(str, paramBundle.kHp, l);
    bindService(new Intent(this.mController.uMN, GalleryStubService.class), this.iAC, 1);
    o.Dh(1);
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1216	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   4: ldc 176
    //   6: ldc_w 1217
    //   9: invokestatic 465	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 685	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIf	Lcom/tencent/mm/plugin/gallery/ui/ImageFolderMgrView;
    //   16: astore 4
    //   18: invokestatic 378	com/tencent/mm/plugin/gallery/model/c:aXb	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   21: aload 4
    //   23: invokevirtual 851	com/tencent/mm/plugin/gallery/model/l:b	(Lcom/tencent/mm/plugin/gallery/model/g$a;)V
    //   26: invokestatic 378	com/tencent/mm/plugin/gallery/model/c:aXb	()Lcom/tencent/mm/plugin/gallery/model/l;
    //   29: getfield 1196	com/tencent/mm/plugin/gallery/model/l:kHn	Ljava/util/HashSet;
    //   32: aload_0
    //   33: invokevirtual 1218	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield 93	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIw	I
    //   41: ifgt +10 -> 51
    //   44: aload_0
    //   45: getfield 95	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIx	I
    //   48: ifle +252 -> 300
    //   51: ldc 176
    //   53: ldc_w 1220
    //   56: iconst_2
    //   57: anewarray 194	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 93	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIw	I
    //   66: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_0
    //   73: getfield 95	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIx	I
    //   76: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 229	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 97	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kHB	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   87: sipush 11187
    //   90: new 449	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   97: aload_0
    //   98: getfield 93	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIw	I
    //   101: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 1222
    //   107: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 95	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIx	I
    //   114: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokeinterface 1225 3 0
    //   125: aload_0
    //   126: getfield 99	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIy	J
    //   129: lconst_0
    //   130: lcmp
    //   131: ifgt +10 -> 141
    //   134: aload_0
    //   135: getfield 1155	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIa	Z
    //   138: ifeq +32 -> 170
    //   141: aload_0
    //   142: getfield 97	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kHB	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   145: aload_0
    //   146: getfield 867	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIl	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 270	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIc	Lcom/tencent/mm/plugin/gallery/ui/a;
    //   153: getfield 299	com/tencent/mm/plugin/gallery/ui/a:kHD	Ljava/util/ArrayList;
    //   156: invokestatic 1227	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:B	(Ljava/util/ArrayList;)[I
    //   159: aload_0
    //   160: getfield 85	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIq	Z
    //   163: aload_0
    //   164: getfield 593	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kHZ	Z
    //   167: invokestatic 1230	com/tencent/mm/plugin/gallery/model/c:a	(Lcom/tencent/mm/plugin/gallery/stub/a;Ljava/lang/String;[IZZ)V
    //   170: aload_0
    //   171: getfield 97	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kHB	Lcom/tencent/mm/plugin/gallery/stub/a;
    //   174: astore 4
    //   176: aload_0
    //   177: getfield 270	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIc	Lcom/tencent/mm/plugin/gallery/ui/a;
    //   180: getfield 299	com/tencent/mm/plugin/gallery/ui/a:kHD	Ljava/util/ArrayList;
    //   183: invokevirtual 135	java/util/ArrayList:size	()I
    //   186: istore_1
    //   187: aload_0
    //   188: getfield 85	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIq	Z
    //   191: istore_3
    //   192: aload_0
    //   193: getfield 99	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIy	J
    //   196: lconst_0
    //   197: lcmp
    //   198: ifgt +156 -> 354
    //   201: aload_0
    //   202: getfield 1155	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:kIa	Z
    //   205: ifeq +106 -> 311
    //   208: goto +146 -> 354
    //   211: aload 4
    //   213: iload_1
    //   214: iload_3
    //   215: iload_2
    //   216: invokestatic 1233	com/tencent/mm/plugin/gallery/model/c:a	(Lcom/tencent/mm/plugin/gallery/stub/a;IZZ)V
    //   219: getstatic 1239	com/tencent/mm/api/q:buU	Lcom/tencent/mm/api/q$b;
    //   222: invokeinterface 1245 1 0
    //   227: invokevirtual 1248	com/tencent/mm/api/q:rI	()V
    //   230: invokestatic 211	com/tencent/mm/plugin/gallery/model/c:aXe	()Ljava/util/HashSet;
    //   233: invokevirtual 1249	java/util/HashSet:clear	()V
    //   236: invokestatic 1252	com/tencent/mm/plugin/gallery/model/c:aXf	()Ljava/util/ArrayList;
    //   239: invokevirtual 339	java/util/ArrayList:clear	()V
    //   242: invokestatic 293	com/tencent/mm/plugin/gallery/model/c:aXg	()Ljava/util/LinkedHashSet;
    //   245: invokevirtual 1253	java/util/LinkedHashSet:clear	()V
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 108	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:iAC	Landroid/content/ServiceConnection;
    //   253: invokevirtual 1257	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:unbindService	(Landroid/content/ServiceConnection;)V
    //   256: iconst_2
    //   257: invokestatic 1211	com/tencent/mm/plugin/webview/ui/tools/widget/o:Dh	(I)V
    //   260: return
    //   261: astore 4
    //   263: ldc 176
    //   265: ldc_w 1259
    //   268: iconst_1
    //   269: anewarray 194	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: aload 4
    //   276: invokevirtual 1262	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   279: aastore
    //   280: invokestatic 1264	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: ldc 176
    //   285: aload 4
    //   287: ldc_w 275
    //   290: iconst_0
    //   291: anewarray 194	java/lang/Object
    //   294: invokestatic 569	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: goto -172 -> 125
    //   300: ldc 176
    //   302: ldc_w 1266
    //   305: invokestatic 289	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: goto -183 -> 125
    //   311: iconst_0
    //   312: istore_2
    //   313: goto -102 -> 211
    //   316: astore 4
    //   318: ldc 176
    //   320: aload 4
    //   322: ldc_w 275
    //   325: iconst_0
    //   326: anewarray 194	java/lang/Object
    //   329: invokestatic 569	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: goto -113 -> 219
    //   335: astore 4
    //   337: ldc 176
    //   339: aload 4
    //   341: ldc_w 1268
    //   344: iconst_0
    //   345: anewarray 194	java/lang/Object
    //   348: invokestatic 569	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: goto -95 -> 256
    //   354: iconst_1
    //   355: istore_2
    //   356: goto -145 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	AlbumPreviewUI
    //   186	28	1	i	int
    //   215	141	2	bool1	boolean
    //   191	24	3	bool2	boolean
    //   16	196	4	localObject	Object
    //   261	25	4	localException	Exception
    //   316	5	4	localRemoteException	RemoteException
    //   335	5	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   83	125	261	java/lang/Exception
    //   125	141	316	android/os/RemoteException
    //   141	170	316	android/os/RemoteException
    //   170	208	316	android/os/RemoteException
    //   211	219	316	android/os/RemoteException
    //   248	256	335	java/lang/Throwable
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      y.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if (this.kIf.Yq)
      {
        this.kIf.aXP();
        return true;
      }
      finish();
      return true;
    }
    if (paramInt == 82)
    {
      this.kIx += 1;
      this.kIf.aXP();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.kIs = true;
    c.aXc().aXq().removeCallbacksAndMessages(null);
    c.aXc().aXr();
    y.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.kIn);
    if (this.kIn) {
      aXM();
    }
    ImageFolderMgrView localImageFolderMgrView;
    if (this.kIf.Yq)
    {
      localImageFolderMgrView = this.kIf;
      if (localImageFolderMgrView.Yq) {
        break label112;
      }
      y.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    try
    {
      for (;;)
      {
        this.kHB.rQ(this.dmY);
        this.dmY = 0;
        return;
        label112:
        if (localImageFolderMgrView.kJn)
        {
          y.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
        }
        else
        {
          localImageFolderMgrView.kJj.setVisibility(8);
          localImageFolderMgrView.Yq = false;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AlbumPreviewUI", localException, "", new Object[0]);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      awX();
      return;
    }
    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new AlbumPreviewUI.9(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    y.d("MicroMsg.AlbumPreviewUI", "on resume");
    this.kIs = false;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.kIu = c.aXb().aXE();
    paramBundle.putInt("constants_key", this.kIu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */