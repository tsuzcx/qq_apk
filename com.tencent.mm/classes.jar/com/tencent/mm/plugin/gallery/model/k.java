package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class k
  implements g
{
  private static int kGZ = 100;
  public static String kHh = "date_added";
  public static String kHi = "datetaken";
  public static String kHj = "date_mix";
  protected ContentResolver eRr = this.mContext.getContentResolver();
  private boolean kHk = false;
  boolean kHl = false;
  protected Context mContext = ae.getContext();
  long start = 0L;
  
  protected static long dn(String paramString1, String paramString2)
  {
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    long l1 = l2;
    if (!bk.bl(paramString1)) {
      l1 = l2;
    }
    for (;;)
    {
      try
      {
        l2 = TimeUnit.MILLISECONDS.convert(bk.getLong(paramString1, 0L), TimeUnit.MILLISECONDS);
        l1 = l2;
        if (l2 <= l3)
        {
          l1 = l2;
          long l4 = l3 / 1000L;
          l1 = l2;
          if (l2 >= l4) {
            return l2;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        y.printErrStackTrace("MicroMsg.MediaQueryBase", paramString1, "", new Object[0]);
      }
      l2 = l1;
      if (!bk.bl(paramString2)) {
        try
        {
          l2 = TimeUnit.MILLISECONDS.convert(bk.getLong(paramString2, 0L), TimeUnit.SECONDS);
          l1 = l2;
          l2 = l1;
          if (l1 <= l3) {
            return l1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          y.printErrStackTrace("MicroMsg.MediaQueryBase", paramString1, "", new Object[0]);
        }
      }
    }
    return l1;
  }
  
  protected abstract String Eq(String paramString);
  
  /* Error */
  public final ArrayList<GalleryItem.MediaItem> a(String paramString, int paramInt, g.c paramc, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   4: putfield 47	com/tencent/mm/plugin/gallery/model/k:start	J
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 43	com/tencent/mm/plugin/gallery/model/k:kHk	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: aload_1
    //   18: iload_2
    //   19: aload_3
    //   20: lload 4
    //   22: invokevirtual 115	com/tencent/mm/plugin/gallery/model/k:b	(Ljava/lang/String;ILcom/tencent/mm/plugin/gallery/model/g$c;J)Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 43	com/tencent/mm/plugin/gallery/model/k:kHk	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc 97
    //   37: ldc 117
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   48: aload_0
    //   49: getfield 47	com/tencent/mm/plugin/gallery/model/k:start	J
    //   52: lsub
    //   53: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: aastore
    //   57: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	k
    //   0	72	1	paramString	String
    //   0	72	2	paramInt	int
    //   0	72	3	paramc	g.c
    //   0	72	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   9	16	62	finally
    //   63	65	62	finally
    //   28	35	67	finally
    //   68	70	67	finally
  }
  
  protected abstract String aXA();
  
  protected final boolean aXC()
  {
    try
    {
      boolean bool = this.kHl;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<GalleryItem.AlbumItem> aXv()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      Cursor localCursor = this.eRr.query(aXx(), getProjection(), getSelection(), null, aXz());
      if (localCursor == null)
      {
        y.d("MicroMsg.MediaQueryBase", "no media folder now");
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MediaQueryBase", "query album list failed : [%s]", new Object[] { localException.getMessage() });
        localObject1 = null;
      }
    }
    if (localObject1.moveToFirst()) {}
    for (;;)
    {
      Object localObject2 = Long.valueOf(0L);
      try
      {
        long l = bk.getLong(localObject1.getString(localObject1.getColumnIndexOrThrow("_id")), 0L);
        localObject2 = Long.valueOf(l);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        String str1;
        String str2;
        break label120;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label120:
        break label120;
      }
      str1 = localObject1.getString(localObject1.getColumnIndexOrThrow("_data"));
      str2 = localObject1.getString(localObject1.getColumnIndexOrThrow(aXA()));
      if ((bk.bl(str2)) && (getType() == 2)) {
        y.e("MicroMsg.MediaQueryBase", "null or nill album name, ignore this folder");
      }
      while (!localObject1.moveToNext())
      {
        localObject1.close();
        return localArrayList;
        int i = localObject1.getInt(3);
        y.i("MicroMsg.MediaQueryBase", str1 + "====" + str2 + "=====" + localObject2 + ", " + i);
        if ((i == 0) || ((bk.bl(str1)) && (bk.bl(null))))
        {
          y.e("MicroMsg.MediaQueryBase", "query album failed, " + i + ", " + str1 + "," + null);
        }
        else
        {
          Object localObject3;
          if (!bk.bl(str1))
          {
            localObject3 = str1;
            if (e.bK(str1)) {}
          }
          else
          {
            localObject3 = null;
          }
          if (!bk.bl(null)) {
            e.bK(null);
          }
          if (localObject3 == null)
          {
            y.e("MicroMsg.MediaQueryBase", "this item has no thumb path and orignal path");
          }
          else
          {
            str1 = localObject1.getString(localObject1.getColumnIndexOrThrow("mime_type"));
            localObject2 = GalleryItem.MediaItem.a(getType(), ((Long)localObject2).longValue(), (String)localObject3, null, str1);
            localObject3 = new GalleryItem.AlbumItem(str2, i);
            ((GalleryItem.AlbumItem)localObject3).kGU = ((GalleryItem.MediaItem)localObject2);
            localArrayList.add(localObject3);
          }
        }
      }
    }
  }
  
  public final void aXw()
  {
    try
    {
      if (this.kHk) {
        this.kHl = true;
      }
      return;
    }
    finally {}
  }
  
  protected abstract Uri aXx();
  
  protected abstract String[] aXy();
  
  protected abstract String aXz();
  
  public ArrayList<GalleryItem.MediaItem> b(String paramString, int paramInt, g.c paramc, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      Cursor localCursor = this.eRr.query(aXx(), aXy(), Eq(paramString), null, aXz());
      if (localCursor == null)
      {
        y.d("MicroMsg.MediaQueryBase", "query album failed: " + paramString);
        if (paramc != null) {
          paramc.a(localArrayList, paramLong);
        }
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MediaQueryBase", "query media items in album failed : [%s]", new Object[] { localException.getMessage() });
        localObject1 = null;
      }
      paramInt = 0;
      if (!localObject1.moveToFirst()) {}
    }
    label153:
    label736:
    for (;;)
    {
      paramString = Long.valueOf(0L);
      try
      {
        l = bk.getLong(localObject1.getString(localObject1.getColumnIndexOrThrow("_id")), 0L);
        paramString = Long.valueOf(l);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        long l;
        String str1;
        String str2;
        String str3;
        Object localObject2;
        break label153;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          continue;
          paramInt = 0;
        }
      }
      str1 = localObject1.getString(localObject1.getColumnIndexOrThrow("_data"));
      str2 = localObject1.getString(localObject1.getColumnIndexOrThrow(kHj));
      l = localObject1.getLong(localObject1.getColumnIndexOrThrow(kHj));
      str3 = localObject1.getString(localObject1.getColumnIndexOrThrow(kHh));
      localObject2 = localObject1.getString(localObject1.getColumnIndexOrThrow(kHi));
      if ((str2 == null) || (str2.equals("")) || (str2.equals(Integer.valueOf(0))))
      {
        h.nFQ.a(363L, 1L, 1L, true);
        if (0L != l) {
          h.nFQ.a(363L, 4L, 1L, true);
        }
        if (((str3 == null) || (str3.equals("")) || (str3.equals(Integer.valueOf(0)))) && (localObject2 != null) && (!((String)localObject2).equals("")) && (!((String)localObject2).equals(Integer.valueOf(0)))) {
          h.nFQ.a(363L, 3L, 1L, true);
        }
        if (((localObject2 == null) || (((String)localObject2).equals("")) || (((String)localObject2).equals(Integer.valueOf(0)))) && (str3 != null) && (!str3.equals("")) && (!str3.equals(Integer.valueOf(0)))) {
          h.nFQ.a(363L, 2L, 1L, true);
        }
        localObject2 = GalleryItem.MediaItem.B(getType(), paramString.longValue());
        if ((!bk.bl(str1)) && (new File(str1).exists())) {
          ((GalleryItem.MediaItem)localObject2).eAu = str1;
        }
        ((GalleryItem.MediaItem)localObject2).kGY = dn(str2, str3);
        if ((!bk.bl(((GalleryItem.MediaItem)localObject2).eAu)) || (!bk.bl(((GalleryItem.MediaItem)localObject2).jSX))) {
          break label656;
        }
        y.e("MicroMsg.MediaQueryBase", "thumb file and orignal file both not exist");
      }
      for (paramInt = 0;; paramInt = 1)
      {
        if (localObject1.moveToNext()) {
          break label736;
        }
        localObject1.close();
        if ((paramInt == 0) && (paramc != null)) {
          paramc.a(localArrayList, paramLong);
        }
        return localArrayList;
        if ((localObject2 == null) || (((String)localObject2).equals("")) || (((String)localObject2).equals(Integer.valueOf(0))))
        {
          h.nFQ.a(363L, 6L, 1L, true);
          break;
        }
        if ((str3 != null) && (!str3.equals("")) && (!str3.equals(Integer.valueOf(0)))) {
          break;
        }
        h.nFQ.a(363L, 5L, 1L, true);
        break;
        str1 = localObject1.getString(localObject1.getColumnIndexOrThrow("mime_type"));
        paramString = str1;
        if (bk.bl(str1)) {
          paramString = "";
        }
        ((GalleryItem.MediaItem)localObject2).mMimeType = paramString;
        localArrayList.add(localObject2);
        if ((localArrayList.size() % kGZ != 0) || (paramc == null)) {
          break label748;
        }
        paramc.a(localArrayList, paramLong);
        localArrayList.clear();
      }
    }
  }
  
  protected abstract String[] getProjection();
  
  protected abstract String getSelection();
  
  protected abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.k
 * JD-Core Version:    0.7.0.1
 */