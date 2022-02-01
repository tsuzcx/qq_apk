package com.tencent.mm.loader.j;

import com.tencent.mm.loader.b.e.c;
import com.tencent.mm.loader.d.c.b.b;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.g.f<*>;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T, R>
  extends b<T, R>
{
  public static final a.a nsM = new a.a((byte)0);
  private com.tencent.mm.loader.cache.memory.d<T, R> npC = bnG().noA;
  private com.tencent.mm.loader.cache.a.d<T, R> npD = bnG().noB;
  private com.tencent.mm.loader.c.d<R> nsN = bnG().noF;
  
  public a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    super(parama, paramd, paramf);
  }
  
  private final b<R> a(final com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.b.a parama)
  {
    com.tencent.mm.loader.f localf = bnG();
    localCloseable = (Closeable)parama;
    for (;;)
    {
      try
      {
        localObject = this.nsN;
        if (localObject != null) {
          continue;
        }
        parama = null;
        if (!(parama instanceof com.tencent.mm.loader.g.e)) {
          continue;
        }
        localObject = parama;
      }
      finally
      {
        try
        {
          com.tencent.mm.loader.d.c.a locala1;
          b.b localb;
          throw paramf;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramf);
        }
        if (parama == null) {
          continue;
        }
        com.tencent.mm.loader.g.b.a locala = parama;
        continue;
        if (i != 1) {
          continue;
        }
        int i = 1;
        continue;
        Object localObject = null;
        continue;
        parama = null;
        continue;
        locala = parama;
        if (parama != null) {
          continue;
        }
        continue;
        if (parama == null) {
          continue;
        }
        locala = parama;
        continue;
        parama = null;
        continue;
        parama = null;
        continue;
        locala = parama;
        if (parama != null) {
          continue;
        }
        continue;
        if (parama == null) {
          continue;
        }
        locala = parama;
        continue;
        parama = null;
        continue;
        parama = null;
        continue;
        locala = parama;
        if (parama != null) {
          continue;
        }
        i = 0;
        continue;
        parama = null;
        continue;
        i = 0;
        continue;
      }
      if (localObject == null) {
        continue;
      }
      locala1 = localf.noG;
      if (locala1 == null) {
        continue;
      }
      localb = b.b.nra;
      s.u(localb, "when");
      parama = ((com.tencent.mm.loader.d.c.a)locala1).nqR;
      if (!(parama instanceof com.tencent.mm.loader.d.c.b)) {
        continue;
      }
      continue;
      if ((locala.nqS != com.tencent.mm.loader.d.c.b.a.nqW) || (localb != locala.nqT)) {
        continue;
      }
      i = 1;
      continue;
      if (i == 0) {
        continue;
      }
      parama = localf.noG;
      if (parama == null) {
        continue;
      }
      parama = parama.a(localf.bli().nqG, localf, (com.tencent.mm.loader.g.e)localObject, b.b.nra);
      if (parama == null) {
        continue;
      }
      a(paramf, (com.tencent.mm.loader.g.e)localObject, parama, (b)this);
      paramf = new b(parama, (kotlin.g.a.a)a.d.nsT);
      kotlin.f.b.a(localCloseable, null);
      return paramf;
      parama = ((com.tencent.mm.loader.c.d)localObject).a(localf.bli().nqG, bnG(), parama);
    }
    parama = locala.nqR;
    if ((parama instanceof com.tencent.mm.loader.d.c.b))
    {
      break label425;
      parama = ((com.tencent.mm.loader.d.c.a)locala1).nqR;
      if (!(parama instanceof com.tencent.mm.loader.d.c.b)) {
        break label450;
      }
      break label435;
      if ((locala.nqS == com.tencent.mm.loader.d.c.b.a.nqV) && (localb == locala.nqT))
      {
        i = 1;
      }
      else
      {
        parama = locala.nqR;
        if (!(parama instanceof com.tencent.mm.loader.d.c.b)) {
          break label475;
        }
        break label455;
        parama = ((com.tencent.mm.loader.d.c.a)locala1).nqR;
        if (!(parama instanceof com.tencent.mm.loader.d.c.b)) {
          break label480;
        }
        break label465;
        if ((locala.nqS == com.tencent.mm.loader.d.c.b.a.nqU) && (localb == locala.nqT))
        {
          i = 1;
        }
        else
        {
          parama = locala.nqR;
          if (!(parama instanceof com.tencent.mm.loader.d.c.b)) {
            break label497;
          }
          break label485;
          paramf = new b((com.tencent.mm.loader.g.e)localObject, (kotlin.g.a.a)new e(this, paramf, (com.tencent.mm.loader.g.e)localObject));
          kotlin.f.b.a(localCloseable, null);
          return paramf;
          kotlin.f.b.a(localCloseable, null);
          return null;
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.loader.g.f<?> paramf, b.a<R> parama)
  {
    com.tencent.mm.loader.g.c localc = new com.tencent.mm.loader.g.c();
    Log.i("MicroMsg.Loader.ImageLoadWorkTask", "whenDataReady " + this.nqP + " httpResponse " + paramf);
    Object localObject = com.tencent.mm.loader.g.c.nse;
    localc.from = com.tencent.mm.loader.g.c.bmf();
    com.tencent.mm.loader.f localf = bnG();
    int i;
    label81:
    Closeable localCloseable;
    if (paramf != null) {
      if (paramf.cpt != null)
      {
        i = 1;
        if (i == 0) {
          break label324;
        }
        localObject = paramf;
        if (localObject == null) {
          break label459;
        }
        localObject = paramf.blY();
        if (localObject == null) {
          break label459;
        }
        localCloseable = (Closeable)localObject;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (com.tencent.mm.loader.g.b.a)localCloseable;
        System.currentTimeMillis();
        b localb = a(paramf, (com.tencent.mm.loader.g.b.a)localObject);
        if (localb != null)
        {
          localObject = localb.nsO;
          if (localObject != null)
          {
            com.tencent.mm.ae.c localc1 = new com.tencent.mm.ae.c("Transcoder");
            paramf = localf.noH;
            if (paramf != null) {
              continue;
            }
            paramf = null;
            break label527;
            localObject = localf.noG;
            if (localObject != null) {
              continue;
            }
            localObject = null;
            break label537;
            localObject = localf.noG;
            if (localObject != null) {
              continue;
            }
            localObject = null;
            break label545;
            localObject = ah.aiuX;
            localc1.bbW();
            paramf = paramf.value;
            localc.value = paramf;
            parama.c(localc);
            if (paramf != null)
            {
              parama = this.npC;
              if (parama != null) {
                parama.a(localf.noP, localf.noG, paramf);
              }
            }
          }
          paramf = new com.tencent.mm.ae.c("lazytask commit");
          localb.nsP.invoke();
          parama = ah.aiuX;
          paramf.bbW();
          paramf = localf.noI;
          if (paramf != null) {
            paramf.onImageDownload(true, new Object[0]);
          }
          kotlin.f.b.a(localCloseable, null);
          return;
          i = 0;
          break;
          label324:
          localObject = null;
          break label81;
          paramf = paramf.a(localf.bli().nqG, localf, (com.tencent.mm.loader.g.e)localObject, b.b.nqZ);
          break label527;
          localObject = ((com.tencent.mm.loader.d.c.a)localObject).a(localf.bli().nqG, localf, paramf, b.b.nqZ);
          break label537;
          localObject = ((com.tencent.mm.loader.d.c.a)localObject).a(localf.bli().nqG, localf, paramf, b.b.nqY);
          break label545;
        }
        paramf = com.tencent.mm.loader.g.c.nse;
        localc.status = com.tencent.mm.loader.g.c.bmc();
        paramf = localf.noI;
        if (paramf != null) {
          paramf.onImageDownload(false, new Object[0]);
        }
        parama.bnH();
        kotlin.f.b.a(localCloseable, null);
        return;
      }
      finally
      {
        try
        {
          throw paramf;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramf);
        }
      }
      label459:
      paramf = com.tencent.mm.loader.g.c.nse;
      localc.status = com.tencent.mm.loader.g.c.bmb();
      Log.i("MicroMsg.Loader.ImageLoadWorkTask", "httpRespone value is null %s %s", new Object[] { this.nqP, Util.getStack().toString() });
      paramf = localf.noI;
      if (paramf != null) {
        paramf.onImageDownload(false, new Object[0]);
      }
      parama.bnH();
      return;
      label527:
      if (paramf == null)
      {
        paramf = (com.tencent.mm.loader.g.f<?>)localObject;
        continue;
        label537:
        if (localObject == null)
        {
          continue;
          label545:
          if (localObject != null) {
            break label562;
          }
          continue;
        }
      }
      else
      {
        continue;
      }
      paramf = (com.tencent.mm.loader.g.f<?>)localObject;
      continue;
      label562:
      paramf = (com.tencent.mm.loader.g.f<?>)localObject;
    }
  }
  
  private final boolean bnE()
  {
    if (this.nqP == null) {}
    do
    {
      return false;
      com.tencent.mm.loader.g.a.a locala = this.nqP;
      if ((locala == null) || (locala.bmh() == com.tencent.mm.loader.g.a.b.nsr) || (locala.bmh() == com.tencent.mm.loader.g.a.b.nsq) || (locala.bmh() == com.tencent.mm.loader.g.a.b.nss)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    } while (bnG().nou.npT != e.c.nqr);
    return true;
  }
  
  /* Error */
  private final com.tencent.mm.loader.g.c<R> bnF()
  {
    // Byte code:
    //   0: new 219	com/tencent/mm/loader/g/c
    //   3: dup
    //   4: invokespecial 221	com/tencent/mm/loader/g/c:<init>	()V
    //   7: astore_3
    //   8: getstatic 257	com/tencent/mm/loader/g/c:nse	Lcom/tencent/mm/loader/g/c$a;
    //   11: astore_1
    //   12: aload_3
    //   13: invokestatic 423	com/tencent/mm/loader/g/c:bme	()I
    //   16: putfield 265	com/tencent/mm/loader/g/c:from	I
    //   19: aload_0
    //   20: invokevirtual 112	com/tencent/mm/loader/j/a:bnG	()Lcom/tencent/mm/loader/f;
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 119	com/tencent/mm/loader/j/a:npD	Lcom/tencent/mm/loader/cache/a/d;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +172 -> 203
    //   34: aload_0
    //   35: getfield 234	com/tencent/mm/loader/j/b:nqP	Lcom/tencent/mm/loader/g/a/a;
    //   38: astore_2
    //   39: aload 4
    //   41: getfield 405	com/tencent/mm/loader/f:nou	Lcom/tencent/mm/loader/b/e;
    //   44: astore 5
    //   46: aload_2
    //   47: ldc_w 425
    //   50: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   53: aload 5
    //   55: ldc_w 427
    //   58: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   61: aload 4
    //   63: ldc 106
    //   65: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   68: aload_2
    //   69: ldc_w 425
    //   72: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 5
    //   77: ldc_w 427
    //   80: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   83: aload 4
    //   85: ldc 106
    //   87: invokestatic 104	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload_1
    //   91: aload_2
    //   92: aload 5
    //   94: aload 4
    //   96: invokevirtual 432	com/tencent/mm/loader/cache/a/d:b	(Lcom/tencent/mm/loader/g/a/a;Lcom/tencent/mm/loader/b/e;Lcom/tencent/mm/loader/f;)Lcom/tencent/mm/loader/g/b/a;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +102 -> 203
    //   104: aload_1
    //   105: checkcast 135	java/io/Closeable
    //   108: astore 5
    //   110: aload 5
    //   112: checkcast 277	com/tencent/mm/loader/g/b/a
    //   115: astore 6
    //   117: aload_0
    //   118: getfield 129	com/tencent/mm/loader/j/a:nsN	Lcom/tencent/mm/loader/c/d;
    //   121: astore_1
    //   122: aload_1
    //   123: ifnonnull +82 -> 205
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: instanceof 137
    //   132: ifeq +228 -> 360
    //   135: goto +214 -> 349
    //   138: aload_1
    //   139: ifnull +49 -> 188
    //   142: aload_1
    //   143: invokevirtual 435	com/tencent/mm/loader/g/e:isValid	()Z
    //   146: ifeq +153 -> 299
    //   149: aload_1
    //   150: ifnull +38 -> 188
    //   153: aload_0
    //   154: getfield 124	com/tencent/mm/loader/j/a:npC	Lcom/tencent/mm/loader/cache/memory/d;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +21 -> 180
    //   162: aload_2
    //   163: aload 4
    //   165: getfield 319	com/tencent/mm/loader/f:noP	Lcom/tencent/mm/loader/g/a/a;
    //   168: aload 4
    //   170: getfield 141	com/tencent/mm/loader/f:noG	Lcom/tencent/mm/loader/d/c/a;
    //   173: aload_1
    //   174: getfield 309	com/tencent/mm/loader/g/e:value	Ljava/lang/Object;
    //   177: invokevirtual 324	com/tencent/mm/loader/cache/memory/d:a	(Lcom/tencent/mm/loader/g/a/a;Lcom/tencent/mm/loader/d/c/a;Ljava/lang/Object;)V
    //   180: aload_3
    //   181: aload_1
    //   182: getfield 309	com/tencent/mm/loader/g/e:value	Ljava/lang/Object;
    //   185: putfield 310	com/tencent/mm/loader/g/c:value	Ljava/lang/Object;
    //   188: aload 6
    //   190: invokevirtual 438	com/tencent/mm/loader/g/b/a:close	()V
    //   193: getstatic 303	kotlin/ah:aiuX	Lkotlin/ah;
    //   196: astore_1
    //   197: aload 5
    //   199: aconst_null
    //   200: invokestatic 201	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   203: aload_3
    //   204: areturn
    //   205: aload_1
    //   206: aload 4
    //   208: invokevirtual 173	com/tencent/mm/loader/f:bli	()Lcom/tencent/mm/loader/d/b/d;
    //   211: getfield 179	com/tencent/mm/loader/d/b/d:nqG	Lcom/tencent/mm/loader/d/b/g;
    //   214: aload 4
    //   216: aload 6
    //   218: invokevirtual 206	com/tencent/mm/loader/c/d:a	(Lcom/tencent/mm/loader/d/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/g/b/a;)Lcom/tencent/mm/loader/g/e;
    //   221: astore_1
    //   222: goto -94 -> 128
    //   225: aload 4
    //   227: getfield 297	com/tencent/mm/loader/f:noH	Lcom/tencent/mm/loader/d/c/a;
    //   230: astore_2
    //   231: aload_2
    //   232: ifnonnull +8 -> 240
    //   235: aconst_null
    //   236: astore_2
    //   237: goto +128 -> 365
    //   240: aload_2
    //   241: aload 4
    //   243: invokevirtual 173	com/tencent/mm/loader/f:bli	()Lcom/tencent/mm/loader/d/b/d;
    //   246: getfield 179	com/tencent/mm/loader/d/b/d:nqG	Lcom/tencent/mm/loader/d/b/g;
    //   249: aload 4
    //   251: aload_1
    //   252: getstatic 349	com/tencent/mm/loader/d/c/b$b:nqZ	Lcom/tencent/mm/loader/d/c/b$b;
    //   255: invokevirtual 182	com/tencent/mm/loader/d/c/a:a	(Lcom/tencent/mm/loader/d/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/g/e;Lcom/tencent/mm/loader/d/c/b$b;)Lcom/tencent/mm/loader/g/e;
    //   258: astore_2
    //   259: goto +106 -> 365
    //   262: aload 4
    //   264: getfield 141	com/tencent/mm/loader/f:noG	Lcom/tencent/mm/loader/d/c/a;
    //   267: astore_2
    //   268: aload_2
    //   269: ifnonnull +8 -> 277
    //   272: aconst_null
    //   273: astore_2
    //   274: goto +100 -> 374
    //   277: aload_2
    //   278: aload 4
    //   280: invokevirtual 173	com/tencent/mm/loader/f:bli	()Lcom/tencent/mm/loader/d/b/d;
    //   283: getfield 179	com/tencent/mm/loader/d/b/d:nqG	Lcom/tencent/mm/loader/d/b/g;
    //   286: aload 4
    //   288: aload_1
    //   289: getstatic 349	com/tencent/mm/loader/d/c/b$b:nqZ	Lcom/tencent/mm/loader/d/c/b$b;
    //   292: invokevirtual 182	com/tencent/mm/loader/d/c/a:a	(Lcom/tencent/mm/loader/d/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/g/e;Lcom/tencent/mm/loader/d/c/b$b;)Lcom/tencent/mm/loader/g/e;
    //   295: astore_2
    //   296: goto +78 -> 374
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -152 -> 149
    //   304: astore_1
    //   305: aload_1
    //   306: athrow
    //   307: astore_2
    //   308: aload 5
    //   310: aload_1
    //   311: invokestatic 201	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: athrow
    //   316: astore_1
    //   317: ldc 223
    //   319: aload_1
    //   320: checkcast 440	java/lang/Throwable
    //   323: ldc_w 442
    //   326: iconst_2
    //   327: anewarray 340	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_0
    //   333: getfield 234	com/tencent/mm/loader/j/b:nqP	Lcom/tencent/mm/loader/g/a/a;
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: aload_0
    //   340: getfield 446	com/tencent/mm/loader/j/b:noR	Ljava/lang/String;
    //   343: aastore
    //   344: invokestatic 450	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: aload_3
    //   348: areturn
    //   349: aload_1
    //   350: ifnonnull -125 -> 225
    //   353: aload_1
    //   354: ifnonnull -92 -> 262
    //   357: goto -219 -> 138
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -13 -> 349
    //   365: aload_2
    //   366: ifnull -13 -> 353
    //   369: aload_2
    //   370: astore_1
    //   371: goto -18 -> 353
    //   374: aload_2
    //   375: ifnull -237 -> 138
    //   378: aload_2
    //   379: astore_1
    //   380: goto -242 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	a
    //   11	290	1	localObject1	Object
    //   304	7	1	localThrowable	Throwable
    //   316	38	1	localException	Exception
    //   361	19	1	localObject2	Object
    //   38	258	2	localObject3	Object
    //   307	72	2	localObject4	Object
    //   7	341	3	localc	com.tencent.mm.loader.g.c
    //   23	264	4	localf	com.tencent.mm.loader.f
    //   44	265	5	localObject5	Object
    //   115	102	6	locala	com.tencent.mm.loader.g.b.a
    // Exception table:
    //   from	to	target	type
    //   110	122	304	finally
    //   128	135	304	finally
    //   142	149	304	finally
    //   153	158	304	finally
    //   162	180	304	finally
    //   180	188	304	finally
    //   188	197	304	finally
    //   205	222	304	finally
    //   225	231	304	finally
    //   240	259	304	finally
    //   262	268	304	finally
    //   277	296	304	finally
    //   305	307	307	finally
    //   19	30	316	java/lang/Exception
    //   34	100	316	java/lang/Exception
    //   104	110	316	java/lang/Exception
    //   197	203	316	java/lang/Exception
    //   308	316	316	java/lang/Exception
  }
  
  protected final void a(e.c paramc, b.a<R> parama)
  {
    Object localObject2 = null;
    s.u(paramc, "fileType");
    s.u(parama, "taskListener");
    for (;;)
    {
      try
      {
        System.currentTimeMillis();
        Log.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.nqP + " fileType " + paramc + " [width:" + bli() + ".weakHolder.viewWidth height:" + bli() + ".weakHolder.viewHeight] diskCache " + this.npD + " producer " + this.nsN + " isLocalFile: " + bnE());
        Object localObject3 = bnF();
        if ((!bnE()) && (((com.tencent.mm.loader.g.c)localObject3).value == null))
        {
          bool = true;
          Object localObject4 = new StringBuilder("[ImageLoader] run. get bitmap from disk. done result resultData ").append(localObject3).append(" bitmap ");
          if (localObject3 == null)
          {
            localObject1 = null;
            Log.i("MicroMsg.Loader.ImageLoadWorkTask", localObject1 + " isNeedDownload " + bool);
            if (!bool) {
              parama.d((com.tencent.mm.loader.g.c)localObject3);
            }
          }
          else
          {
            localObject1 = ((com.tencent.mm.loader.g.c)localObject3).value;
            continue;
          }
          Object localObject1 = bnG();
          final long l;
          try
          {
            l = System.currentTimeMillis();
            Log.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.nqP + " fileType: " + paramc);
            paramc = ((com.tencent.mm.loader.f)localObject1).noy;
            if (paramc != null)
            {
              localObject3 = this.nqP;
              ((com.tencent.mm.loader.f)localObject1).bli();
              paramc.a((com.tencent.mm.loader.g.a.a)localObject3);
            }
            paramc = ((com.tencent.mm.loader.f)localObject1).noz;
            if (((com.tencent.mm.loader.f)localObject1).noE.d(this.nqP))
            {
              if (paramc != null) {
                continue;
              }
              a(null, parama);
              Log.i("MicroMsg.Loader.ImageLoadWorkTask", s.X("can not download image, over limit ", this.nqP));
              return;
            }
          }
          catch (Exception paramc)
          {
            Log.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramc, "[ImageLoader DownLoadException] run error %s [debug info %s]", new Object[] { this.nqP, ((com.tencent.mm.loader.f)localObject1).noR });
            paramc = ah.aiuX;
            return;
          }
          paramc = null;
          continue;
          localObject3 = ((com.tencent.mm.loader.f)localObject1).noz;
          localObject4 = this.nqP;
          g localg = ((com.tencent.mm.loader.f)localObject1).noL;
          paramc = this.nre;
          if (paramc != null)
          {
            ((com.tencent.mm.loader.c.b)localObject3).a((com.tencent.mm.loader.g.a.a)localObject4, localg, paramc, (com.tencent.mm.loader.c.b.a)new c(parama, this, l));
            return;
          }
          s.bIx("loader");
          paramc = localObject2;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramc)
      {
        Log.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramc, "[ImageLoader execute] " + paramc.getMessage() + " run error " + this.nqP + " [debug info " + this.noR + ']', new Object[0]);
        parama.bnH();
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "R", "", "result", "Lcom/tencent/mm/loader/model/Resource;", "block", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/loader/model/Resource;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getResult", "()Lcom/tencent/mm/loader/model/Resource;", "setResult", "(Lcom/tencent/mm/loader/model/Resource;)V", "commit", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b<R>
  {
    com.tencent.mm.loader.g.e<R> nsO;
    final kotlin.g.a.a<ah> nsP;
    
    public b(com.tencent.mm.loader.g.e<R> parame, kotlin.g.a.a<ah> parama)
    {
      this.nsO = parame;
      this.nsP = parama;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/task/ImageLoadWorkTask$executeTask$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.c.b.a
  {
    c(b.a<R> parama, a<T, R> parama1, long paramLong) {}
    
    public final void a(com.tencent.mm.loader.g.f<?> paramf)
    {
      s.u(paramf, "resp");
      a.a(jdField_this, paramf, l, this.nsQ);
    }
    
    public final void atR()
    {
      a.a(jdField_this, null, l, this.nsQ);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "R"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a<T, R> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<R> parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.j.a
 * JD-Core Version:    0.7.0.1
 */