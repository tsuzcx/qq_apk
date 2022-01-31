package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.mm.R.l;
import com.tencent.mm.a.f;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class c
{
  private static int aZs = 0;
  private static c kGB = null;
  public static boolean kGC = false;
  public static boolean kGD = false;
  public static boolean kGE = false;
  public static boolean kGF = false;
  private LinkedHashSet<GalleryItem.MediaItem> kGA = new LinkedHashSet();
  private HashSet<GalleryItem.MediaItem> kGG = new HashSet();
  private ArrayList<Bundle> kGH = new ArrayList();
  private HashMap<Integer, Boolean> kGI = new HashMap();
  private l kGw;
  private a kGx;
  private e kGy;
  private ArrayList<GalleryItem.MediaItem> kGz = null;
  
  private c()
  {
    if (this.kGx == null) {
      this.kGx = new a();
    }
    if (this.kGw == null) {
      this.kGw = new l();
    }
    if (this.kGy == null) {
      this.kGy = new e();
    }
  }
  
  public static GalleryItem.MediaItem Ep(String paramString)
  {
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (aWZ().kGz != null)
    {
      int i = aWZ().kGz.indexOf(paramString);
      if (i >= 0) {
        return (GalleryItem.MediaItem)aWZ().kGz.get(i);
      }
    }
    return null;
  }
  
  public static void a(com.tencent.mm.plugin.gallery.stub.a parama, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    if (parama == null)
    {
      y.e("MicroMsg.GalleryCore", "invoker is null");
      return;
    }
    int i;
    if (aWZ().kGw.aXE() == 3) {
      i = 1;
    }
    for (;;)
    {
      label53:
      int j;
      label73:
      Object localObject;
      label199:
      int n;
      int i1;
      int i2;
      int i3;
      boolean bool2;
      int m;
      boolean bool3;
      label339:
      int k;
      if (aWZ().kGG != null)
      {
        j = aWZ().kGG.size();
        y.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          parama.aq(13858, i + "," + paramInt + "," + j + ",0");
        }
        boolean bool1 = parama.gp(true);
        y.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(bool1) });
        Iterator localIterator = aWZ().kGH.iterator();
        label347:
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Bundle)localIterator.next();
          String str = ((Bundle)localObject).getString("after_photo_edit");
          if ((!bool1) || (!paramBoolean2))
          {
            y.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            com.tencent.mm.vfs.e.deleteFile(str);
            q.a(str, ae.getContext());
          }
          n = ((Bundle)localObject).getInt("report_info_emotion_count");
          i1 = ((Bundle)localObject).getInt("report_info_text_count");
          i2 = ((Bundle)localObject).getInt("report_info_mosaic_count");
          i3 = ((Bundle)localObject).getInt("report_info_doodle_count");
          bool2 = ((Bundle)localObject).getBoolean("report_info_iscrop");
          m = ((Bundle)localObject).getInt("report_info_undo_count");
          bool3 = ((Bundle)localObject).getBoolean("report_info_is_rotation");
          if (!bool2) {
            break label589;
          }
          paramInt = 1;
          if (!bool3) {
            break label594;
          }
          k = 1;
          y.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
        } while (j <= 0);
      }
      for (;;)
      {
        try
        {
          localObject = new StringBuilder().append(i).append(",").append(paramBoolean1).append(",").append(n).append(",").append(i1).append(",").append(i2).append(",").append(i3).append(",");
          if (!bool2) {
            break label600;
          }
          paramInt = 1;
          localObject = ((StringBuilder)localObject).append(paramInt).append(",").append(m).append(",2");
          if (!bool3) {
            break label605;
          }
          paramInt = 1;
          parama.aq(13857, paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          y.printErrStackTrace("MicroMsg.GalleryCore", localRemoteException, "", new Object[0]);
        }
        break label199;
        break;
        if (aWZ().kGw.aXE() != 4) {
          break label610;
        }
        i = 2;
        break label53;
        j = 0;
        break label73;
        label589:
        paramInt = 0;
        break label339;
        label594:
        k = 0;
        break label347;
        label600:
        paramInt = 0;
        continue;
        label605:
        paramInt = 0;
      }
      label610:
      i = 0;
    }
  }
  
  public static void a(com.tencent.mm.plugin.gallery.stub.a parama, String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    int k = aWZ().kGw.aXE();
    int i;
    switch (k)
    {
    case 5: 
    case 6: 
    default: 
      i = 0;
    }
    for (;;)
    {
      y.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(k) });
      if (parama != null) {
        break;
      }
      y.e("MicroMsg.GalleryCore", "invoker is null");
      return;
      i = 1;
      continue;
      i = j;
      if (!bk.bl(paramString))
      {
        i = j;
        if (paramString.equals(ae.getContext().getString(R.l.favorite)))
        {
          i = 6;
          continue;
          i = 3;
        }
      }
    }
    try
    {
      parama.aq(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + kGC + "," + kGD + "," + kGE + "," + kGF);
      kGC = false;
      kGD = false;
      kGE = false;
      kGF = false;
      return;
    }
    catch (RemoteException parama)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.GalleryCore", parama, "", new Object[0]);
      }
    }
  }
  
  private static c aWZ()
  {
    if (kGB == null) {
      kGB = new c();
    }
    return kGB;
  }
  
  public static a aXa()
  {
    return aWZ().kGx;
  }
  
  public static l aXb()
  {
    return aWZ().kGw;
  }
  
  public static e aXc()
  {
    return aWZ().kGy;
  }
  
  public static ArrayList<GalleryItem.MediaItem> aXd()
  {
    return aWZ().kGz;
  }
  
  public static HashSet<GalleryItem.MediaItem> aXe()
  {
    return aWZ().kGG;
  }
  
  public static ArrayList<Bundle> aXf()
  {
    return aWZ().kGH;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> aXg()
  {
    return aWZ().kGA;
  }
  
  public static void aXh()
  {
    aWZ().kGI.clear();
  }
  
  public static int aXi()
  {
    return aWZ().kGI.size();
  }
  
  public static void initialize()
  {
    try
    {
      aZs += 1;
      return;
    }
    finally {}
  }
  
  public static void rI(int paramInt)
  {
    aWZ().kGI.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
  }
  
  public static void release(boolean paramBoolean)
  {
    try
    {
      if (aZs > 0) {
        aZs -= 1;
      }
      if ((paramBoolean) && (aZs == 0))
      {
        aWZ().kGw = null;
        if (aWZ().kGx != null)
        {
          localObject1 = aWZ().kGx.kGi;
          if (((b)localObject1).kGs != null)
          {
            ((b)localObject1).kGs.a(new b.4((b)localObject1));
            ((b)localObject1).kGs = null;
          }
          if (((b)localObject1).kGt != null)
          {
            d locald = ((b)localObject1).kGt;
            locald.aXk();
            locald.aXl();
            locald.aXn();
            ((b)localObject1).kGt = null;
          }
          aWZ().kGx = null;
        }
        Object localObject1 = aWZ().kGy;
        if (((e)localObject1).kGN != null)
        {
          ((e)localObject1).kGN.quit();
          ((e)localObject1).kGN = null;
        }
        ((e)localObject1).kGQ = null;
        if (((e)localObject1).kGO != null)
        {
          ((e)localObject1).kGO.quit();
          ((e)localObject1).kGO = null;
        }
        ((e)localObject1).kGR = null;
        if (((e)localObject1).kGP != null)
        {
          ((e)localObject1).kGP.quit();
          ((e)localObject1).kGP = null;
        }
        ((e)localObject1).kGS = null;
        aWZ().kGy = null;
        kGB = null;
      }
      return;
    }
    finally {}
  }
  
  public static void y(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    aWZ().kGz = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */