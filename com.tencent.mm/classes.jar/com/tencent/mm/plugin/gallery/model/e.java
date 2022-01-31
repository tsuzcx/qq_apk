package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.stub.a;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class e
{
  private static int bpY = 0;
  private static e ncT = null;
  public static boolean ncU = false;
  public static boolean ncV = false;
  public static boolean ncW = false;
  public static boolean ncX = false;
  private Object lock;
  private l ncO;
  private c ncP;
  private g ncQ;
  private ArrayList<GalleryItem.MediaItem> ncR;
  private LinkedHashSet<GalleryItem.MediaItem> ncS;
  private HashSet<GalleryItem.MediaItem> ncY;
  private ArrayList<Bundle> ncZ;
  private HashMap<Integer, Boolean> nda;
  
  private e()
  {
    AppMethodBeat.i(21246);
    this.ncR = null;
    this.ncS = new LinkedHashSet();
    this.lock = new Object();
    this.ncY = new HashSet();
    this.ncZ = new ArrayList();
    this.nda = new HashMap();
    if (this.ncP == null) {
      this.ncP = new c();
    }
    if (this.ncO == null) {
      this.ncO = new l();
    }
    if (this.ncQ == null) {
      this.ncQ = new g();
    }
    AppMethodBeat.o(21246);
  }
  
  public static void B(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(21256);
    bDO().ncR = paramArrayList;
    AppMethodBeat.o(21256);
  }
  
  public static GalleryItem.MediaItem PB(String paramString)
  {
    AppMethodBeat.i(21245);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (bDO().ncR != null)
    {
      int i = bDO().ncR.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)bDO().ncR.get(i);
        AppMethodBeat.o(21245);
        return paramString;
      }
    }
    AppMethodBeat.o(21245);
    return null;
  }
  
  public static void a(a parama, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(21260);
    ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    if (parama == null)
    {
      ab.e("MicroMsg.GalleryCore", "invoker is null");
      AppMethodBeat.o(21260);
      return;
    }
    int i;
    if (bDO().ncO.hQK == 3) {
      i = 1;
    }
    for (;;)
    {
      int j;
      label85:
      Object localObject;
      label211:
      int n;
      int i1;
      int i2;
      int i3;
      boolean bool2;
      int m;
      boolean bool3;
      label352:
      int k;
      if (bDO().ncY != null)
      {
        j = bDO().ncY.size();
        ab.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          parama.aK(13858, i + "," + paramInt + "," + j + ",0");
        }
        boolean bool1 = parama.hT(true);
        ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(bool1) });
        Iterator localIterator = bDO().ncZ.iterator();
        label360:
        do
        {
          if (!localIterator.hasNext()) {
            break label625;
          }
          localObject = (Bundle)localIterator.next();
          String str = ((Bundle)localObject).getString("after_photo_edit");
          if ((!bool1) || (!paramBoolean2))
          {
            ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            com.tencent.mm.vfs.e.deleteFile(str);
            b.a(str, ah.getContext());
          }
          n = ((Bundle)localObject).getInt("report_info_emotion_count");
          i1 = ((Bundle)localObject).getInt("report_info_text_count");
          i2 = ((Bundle)localObject).getInt("report_info_mosaic_count");
          i3 = ((Bundle)localObject).getInt("report_info_doodle_count");
          bool2 = ((Bundle)localObject).getBoolean("report_info_iscrop");
          m = ((Bundle)localObject).getInt("report_info_undo_count");
          bool3 = ((Bundle)localObject).getBoolean("report_info_is_rotation");
          if (!bool2) {
            break;
          }
          paramInt = 1;
          if (!bool3) {
            break label609;
          }
          k = 1;
          ab.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
        } while (j <= 0);
      }
      for (;;)
      {
        try
        {
          localObject = new StringBuilder().append(i).append(",").append(paramBoolean1).append(",").append(n).append(",").append(i1).append(",").append(i2).append(",").append(i3).append(",");
          if (!bool2) {
            break label615;
          }
          paramInt = 1;
          localObject = ((StringBuilder)localObject).append(paramInt).append(",").append(m).append(",2");
          if (!bool3) {
            break label620;
          }
          paramInt = 1;
          parama.aK(13857, paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          ab.printErrStackTrace("MicroMsg.GalleryCore", localRemoteException, "", new Object[0]);
        }
        break label211;
        if (bDO().ncO.hQK != 4) {
          break label632;
        }
        i = 2;
        break;
        j = 0;
        break label85;
        paramInt = 0;
        break label352;
        label609:
        k = 0;
        break label360;
        label615:
        paramInt = 0;
        continue;
        label620:
        paramInt = 0;
      }
      label625:
      AppMethodBeat.o(21260);
      return;
      label632:
      i = 0;
    }
  }
  
  public static void a(a parama, String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    AppMethodBeat.i(21261);
    int k = bDO().ncO.hQK;
    int i;
    switch (k)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ab.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(k) });
      if (parama != null) {
        break;
      }
      ab.e("MicroMsg.GalleryCore", "invoker is null");
      AppMethodBeat.o(21261);
      return;
      i = 1;
      continue;
      i = j;
      if (!bo.isNullOrNil(paramString))
      {
        i = j;
        if (paramString.equals(ah.getContext().getString(2131299680)))
        {
          i = 6;
          continue;
          i = 3;
        }
      }
    }
    try
    {
      parama.aK(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + ncU + "," + ncV + "," + ncW + "," + ncX);
      ncU = false;
      ncV = false;
      ncW = false;
      ncX = false;
      AppMethodBeat.o(21261);
      return;
    }
    catch (RemoteException parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GalleryCore", parama, "", new Object[0]);
      }
    }
  }
  
  private static e bDO()
  {
    AppMethodBeat.i(21247);
    if (ncT == null) {
      ncT = new e();
    }
    e locale = ncT;
    AppMethodBeat.o(21247);
    return locale;
  }
  
  public static c bDP()
  {
    AppMethodBeat.i(21248);
    c localc = bDO().ncP;
    AppMethodBeat.o(21248);
    return localc;
  }
  
  public static l bDQ()
  {
    AppMethodBeat.i(21249);
    l locall = bDO().ncO;
    AppMethodBeat.o(21249);
    return locall;
  }
  
  public static g bDR()
  {
    AppMethodBeat.i(21250);
    g localg = bDO().ncQ;
    AppMethodBeat.o(21250);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> bDS()
  {
    AppMethodBeat.i(156806);
    ArrayList localArrayList = bDO().ncR;
    AppMethodBeat.o(156806);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> bDT()
  {
    AppMethodBeat.i(21253);
    HashSet localHashSet = bDO().ncY;
    AppMethodBeat.o(21253);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> bDU()
  {
    AppMethodBeat.i(21254);
    ArrayList localArrayList = bDO().ncZ;
    AppMethodBeat.o(21254);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> bDV()
  {
    AppMethodBeat.i(21255);
    LinkedHashSet localLinkedHashSet = bDO().ncS;
    AppMethodBeat.o(21255);
    return localLinkedHashSet;
  }
  
  public static void bDW()
  {
    AppMethodBeat.i(21258);
    bDO().nda.clear();
    AppMethodBeat.o(21258);
  }
  
  public static int bDX()
  {
    AppMethodBeat.i(21259);
    int i = bDO().nda.size();
    AppMethodBeat.o(21259);
    return i;
  }
  
  public static void initialize()
  {
    try
    {
      bpY += 1;
      return;
    }
    finally {}
  }
  
  public static void release(boolean paramBoolean)
  {
    AppMethodBeat.i(21251);
    try
    {
      if (bpY > 0) {
        bpY -= 1;
      }
      if ((paramBoolean) && (bpY == 0))
      {
        bDO().ncO = null;
        if (bDO().ncP != null)
        {
          localObject1 = bDO().ncP.ncA;
          if (((d)localObject1).ncK != null)
          {
            ((d)localObject1).ncK.a(new d.4((d)localObject1));
            ((d)localObject1).ncK = null;
          }
          if (((d)localObject1).ncL != null)
          {
            f localf = ((d)localObject1).ncL;
            localf.bDZ();
            localf.bEa();
            localf.bEc();
            ((d)localObject1).ncL = null;
          }
          bDO().ncP = null;
        }
        Object localObject1 = bDO().ncQ;
        if (((g)localObject1).ndf != null)
        {
          ((g)localObject1).ndf.quit();
          ((g)localObject1).ndf = null;
        }
        ((g)localObject1).ndi = null;
        if (((g)localObject1).ndg != null)
        {
          ((g)localObject1).ndg.quit();
          ((g)localObject1).ndg = null;
        }
        ((g)localObject1).ndj = null;
        if (((g)localObject1).ndh != null)
        {
          ((g)localObject1).ndh.quit();
          ((g)localObject1).ndh = null;
        }
        ((g)localObject1).ndk = null;
        bDO().ncQ = null;
        ncT = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(21251);
    }
  }
  
  public static void wG(int paramInt)
  {
    AppMethodBeat.i(21257);
    bDO().nda.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(21257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */