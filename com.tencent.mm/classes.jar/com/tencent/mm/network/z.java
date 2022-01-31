package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class z
{
  final z.a[] eOG = new z.a[100];
  
  final boolean Ui()
  {
    z.a[] arrayOfa = this.eOG;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.eOG[i] != null) && ((701 == this.eOG[i].eOK.getType()) || (702 == this.eOG[i].eOK.getType())))
        {
          y.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.eOG[i].eOK.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.eOG[i] = null;
        y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bk.j(localRemoteException), Integer.valueOf(i) });
        break label156;
        return false;
      }
      finally {}
      label156:
      i += 1;
    }
  }
  
  final boolean Uj()
  {
    z.a[] arrayOfa = this.eOG;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.eOG[i] != null) && (1000 == this.eOG[i].eOK.getType()))
        {
          y.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.eOG[i].eOK.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.eOG[i] = null;
        y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bk.j(localRemoteException), Integer.valueOf(i) });
        break label136;
        return false;
      }
      finally {}
      label136:
      i += 1;
    }
  }
  
  public final int Uk()
  {
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i >= 100) {
        return j;
      }
      k = j;
      try
      {
        if (this.eOG[i] != null)
        {
          this.eOG[i].eOK.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bk.j(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.eOG[i] = null;
        }
      }
      i += 1;
    }
    return j;
  }
  
  /* Error */
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 87	com/tencent/mm/network/z:jF	(I)I
    //   14: istore 5
    //   16: iconst_m1
    //   17: iload 5
    //   19: if_icmpne +8 -> 27
    //   22: aload 7
    //   24: monitorexit
    //   25: iconst_m1
    //   26: ireturn
    //   27: getstatic 93	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_DEFAULT	I
    //   30: istore_1
    //   31: aload_0
    //   32: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   35: iload 5
    //   37: aaload
    //   38: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   41: invokeinterface 97 1 0
    //   46: invokeinterface 103 1 0
    //   51: astore 8
    //   53: aload_0
    //   54: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   57: iload 5
    //   59: aaload
    //   60: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   63: invokeinterface 107 1 0
    //   68: astore 9
    //   70: aload 9
    //   72: aload_0
    //   73: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   76: iload 5
    //   78: aaload
    //   79: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   82: invokeinterface 29 1 0
    //   87: aload_2
    //   88: aload 8
    //   90: invokeinterface 112 4 0
    //   95: ifeq +264 -> 359
    //   98: aload 9
    //   100: invokeinterface 115 1 0
    //   105: istore 5
    //   107: aload 4
    //   109: iconst_0
    //   110: iconst_0
    //   111: iastore
    //   112: iload 5
    //   114: iconst_2
    //   115: iand
    //   116: ifne +25 -> 141
    //   119: aload 4
    //   121: iconst_0
    //   122: aload 4
    //   124: iconst_0
    //   125: iaload
    //   126: iconst_2
    //   127: ior
    //   128: iastore
    //   129: getstatic 121	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   132: ldc2_w 122
    //   135: lconst_0
    //   136: lconst_1
    //   137: iconst_0
    //   138: invokevirtual 126	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   141: iload 5
    //   143: iconst_4
    //   144: iand
    //   145: ifne +25 -> 170
    //   148: aload 4
    //   150: iconst_0
    //   151: aload 4
    //   153: iconst_0
    //   154: iaload
    //   155: iconst_4
    //   156: ior
    //   157: iastore
    //   158: getstatic 121	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   161: ldc2_w 122
    //   164: lconst_1
    //   165: lconst_1
    //   166: iconst_0
    //   167: invokevirtual 126	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   170: aload 9
    //   172: invokeinterface 129 1 0
    //   177: ifnull +28 -> 205
    //   180: bipush 243
    //   182: aload 9
    //   184: invokeinterface 132 1 0
    //   189: if_icmpne +16 -> 205
    //   192: invokestatic 138	com/tencent/mm/network/aa:Uu	()Lcom/tencent/mm/network/t;
    //   195: ifnull +10 -> 205
    //   198: invokestatic 138	com/tencent/mm/network/aa:Uu	()Lcom/tencent/mm/network/t;
    //   201: invokevirtual 143	com/tencent/mm/network/t:TY	()Z
    //   204: pop
    //   205: bipush 243
    //   207: aload 9
    //   209: invokeinterface 132 1 0
    //   214: if_icmpne +39 -> 253
    //   217: getstatic 146	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   220: istore 6
    //   222: iload 6
    //   224: istore_1
    //   225: iload 6
    //   227: istore 5
    //   229: aload_3
    //   230: iconst_0
    //   231: aload 9
    //   233: invokeinterface 132 1 0
    //   238: iastore
    //   239: iload 6
    //   241: istore_1
    //   242: aload 7
    //   244: monitorexit
    //   245: iload_1
    //   246: ireturn
    //   247: astore_2
    //   248: aload 7
    //   250: monitorexit
    //   251: aload_2
    //   252: athrow
    //   253: sipush -3002
    //   256: aload 9
    //   258: invokeinterface 132 1 0
    //   263: if_icmpeq +16 -> 279
    //   266: sipush -3003
    //   269: aload 9
    //   271: invokeinterface 132 1 0
    //   276: if_icmpne +31 -> 307
    //   279: getstatic 149	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_TASK_END	I
    //   282: istore 6
    //   284: iload 6
    //   286: istore_1
    //   287: iload 6
    //   289: istore 5
    //   291: aload_3
    //   292: iconst_0
    //   293: aload 9
    //   295: invokeinterface 132 1 0
    //   300: iastore
    //   301: iload 6
    //   303: istore_1
    //   304: goto -62 -> 242
    //   307: sipush -3001
    //   310: aload 9
    //   312: invokeinterface 132 1 0
    //   317: if_icmpne +31 -> 348
    //   320: getstatic 146	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   323: istore 6
    //   325: iload 6
    //   327: istore_1
    //   328: iload 6
    //   330: istore 5
    //   332: aload_3
    //   333: iconst_0
    //   334: aload 9
    //   336: invokeinterface 132 1 0
    //   341: iastore
    //   342: iload 6
    //   344: istore_1
    //   345: goto -103 -> 242
    //   348: getstatic 152	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_NORMAL	I
    //   351: istore 5
    //   353: iload 5
    //   355: istore_1
    //   356: goto -114 -> 242
    //   359: getstatic 121	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   362: ldc2_w 153
    //   365: ldc2_w 155
    //   368: lconst_1
    //   369: iconst_0
    //   370: invokevirtual 126	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   373: ldc 31
    //   375: ldc 158
    //   377: invokestatic 160	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: goto -138 -> 242
    //   383: astore_2
    //   384: getstatic 121	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   387: ldc2_w 153
    //   390: ldc2_w 161
    //   393: lconst_1
    //   394: iconst_0
    //   395: invokevirtual 126	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   398: ldc 31
    //   400: ldc 164
    //   402: iconst_1
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: aload_2
    //   409: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   412: aastore
    //   413: invokestatic 75	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: goto -174 -> 242
    //   419: getstatic 121	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
    //   422: ldc2_w 153
    //   425: ldc2_w 165
    //   428: lconst_1
    //   429: iconst_0
    //   430: invokevirtual 126	com/tencent/mm/plugin/report/f:a	(JJJZ)V
    //   433: ldc 31
    //   435: ldc 164
    //   437: iconst_1
    //   438: anewarray 4	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload_2
    //   444: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   447: aastore
    //   448: invokestatic 75	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: goto -209 -> 242
    //   454: astore_2
    //   455: goto -36 -> 419
    //   458: astore_2
    //   459: iload 5
    //   461: istore_1
    //   462: goto -78 -> 384
    //   465: astore_2
    //   466: goto -47 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	z
    //   0	469	1	paramInt	int
    //   0	469	2	paramArrayOfByte	byte[]
    //   0	469	3	paramArrayOfInt1	int[]
    //   0	469	4	paramArrayOfInt2	int[]
    //   14	446	5	i	int
    //   220	123	6	j	int
    //   4	245	7	arrayOfa	z.a[]
    //   51	38	8	arrayOfByte	byte[]
    //   68	267	9	localh	com.tencent.mm.protocal.h
    // Exception table:
    //   from	to	target	type
    //   9	16	247	finally
    //   22	25	247	finally
    //   27	31	247	finally
    //   31	107	247	finally
    //   129	141	247	finally
    //   158	170	247	finally
    //   170	205	247	finally
    //   205	222	247	finally
    //   229	239	247	finally
    //   242	245	247	finally
    //   248	251	247	finally
    //   253	279	247	finally
    //   279	284	247	finally
    //   291	301	247	finally
    //   307	325	247	finally
    //   332	342	247	finally
    //   348	353	247	finally
    //   359	380	247	finally
    //   384	416	247	finally
    //   419	451	247	finally
    //   31	107	383	android/os/RemoteException
    //   129	141	383	android/os/RemoteException
    //   158	170	383	android/os/RemoteException
    //   170	205	383	android/os/RemoteException
    //   205	222	383	android/os/RemoteException
    //   253	279	383	android/os/RemoteException
    //   279	284	383	android/os/RemoteException
    //   307	325	383	android/os/RemoteException
    //   348	353	383	android/os/RemoteException
    //   359	380	383	android/os/RemoteException
    //   229	239	454	java/lang/Exception
    //   291	301	454	java/lang/Exception
    //   332	342	454	java/lang/Exception
    //   229	239	458	android/os/RemoteException
    //   291	301	458	android/os/RemoteException
    //   332	342	458	android/os/RemoteException
    //   31	107	465	java/lang/Exception
    //   129	141	465	java/lang/Exception
    //   158	170	465	java/lang/Exception
    //   170	205	465	java/lang/Exception
    //   205	222	465	java/lang/Exception
    //   253	279	465	java/lang/Exception
    //   279	284	465	java/lang/Exception
    //   307	325	465	java/lang/Exception
    //   348	353	465	java/lang/Exception
    //   359	380	465	java/lang/Exception
  }
  
  public final int a(r paramr, l paraml, c paramc, int paramInt)
  {
    if (paramr == null)
    {
      y.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      return -1;
    }
    paramr.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    z.a[] arrayOfa = this.eOG;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      for (;;)
      {
        try
        {
          if (this.eOG[i] != null) {
            break;
          }
          this.eOG[i] = new z.a(0);
          this.eOG[i].eOK = paramr;
          this.eOG[i].eOL = paraml;
          this.eOG[i].eOM = paramc;
          this.eOG[i].startTime = bk.UY();
          this.eOG[i].taskId = localTask.taskID;
          localTask.cmdID = paramr.Lc().getCmdId();
          localTask.cgi = paramr.getUri();
          int j = paramr.getType();
          boolean bool;
          if ((paramr.Kq() & 0x1) != 1)
          {
            bool = true;
            localTask.needAuthed = bool;
            if ((j == 126) || (j == 701) || (j == 702))
            {
              localTask.needAuthed = false;
              if (j == 701) {
                localTask.retryCount = 1;
              }
            }
            localTask.limitFlow = true;
            if ((j == 149) || (j == 193) || (j == 220) || (j == 323) || (j == 324) || (j == 326) || (j == 327)) {
              localTask.limitFlow = false;
            }
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if ((j == 10) || (j == 268369922)) {
              localTask.sendOnly = true;
            }
            if ((paramr.Lc().Lb()) && (paramr.getUri() != null) && (paramr.getUri().length() > 0)) {
              localTask.channelSelect |= 0x1;
            }
            if (localTask.cmdID != 0) {
              localTask.channelSelect |= 0x2;
            }
            localTask.reportArg = String.valueOf(j);
            if (j == 522)
            {
              localTask.totalTimeout = 300000;
              localTask.priority = 0;
            }
            if (j == 710)
            {
              localTask.totalTimeout = 15000;
              localTask.serverProcessCost = 0;
            }
            if (j == 2632)
            {
              j = paramr.Kp();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
            }
            y.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramr.KC()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 != i)
            {
              if (paramInt == 1) {
                localTask.retryCount = 0;
              }
              StnLogic.startTask(localTask);
              y.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i);
              return i;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          y.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        catch (RemoteException localRemoteException)
        {
          y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bk.j(localRemoteException) });
        }
        finally {}
        continue;
        i = -1;
      }
      i += 1;
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.eOG)
      {
        paramInt1 = jF(paramInt1);
        if (-1 == paramInt1) {
          return false;
        }
        try
        {
          y.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.eOG[paramInt1].eOM.KP()), bk.bG(this.eOG[paramInt1].eOM.KM()) });
          this.eOG[paramInt1].eOK.Lc().D(this.eOG[paramInt1].eOM.Dj());
          this.eOG[paramInt1].eOK.Lc().fn(this.eOG[paramInt1].eOM.CK());
          bool = this.eOG[paramInt1].eOK.Lc().a(this.eOG[paramInt1].eOK.getType(), this.eOG[paramInt1].eOM.Dj(), this.eOG[paramInt1].eOM.KM(), this.eOG[paramInt1].eOM.KO(), 0, this.eOG[paramInt1].eOM.KP());
          if (!bool) {
            break label303;
          }
          paramByteArrayOutputStream.write(this.eOG[paramInt1].eOK.Lc().KV());
        }
        catch (RemoteException paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 1;
          f.nEG.a(162L, paramArrayOfInt[0], 1L, false);
          y.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { bk.j(paramByteArrayOutputStream) });
          bool = false;
          continue;
        }
        catch (IOException paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 2;
          f.nEG.a(162L, paramArrayOfInt[0], 1L, false);
          y.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { bk.j(paramByteArrayOutputStream) });
          bool = false;
          continue;
        }
        catch (Exception paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 3;
          f.nEG.a(162L, paramArrayOfInt[0], 1L, false);
          y.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { bk.j(paramByteArrayOutputStream) });
          boolean bool = false;
          continue;
        }
        y.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
      label303:
      paramArrayOfInt[0] = 0;
      f.nEG.a(162L, paramArrayOfInt[0], 1L, false);
      y.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
    }
  }
  
  final r cn(boolean paramBoolean)
  {
    z.a[] arrayOfa = this.eOG;
    int i = 0;
    Object localObject4;
    label230:
    Object localObject2;
    for (Object localObject1 = null;; localObject2 = localObject4)
    {
      if (i < 100)
      {
        try
        {
          z.a locala = this.eOG[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label230;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.eOG[i].eOK instanceof r.a)) {
              break label230;
            }
            if ((!paramBoolean) && (!(this.eOG[i].eOK instanceof r.a)))
            {
              localObject3 = localObject1;
              break label230;
            }
            if ((701 == this.eOG[i].eOK.getType()) || (702 == this.eOG[i].eOK.getType()))
            {
              y.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.eOG[i].eOK.getType());
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            y.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bk.j(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localr;
        }
        finally {}
        if (localr == null) {
          localObject4 = this.eOG[i].eOK;
        }
      }
      else
      {
        return localr;
      }
      i += 1;
    }
  }
  
  protected final void finalize()
  {
    reset();
    super.finalize();
  }
  
  /* Error */
  public final void g(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 31
    //   2: new 33	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 360
    //   9: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 42	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc_w 362
    //   19: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 42	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 364
    //   29: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_3
    //   33: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 366	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: invokestatic 369	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   45: invokestatic 370	com/tencent/mars/stn/StnLogic:reset	()V
    //   48: bipush 100
    //   50: anewarray 6	com/tencent/mm/network/z$a
    //   53: astore 5
    //   55: aload_0
    //   56: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   59: astore 6
    //   61: aload 6
    //   63: monitorenter
    //   64: iconst_0
    //   65: istore 4
    //   67: iload 4
    //   69: bipush 100
    //   71: if_icmpge +32 -> 103
    //   74: aload 5
    //   76: iload 4
    //   78: aload_0
    //   79: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   82: iload 4
    //   84: aaload
    //   85: aastore
    //   86: aload_0
    //   87: getfield 14	com/tencent/mm/network/z:eOG	[Lcom/tencent/mm/network/z$a;
    //   90: iload 4
    //   92: aconst_null
    //   93: aastore
    //   94: iload 4
    //   96: iconst_1
    //   97: iadd
    //   98: istore 4
    //   100: goto -33 -> 67
    //   103: aload 6
    //   105: monitorexit
    //   106: iconst_0
    //   107: istore 4
    //   109: iload 4
    //   111: bipush 100
    //   113: if_icmpge +135 -> 248
    //   116: aload 5
    //   118: iload 4
    //   120: aaload
    //   121: ifnull +88 -> 209
    //   124: ldc 31
    //   126: ldc_w 372
    //   129: iconst_3
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: iload 4
    //   137: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 5
    //   145: iload 4
    //   147: aaload
    //   148: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   151: invokeinterface 29 1 0
    //   156: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload 5
    //   164: iload 4
    //   166: aaload
    //   167: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   170: invokeinterface 268 1 0
    //   175: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: invokestatic 276	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload 5
    //   184: iload 4
    //   186: aaload
    //   187: getfield 182	com/tencent/mm/network/z$a:eOL	Lcom/tencent/mm/network/l;
    //   190: iload 4
    //   192: iload_1
    //   193: iload_2
    //   194: aload_3
    //   195: aload 5
    //   197: iload 4
    //   199: aaload
    //   200: getfield 23	com/tencent/mm/network/z$a:eOK	Lcom/tencent/mm/network/r;
    //   203: aconst_null
    //   204: invokeinterface 377 7 0
    //   209: iload 4
    //   211: iconst_1
    //   212: iadd
    //   213: istore 4
    //   215: goto -106 -> 109
    //   218: astore_3
    //   219: aload 6
    //   221: monitorexit
    //   222: aload_3
    //   223: athrow
    //   224: astore 6
    //   226: ldc 31
    //   228: ldc 164
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 6
    //   238: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 75	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -36 -> 209
    //   248: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	z
    //   0	249	1	paramInt1	int
    //   0	249	2	paramInt2	int
    //   0	249	3	paramString	String
    //   65	149	4	i	int
    //   53	143	5	arrayOfa1	z.a[]
    //   59	161	6	arrayOfa2	z.a[]
    //   224	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   74	94	218	finally
    //   103	106	218	finally
    //   219	222	218	finally
    //   124	209	224	java/lang/Exception
  }
  
  final int jE(int paramInt)
  {
    synchronized (this.eOG)
    {
      paramInt = jF(paramInt);
      if (-1 == paramInt)
      {
        y.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        return 0;
      }
    }
    return 0;
  }
  
  final int jF(int paramInt)
  {
    int i = 0;
    while ((i < 100) && ((this.eOG[i] == null) || (paramInt != this.eOG[i].taskId))) {
      i += 1;
    }
    paramInt = i;
    if (100 <= i) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final void reset()
  {
    y.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.reset();
    z.a[] arrayOfa = this.eOG;
    int i = 0;
    while (i < 100) {
      try
      {
        z.a locala = this.eOG[i];
        if (locala != null) {}
        try
        {
          y.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.eOG[i].eOK.getType()), Integer.valueOf(this.eOG[i].eOK.KC()) });
          this.eOG[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            y.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bk.j(localRemoteException) });
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.z
 * JD-Core Version:    0.7.0.1
 */