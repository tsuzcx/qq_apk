package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qg;
import com.tencent.mm.d.a;
import com.tencent.mm.d.a.a;
import com.tencent.mm.patchligthdiff.ApkPatch;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import java.io.File;

public final class c
{
  public static int a(String paramString1, String paramString2, String paramString3, b paramb)
  {
    AppMethodBeat.i(261824);
    Object localObject;
    File localFile2;
    File localFile1;
    long l;
    int i;
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      try
      {
        y.bDX(y.bEo(paramString3));
        localObject = new File(paramString1);
        localFile2 = new File(paramString3);
        localFile1 = new File(paramString2);
        d.iH(MMApplicationContext.getContext());
        String str = y.bEo(paramString3) + "/" + localFile2.getName() + "_tmp";
        localFile2.deleteOnExit();
        if ((!((File)localObject).exists()) || (!localFile1.exists())) {
          break label1226;
        }
        if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion <= 29)
        {
          localObject = a.hY(paramString1);
          if ((localObject != null) && (((a)localObject).hel != null)) {
            Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk:extLen = %d", new Object[] { Integer.valueOf(((a)localObject).hel.heo + 8) });
          }
        }
        l = System.currentTimeMillis();
        i = ApkPatch.patch(paramString1, paramString2, paramString3, 10485760L, str, 4);
        l = (System.currentTimeMillis() - l) / 1000L;
        localFile1.length();
        if (l > 5L) {
          break label402;
        }
        h.OAn.idkeyStat(614L, 131L, 1L, false);
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          h.OAn.idkeyStat(614L, 201L, 1L, false);
          Log.printErrStackTrace("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", paramString1, ".HdiffApk merge apk failed.", new Object[0]);
          AppMethodBeat.o(261824);
          return -6;
          if (l > 20L) {
            break;
          }
          h.OAn.idkeyStat(614L, 133L, 1L, false);
        }
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", paramString1, ".HdiffApk merge apk failed.", new Object[0]);
        AppMethodBeat.o(261824);
        return -4;
      }
      Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog statusCode = %s.", new Object[] { Integer.valueOf(i) });
      if (i == 0) {
        break label1325;
      }
      h.OAn.idkeyStat(614L, 150L, 1L, false);
      Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = common error");
      break label1325;
    }
    for (;;)
    {
      Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = others");
      h.OAn.idkeyStat(614L, 192L, 1L, false);
      for (;;)
      {
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.HdiffApk:statusCode = %d， stayTime= %d", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
        if ((i == 17) || (i == 14) || (i == 22) || (i == 23)) {
          Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "HdiffApk happen check crc error, deleteNewApkFile, delete? success = ".concat(String.valueOf(y.deleteFile(paramString3))));
        }
        if (i == 0) {
          break label1176;
        }
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
        AppMethodBeat.o(261824);
        return i;
        label402:
        if (l <= 10L)
        {
          h.OAn.idkeyStat(614L, 132L, 1L, false);
          break;
        }
        if (l <= 40L)
        {
          h.OAn.idkeyStat(614L, 134L, 1L, false);
          break;
        }
        h.OAn.idkeyStat(614L, 135L, 1L, false);
        break;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_SUCCESS");
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENREAD_ERROR");
        h.OAn.idkeyStat(614L, 151L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENWRITE_ERROR");
        h.OAn.idkeyStat(614L, 152L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENWRITE_ERROR");
        h.OAn.idkeyStat(614L, 153L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_CLOSEFILE_ERROR");
        h.OAn.idkeyStat(614L, 154L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_MEM_ERROR");
        h.OAn.idkeyStat(614L, 155L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_HDIFFINFO_ERROR");
        h.OAn.idkeyStat(614L, 156L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_COMPRESSTYPE_ERROR");
        h.OAn.idkeyStat(614L, 157L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_ZIPPATCH_ERROR");
        h.OAn.idkeyStat(614L, 158L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_ZIPDIFFINFO_ERROR");
        h.OAn.idkeyStat(614L, 159L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OLDDECOMPRESS_ERROR");
        h.OAn.idkeyStat(614L, 160L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OLDSTREAM_ERROR");
        h.OAn.idkeyStat(614L, 161L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_NEWSTREAM_ERROR");
        h.OAn.idkeyStat(614L, 162L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_FILE_OPENREAD_ERROR_INPUT_OPEN");
        h.OAn.idkeyStat(614L, 163L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_FILE_OPENREAD_ERROR_OPEN_STREAM");
        h.OAn.idkeyStat(614L, 164L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENREAD_ERROR_OLDZIPPATH");
        h.OAn.idkeyStat(614L, 165L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENREAD_ERROR_OLDZIP_STREAM");
        h.OAn.idkeyStat(614L, 166L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OPENREAD_ERROR_NEW_ZIP_RESULT");
        h.OAn.idkeyStat(614L, 167L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OLDDATA_ERROR_CESIZE");
        h.OAn.idkeyStat(614L, 168L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OLDDATA_ERROR_OLDCRC");
        h.OAn.idkeyStat(614L, 169L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_OLDDATA_ERROR_STREAMSIZE");
        h.OAn.idkeyStat(614L, 170L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_HPATCH_ERROR");
        h.OAn.idkeyStat(614L, 171L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_CHECKCRC_ERROR");
        h.OAn.idkeyStat(614L, 172L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_CHECKCRC_STREAM_ERROR");
        h.OAn.idkeyStat(614L, 173L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_VIRTUAL_IN_BEGIN_ERROR");
        h.OAn.idkeyStat(614L, 190L, 1L, false);
        continue;
        Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk.HdiffApk: reportErrorLog status = PATCH_VIRTUAL_IN_END_ERROR");
        h.OAn.idkeyStat(614L, 191L, 1L, false);
      }
      label1176:
      Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "HdiffApk response.newApkMd5:%s file md5:%s", new Object[] { paramb.JEL, y.bub(paramString3) });
      paramb.JEL = y.bub(paramString3);
      new File(paramString3);
      AppMethodBeat.o(261824);
      return 0;
      label1226:
      if (!localFile1.exists()) {
        h.OAn.idkeyStat(614L, 174L, 1L, false);
      }
      for (;;)
      {
        Log.e("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "MicroMsg.MergePatchApk:.HdiffApk file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[] { Boolean.valueOf(((File)localObject).exists()), Boolean.valueOf(localFile2.exists()), Boolean.valueOf(localFile1.exists()) });
        AppMethodBeat.o(261824);
        return -1;
        h.OAn.idkeyStat(614L, 175L, 1L, false);
      }
      AppMethodBeat.o(261824);
      return -5;
      label1325:
      switch (i)
      {
      }
    }
  }
  
  public static boolean fPG()
  {
    AppMethodBeat.i(261825);
    i locali = i.agtt;
    if (i.a(b.a.agrP, 0) == 1)
    {
      AppMethodBeat.o(261825);
      return true;
    }
    AppMethodBeat.o(261825);
    return false;
  }
  
  public static boolean fPH()
  {
    AppMethodBeat.i(261828);
    i locali = i.agtt;
    if (i.a(b.a.agrQ, 0) == 1)
    {
      AppMethodBeat.o(261828);
      return true;
    }
    AppMethodBeat.o(261828);
    return false;
  }
  
  public static boolean fPI()
  {
    AppMethodBeat.i(261832);
    i locali = i.agtt;
    if (i.a(b.a.agrR, 0) == 1)
    {
      AppMethodBeat.o(261832);
      return true;
    }
    AppMethodBeat.o(261832);
    return false;
  }
  
  /* Error */
  public static boolean jD(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: ldc_w 365
    //   9: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   16: ifeq +11 -> 27
    //   19: ldc_w 365
    //   22: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: new 29	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 72	java/io/File:exists	()Z
    //   40: ifne +11 -> 51
    //   43: ldc_w 365
    //   46: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: invokestatic 373	com/tencent/mm/plugin/hp/b/d:fQv	()Ljava/lang/String;
    //   54: invokestatic 27	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   57: istore_2
    //   58: aload_1
    //   59: invokestatic 174	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   62: istore_3
    //   63: aload_1
    //   64: invokestatic 376	com/tencent/mm/vfs/y:bEp	(Ljava/lang/String;)Z
    //   67: istore 4
    //   69: ldc 96
    //   71: new 47	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 378
    //   78: invokespecial 379	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 381
    //   88: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_2
    //   92: invokevirtual 384	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: ldc_w 386
    //   98: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload_3
    //   102: invokevirtual 384	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: ldc_w 388
    //   108: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 384	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: new 390	java/io/FileInputStream
    //   125: dup
    //   126: aload_0
    //   127: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: astore 6
    //   132: new 395	java/io/FileOutputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 396	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   140: astore_0
    //   141: aload 6
    //   143: invokevirtual 400	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   146: astore 7
    //   148: aload_0
    //   149: invokevirtual 401	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   152: astore 5
    //   154: aload 5
    //   156: aload 7
    //   158: lconst_0
    //   159: aload 7
    //   161: invokevirtual 406	java/nio/channels/FileChannel:size	()J
    //   164: lconst_0
    //   165: lsub
    //   166: invokevirtual 410	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   169: pop2
    //   170: aload 6
    //   172: invokevirtual 413	java/io/FileInputStream:close	()V
    //   175: aload_0
    //   176: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   179: aload_0
    //   180: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   183: aload 5
    //   185: ifnull +8 -> 193
    //   188: aload 5
    //   190: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   193: aload 7
    //   195: ifnull +8 -> 203
    //   198: aload 7
    //   200: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   203: new 29	java/io/File
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore 6
    //   213: aload 6
    //   215: invokevirtual 133	java/io/File:length	()J
    //   218: lconst_0
    //   219: lcmp
    //   220: ifgt +161 -> 381
    //   223: ldc 96
    //   225: ldc_w 420
    //   228: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: ldc_w 365
    //   234: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore 8
    //   241: aconst_null
    //   242: astore_0
    //   243: aconst_null
    //   244: astore 7
    //   246: aconst_null
    //   247: astore 5
    //   249: aconst_null
    //   250: astore 6
    //   252: ldc 96
    //   254: ldc_w 422
    //   257: aload 8
    //   259: invokestatic 425	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   265: invokestatic 427	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 6
    //   270: ifnull +8 -> 278
    //   273: aload 6
    //   275: invokevirtual 413	java/io/FileInputStream:close	()V
    //   278: aload 5
    //   280: ifnull +13 -> 293
    //   283: aload 5
    //   285: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   288: aload 5
    //   290: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   301: aload 7
    //   303: ifnull -100 -> 203
    //   306: aload 7
    //   308: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   311: goto -108 -> 203
    //   314: astore_0
    //   315: goto -112 -> 203
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_0
    //   321: aconst_null
    //   322: astore 7
    //   324: aconst_null
    //   325: astore 5
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 6
    //   332: ifnull +8 -> 340
    //   335: aload 6
    //   337: invokevirtual 413	java/io/FileInputStream:close	()V
    //   340: aload 5
    //   342: ifnull +13 -> 355
    //   345: aload 5
    //   347: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   350: aload 5
    //   352: invokevirtual 417	java/io/FileOutputStream:close	()V
    //   355: aload_0
    //   356: ifnull +7 -> 363
    //   359: aload_0
    //   360: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   363: aload 7
    //   365: ifnull +8 -> 373
    //   368: aload 7
    //   370: invokevirtual 418	java/nio/channels/FileChannel:close	()V
    //   373: ldc_w 365
    //   376: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_1
    //   380: athrow
    //   381: aload 11
    //   383: astore_0
    //   384: new 429	java/io/RandomAccessFile
    //   387: dup
    //   388: aload 6
    //   390: ldc_w 431
    //   393: invokespecial 434	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   396: astore_1
    //   397: aload_1
    //   398: aload 6
    //   400: invokevirtual 133	java/io/File:length	()J
    //   403: ldc2_w 435
    //   406: lsub
    //   407: invokevirtual 440	java/io/RandomAccessFile:seek	(J)V
    //   410: aload_1
    //   411: iconst_2
    //   412: newarray byte
    //   414: dup
    //   415: iconst_0
    //   416: ldc_w 441
    //   419: bastore
    //   420: dup
    //   421: iconst_1
    //   422: ldc_w 441
    //   425: bastore
    //   426: invokevirtual 445	java/io/RandomAccessFile:write	([B)V
    //   429: aload_1
    //   430: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   433: ldc 96
    //   435: new 47	java/lang/StringBuilder
    //   438: dup
    //   439: ldc_w 448
    //   442: invokespecial 379	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   445: aload 6
    //   447: invokevirtual 133	java/io/File:length	()J
    //   450: invokevirtual 451	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   453: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 365
    //   462: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iconst_1
    //   466: ireturn
    //   467: astore_0
    //   468: ldc 96
    //   470: ldc_w 453
    //   473: aload_0
    //   474: invokestatic 425	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   477: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   480: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: goto -50 -> 433
    //   486: astore 5
    //   488: aload 10
    //   490: astore_1
    //   491: aload_1
    //   492: astore_0
    //   493: ldc 96
    //   495: ldc_w 453
    //   498: aload 5
    //   500: invokestatic 425	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   503: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload_1
    //   510: ifnull -77 -> 433
    //   513: aload_1
    //   514: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   517: goto -84 -> 433
    //   520: astore_0
    //   521: ldc 96
    //   523: ldc_w 453
    //   526: aload_0
    //   527: invokestatic 425	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   530: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   533: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto -103 -> 433
    //   539: astore 5
    //   541: aload_0
    //   542: astore_1
    //   543: aload 5
    //   545: astore_0
    //   546: aload_1
    //   547: ifnull +7 -> 554
    //   550: aload_1
    //   551: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   554: ldc_w 365
    //   557: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   560: aload_0
    //   561: athrow
    //   562: astore_1
    //   563: ldc 96
    //   565: ldc_w 453
    //   568: aload_1
    //   569: invokestatic 425	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   575: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -24 -> 554
    //   581: astore 6
    //   583: goto -408 -> 175
    //   586: astore_0
    //   587: goto -394 -> 193
    //   590: astore_0
    //   591: goto -388 -> 203
    //   594: astore 6
    //   596: goto -318 -> 278
    //   599: astore_0
    //   600: goto -299 -> 301
    //   603: astore 6
    //   605: goto -265 -> 340
    //   608: astore_0
    //   609: goto -246 -> 363
    //   612: astore_0
    //   613: goto -240 -> 373
    //   616: astore_0
    //   617: goto -71 -> 546
    //   620: astore 5
    //   622: goto -131 -> 491
    //   625: astore 5
    //   627: goto -272 -> 355
    //   630: astore_1
    //   631: aconst_null
    //   632: astore_0
    //   633: aconst_null
    //   634: astore 7
    //   636: aconst_null
    //   637: astore 5
    //   639: goto -309 -> 330
    //   642: astore_1
    //   643: aconst_null
    //   644: astore 8
    //   646: aconst_null
    //   647: astore 7
    //   649: aload_0
    //   650: astore 5
    //   652: aload 8
    //   654: astore_0
    //   655: goto -325 -> 330
    //   658: astore_1
    //   659: aconst_null
    //   660: astore 8
    //   662: aload_0
    //   663: astore 5
    //   665: aload 8
    //   667: astore_0
    //   668: goto -338 -> 330
    //   671: astore_1
    //   672: aload_0
    //   673: astore 8
    //   675: aload 5
    //   677: astore_0
    //   678: aload 8
    //   680: astore 5
    //   682: goto -352 -> 330
    //   685: astore_1
    //   686: goto -356 -> 330
    //   689: astore 5
    //   691: goto -398 -> 293
    //   694: astore 8
    //   696: aconst_null
    //   697: astore_0
    //   698: aconst_null
    //   699: astore 7
    //   701: aconst_null
    //   702: astore 5
    //   704: goto -452 -> 252
    //   707: astore 8
    //   709: aconst_null
    //   710: astore 9
    //   712: aconst_null
    //   713: astore 7
    //   715: aload_0
    //   716: astore 5
    //   718: aload 9
    //   720: astore_0
    //   721: goto -469 -> 252
    //   724: astore 8
    //   726: aconst_null
    //   727: astore 9
    //   729: aload_0
    //   730: astore 5
    //   732: aload 9
    //   734: astore_0
    //   735: goto -483 -> 252
    //   738: astore 8
    //   740: aload_0
    //   741: astore 9
    //   743: aload 5
    //   745: astore_0
    //   746: aload 9
    //   748: astore 5
    //   750: goto -498 -> 252
    //   753: astore_0
    //   754: goto -571 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	757	0	paramString1	String
    //   0	757	1	paramString2	String
    //   57	35	2	bool1	boolean
    //   62	40	3	bool2	boolean
    //   67	45	4	bool3	boolean
    //   152	199	5	localFileChannel1	java.nio.channels.FileChannel
    //   486	13	5	localException1	Exception
    //   539	5	5	localObject1	Object
    //   620	1	5	localException2	Exception
    //   625	1	5	localException3	Exception
    //   637	44	5	localObject2	Object
    //   689	1	5	localException4	Exception
    //   702	47	5	localObject3	Object
    //   130	316	6	localObject4	Object
    //   581	1	6	localException5	Exception
    //   594	1	6	localException6	Exception
    //   603	1	6	localException7	Exception
    //   146	568	7	localFileChannel2	java.nio.channels.FileChannel
    //   239	19	8	localException8	Exception
    //   644	35	8	str1	String
    //   694	1	8	localException9	Exception
    //   707	1	8	localException10	Exception
    //   724	1	8	localException11	Exception
    //   738	1	8	localException12	Exception
    //   710	37	9	str2	String
    //   4	485	10	localObject5	Object
    //   1	381	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   51	132	239	java/lang/Exception
    //   306	311	314	java/lang/Exception
    //   51	132	318	finally
    //   429	433	467	java/lang/Exception
    //   384	397	486	java/lang/Exception
    //   513	517	520	java/lang/Exception
    //   384	397	539	finally
    //   493	509	539	finally
    //   550	554	562	java/lang/Exception
    //   170	175	581	java/lang/Exception
    //   188	193	586	java/lang/Exception
    //   198	203	590	java/lang/Exception
    //   273	278	594	java/lang/Exception
    //   297	301	599	java/lang/Exception
    //   335	340	603	java/lang/Exception
    //   359	363	608	java/lang/Exception
    //   368	373	612	java/lang/Exception
    //   397	429	616	finally
    //   397	429	620	java/lang/Exception
    //   345	355	625	java/lang/Exception
    //   132	141	630	finally
    //   141	148	642	finally
    //   148	154	658	finally
    //   154	170	671	finally
    //   252	268	685	finally
    //   283	293	689	java/lang/Exception
    //   132	141	694	java/lang/Exception
    //   141	148	707	java/lang/Exception
    //   148	154	724	java/lang/Exception
    //   154	170	738	java/lang/Exception
    //   175	183	753	java/lang/Exception
  }
  
  public static void t(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(261838);
    qg localqg = new qg();
    localqg.jrl = paramInt1;
    localqg.jrk = 1L;
    localqg.jrm = paramInt2;
    localqg.jrn = paramLong;
    localqg.bMH();
    Log.i("MicroMsg.Tinker.MergeHDiffApk.HdiffApk", "report logbuffer(23550): [scene]: %s, mergeCode: %s, staytime: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(261838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.c
 * JD-Core Version:    0.7.0.1
 */