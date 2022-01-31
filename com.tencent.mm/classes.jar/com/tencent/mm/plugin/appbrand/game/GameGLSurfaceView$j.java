package com.tencent.mm.plugin.appbrand.game;

import android.util.Log;
import com.tencent.magicbrush.a.d.f;
import com.tencent.mm.plugin.appbrand.game.f.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class GameGLSurfaceView$j
  extends Thread
{
  private WeakReference<GameGLSurfaceView> fZa;
  private boolean fZc;
  public boolean fZd;
  private boolean fZe;
  public boolean fZf;
  boolean fZg;
  public boolean fZh;
  boolean fZi;
  private boolean fZj;
  boolean fZk;
  boolean fZl;
  boolean fZm;
  boolean fZn;
  private boolean fZo;
  public boolean fZp;
  private boolean fZq;
  public boolean fZr;
  LinkedList<Runnable> fZs = new LinkedList();
  boolean fZt = true;
  private GameGLSurfaceView.i fZu;
  int mHeight;
  private int mRenderMode;
  int mWidth;
  public boolean sn;
  
  GameGLSurfaceView$j(WeakReference<GameGLSurfaceView> paramWeakReference)
  {
    try
    {
      setPriority(10);
      label26:
      this.mWidth = 0;
      this.mHeight = 0;
      this.fZp = true;
      this.mRenderMode = 1;
      this.fZq = false;
      this.fZa = paramWeakReference;
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  private void afR()
  {
    if (this.fZm)
    {
      this.fZm = false;
      this.fZn = false;
    }
  }
  
  private void afS()
  {
    if (this.fZl)
    {
      this.fZl = false;
      GameGLSurfaceView.afP().notifyAll();
    }
  }
  
  /* Error */
  private void afT()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 95	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i
    //   4: dup
    //   5: aload_0
    //   6: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 97	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 99	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZu	Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 81	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZl	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   25: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   28: astore 15
    //   30: aload 15
    //   32: monitorenter
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 66	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZq	Z
    //   38: aload 15
    //   40: monitorexit
    //   41: iconst_0
    //   42: istore 4
    //   44: iconst_0
    //   45: istore 6
    //   47: iconst_0
    //   48: istore 5
    //   50: iconst_0
    //   51: istore 7
    //   53: iconst_0
    //   54: istore_3
    //   55: iconst_0
    //   56: istore 8
    //   58: iconst_0
    //   59: istore_1
    //   60: iconst_0
    //   61: istore_2
    //   62: iconst_0
    //   63: istore 9
    //   65: iconst_0
    //   66: istore 10
    //   68: aconst_null
    //   69: astore 15
    //   71: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   74: astore 16
    //   76: aload 16
    //   78: monitorenter
    //   79: iload 7
    //   81: istore 11
    //   83: aload_0
    //   84: getfield 101	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZc	Z
    //   87: ifeq +15 -> 102
    //   90: aload 16
    //   92: monitorexit
    //   93: return
    //   94: astore 16
    //   96: aload 15
    //   98: monitorexit
    //   99: aload 16
    //   101: athrow
    //   102: aload_0
    //   103: getfield 103	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:sn	Z
    //   106: ifne +66 -> 172
    //   109: aload_0
    //   110: getfield 78	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZn	Z
    //   113: ifeq +59 -> 172
    //   116: aload_0
    //   117: getfield 50	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZs	Ljava/util/LinkedList;
    //   120: invokevirtual 107	java/util/LinkedList:isEmpty	()Z
    //   123: ifne +49 -> 172
    //   126: aload_0
    //   127: getfield 50	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZs	Ljava/util/LinkedList;
    //   130: iconst_0
    //   131: invokevirtual 111	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   134: checkcast 113	java/lang/Runnable
    //   137: astore 15
    //   139: iload 11
    //   141: istore 7
    //   143: iload 9
    //   145: istore 13
    //   147: aload 16
    //   149: monitorexit
    //   150: aload 15
    //   152: ifnull +1113 -> 1265
    //   155: aload 15
    //   157: invokeinterface 116 1 0
    //   162: aconst_null
    //   163: astore 15
    //   165: iload 13
    //   167: istore 9
    //   169: goto -98 -> 71
    //   172: aload_0
    //   173: getfield 103	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:sn	Z
    //   176: aload_0
    //   177: getfield 118	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZf	Z
    //   180: if_icmpeq +2286 -> 2466
    //   183: aload_0
    //   184: getfield 118	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZf	Z
    //   187: istore 14
    //   189: aload_0
    //   190: aload_0
    //   191: getfield 118	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZf	Z
    //   194: putfield 103	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:sn	Z
    //   197: iload 14
    //   199: ifeq +611 -> 810
    //   202: aload_0
    //   203: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   206: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   209: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   212: astore 17
    //   214: aload 17
    //   216: ifnull +13 -> 229
    //   219: aload 17
    //   221: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   224: invokeinterface 133 1 0
    //   229: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   232: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   235: ldc 135
    //   237: new 137	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 139
    //   243: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: getfield 103	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:sn	Z
    //   250: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   253: ldc 148
    //   255: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   262: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: iconst_0
    //   269: anewarray 87	java/lang/Object
    //   272: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: aload_0
    //   276: getfield 170	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZo	Z
    //   279: ifeq +46 -> 325
    //   282: ldc 135
    //   284: new 137	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 172
    //   290: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   297: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: iconst_0
    //   304: anewarray 87	java/lang/Object
    //   307: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload_0
    //   311: invokespecial 174	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afR	()V
    //   314: aload_0
    //   315: invokespecial 176	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afS	()V
    //   318: aload_0
    //   319: iconst_0
    //   320: putfield 170	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZo	Z
    //   323: iconst_1
    //   324: istore_2
    //   325: iload 11
    //   327: istore 7
    //   329: iload 11
    //   331: ifeq +14 -> 345
    //   334: aload_0
    //   335: invokespecial 174	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afR	()V
    //   338: aload_0
    //   339: invokespecial 176	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afS	()V
    //   342: iconst_0
    //   343: istore 7
    //   345: iload 14
    //   347: ifeq +42 -> 389
    //   350: aload_0
    //   351: getfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   354: ifeq +35 -> 389
    //   357: ldc 135
    //   359: new 137	java/lang/StringBuilder
    //   362: dup
    //   363: ldc 178
    //   365: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload_0
    //   369: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   372: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: iconst_0
    //   379: anewarray 87	java/lang/Object
    //   382: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload_0
    //   386: invokespecial 174	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afR	()V
    //   389: iload 14
    //   391: ifeq +67 -> 458
    //   394: aload_0
    //   395: getfield 81	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZl	Z
    //   398: ifeq +60 -> 458
    //   401: aload_0
    //   402: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   405: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   408: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   411: astore 17
    //   413: aload 17
    //   415: ifnonnull +433 -> 848
    //   418: iconst_0
    //   419: istore 14
    //   421: iload 14
    //   423: ifne +35 -> 458
    //   426: aload_0
    //   427: invokespecial 176	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afS	()V
    //   430: ldc 135
    //   432: new 137	java/lang/StringBuilder
    //   435: dup
    //   436: ldc 180
    //   438: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: aload_0
    //   442: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   445: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: iconst_0
    //   452: anewarray 87	java/lang/Object
    //   455: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: aload_0
    //   459: getfield 182	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZi	Z
    //   462: ifne +65 -> 527
    //   465: aload_0
    //   466: getfield 184	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZk	Z
    //   469: ifne +58 -> 527
    //   472: ldc 135
    //   474: new 137	java/lang/StringBuilder
    //   477: dup
    //   478: ldc 186
    //   480: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload_0
    //   484: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   487: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: iconst_0
    //   494: anewarray 87	java/lang/Object
    //   497: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: getfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   504: ifeq +7 -> 511
    //   507: aload_0
    //   508: invokespecial 174	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afR	()V
    //   511: aload_0
    //   512: iconst_1
    //   513: putfield 184	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZk	Z
    //   516: aload_0
    //   517: iconst_0
    //   518: putfield 188	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZj	Z
    //   521: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   524: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   527: aload_0
    //   528: getfield 182	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZi	Z
    //   531: ifeq +49 -> 580
    //   534: aload_0
    //   535: getfield 184	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZk	Z
    //   538: ifeq +42 -> 580
    //   541: ldc 135
    //   543: new 137	java/lang/StringBuilder
    //   546: dup
    //   547: ldc 190
    //   549: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   556: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   559: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: iconst_0
    //   563: anewarray 87	java/lang/Object
    //   566: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   569: aload_0
    //   570: iconst_0
    //   571: putfield 184	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZk	Z
    //   574: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   577: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   580: iload_1
    //   581: ifeq +1882 -> 2463
    //   584: ldc 135
    //   586: new 137	java/lang/StringBuilder
    //   589: dup
    //   590: ldc 192
    //   592: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: aload_0
    //   596: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   599: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   602: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: iconst_0
    //   606: anewarray 87	java/lang/Object
    //   609: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: aload_0
    //   613: iconst_0
    //   614: putfield 66	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZq	Z
    //   617: aload_0
    //   618: iconst_1
    //   619: putfield 194	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZr	Z
    //   622: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   625: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   628: iconst_0
    //   629: istore_1
    //   630: aload_0
    //   631: invokevirtual 197	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afV	()Z
    //   634: ifeq +1826 -> 2460
    //   637: iload 4
    //   639: istore 11
    //   641: aload_0
    //   642: getfield 81	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZl	Z
    //   645: ifne +481 -> 1126
    //   648: ldc 135
    //   650: ldc 199
    //   652: iconst_0
    //   653: anewarray 87	java/lang/Object
    //   656: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   659: iload_2
    //   660: ifeq +198 -> 858
    //   663: iconst_0
    //   664: istore_2
    //   665: aload_0
    //   666: getfield 81	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZl	Z
    //   669: ifeq +1778 -> 2447
    //   672: aload_0
    //   673: getfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   676: ifne +1771 -> 2447
    //   679: ldc 135
    //   681: ldc 201
    //   683: iconst_0
    //   684: anewarray 87	java/lang/Object
    //   687: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   690: aload_0
    //   691: iconst_1
    //   692: putfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   695: iconst_1
    //   696: istore 5
    //   698: iconst_1
    //   699: istore 6
    //   701: iconst_1
    //   702: istore_3
    //   703: aload_0
    //   704: getfield 76	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZm	Z
    //   707: ifeq +487 -> 1194
    //   710: aload_0
    //   711: getfield 52	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZt	Z
    //   714: ifeq +58 -> 772
    //   717: iconst_1
    //   718: istore 6
    //   720: aload_0
    //   721: getfield 58	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:mWidth	I
    //   724: istore 9
    //   726: aload_0
    //   727: getfield 60	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:mHeight	I
    //   730: istore 10
    //   732: aload_0
    //   733: iconst_1
    //   734: putfield 66	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZq	Z
    //   737: ldc 135
    //   739: new 137	java/lang/StringBuilder
    //   742: dup
    //   743: ldc 203
    //   745: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   752: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   755: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: iconst_0
    //   759: anewarray 87	java/lang/Object
    //   762: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   765: iconst_1
    //   766: istore_3
    //   767: aload_0
    //   768: iconst_0
    //   769: putfield 52	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZt	Z
    //   772: iload 6
    //   774: istore 11
    //   776: iload_3
    //   777: istore 6
    //   779: aload_0
    //   780: iconst_0
    //   781: putfield 62	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZp	Z
    //   784: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   787: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   790: aload_0
    //   791: getfield 66	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZq	Z
    //   794: ifeq +1643 -> 2437
    //   797: iconst_1
    //   798: istore 8
    //   800: iload 9
    //   802: istore 13
    //   804: iload 11
    //   806: istore_3
    //   807: goto -660 -> 147
    //   810: aload_0
    //   811: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   814: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   817: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   820: astore 17
    //   822: aload 17
    //   824: ifnull -595 -> 229
    //   827: aload 17
    //   829: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   832: invokeinterface 206 1 0
    //   837: goto -608 -> 229
    //   840: astore 15
    //   842: aload 16
    //   844: monitorexit
    //   845: aload 15
    //   847: athrow
    //   848: aload 17
    //   850: invokestatic 210	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:h	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Z
    //   853: istore 14
    //   855: goto -434 -> 421
    //   858: aload_0
    //   859: getfield 99	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZu	Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   862: astore 17
    //   864: ldc 135
    //   866: new 137	java/lang/StringBuilder
    //   869: dup
    //   870: ldc 212
    //   872: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   875: invokestatic 216	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   878: invokevirtual 217	java/lang/Thread:getId	()J
    //   881: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   884: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: iconst_0
    //   888: anewarray 87	java/lang/Object
    //   891: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   894: aload 17
    //   896: invokestatic 226	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
    //   899: checkcast 228	javax/microedition/khronos/egl/EGL10
    //   902: putfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   905: aload 17
    //   907: aload 17
    //   909: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   912: getstatic 236	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
    //   915: invokeinterface 240 2 0
    //   920: putfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   923: aload 17
    //   925: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   928: getstatic 247	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   931: if_acmpne +24 -> 955
    //   934: new 93	java/lang/RuntimeException
    //   937: dup
    //   938: ldc 249
    //   940: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   943: athrow
    //   944: astore 15
    //   946: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   949: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   952: aload 15
    //   954: athrow
    //   955: iconst_2
    //   956: newarray int
    //   958: astore 18
    //   960: aload 17
    //   962: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   965: aload 17
    //   967: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   970: aload 18
    //   972: invokeinterface 254 3 0
    //   977: ifne +14 -> 991
    //   980: new 93	java/lang/RuntimeException
    //   983: dup
    //   984: ldc_w 256
    //   987: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   990: athrow
    //   991: aload 17
    //   993: getfield 257	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZa	Ljava/lang/ref/WeakReference;
    //   996: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   999: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1002: astore 18
    //   1004: aload 18
    //   1006: ifnonnull +127 -> 1133
    //   1009: aload 17
    //   1011: aconst_null
    //   1012: putfield 261	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZb	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1015: aload 17
    //   1017: aconst_null
    //   1018: putfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1021: aload 17
    //   1023: getfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1026: ifnull +14 -> 1040
    //   1029: aload 17
    //   1031: getfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1034: getstatic 268	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   1037: if_acmpne +25 -> 1062
    //   1040: aload 17
    //   1042: aconst_null
    //   1043: putfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1046: ldc_w 270
    //   1049: aload 17
    //   1051: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1054: invokeinterface 274 1 0
    //   1059: invokestatic 278	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:aM	(Ljava/lang/String;I)V
    //   1062: ldc 135
    //   1064: new 137	java/lang/StringBuilder
    //   1067: dup
    //   1068: ldc_w 280
    //   1071: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1074: aload 17
    //   1076: getfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1079: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1082: ldc 148
    //   1084: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokestatic 216	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1090: invokevirtual 217	java/lang/Thread:getId	()J
    //   1093: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: iconst_0
    //   1100: anewarray 87	java/lang/Object
    //   1103: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1106: aload 17
    //   1108: aconst_null
    //   1109: putfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1112: aload_0
    //   1113: iconst_1
    //   1114: putfield 81	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZl	Z
    //   1117: iconst_1
    //   1118: istore 11
    //   1120: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   1123: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   1126: iload 11
    //   1128: istore 4
    //   1130: goto -465 -> 665
    //   1133: aload 17
    //   1135: aload 18
    //   1137: invokestatic 291	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:b	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$e;
    //   1140: aload 17
    //   1142: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1145: aload 17
    //   1147: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1150: invokeinterface 297 3 0
    //   1155: putfield 261	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZb	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1158: aload 17
    //   1160: aload 18
    //   1162: invokestatic 301	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:c	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$f;
    //   1165: aload 17
    //   1167: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1170: aload 17
    //   1172: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1175: aload 17
    //   1177: getfield 261	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZb	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1180: getstatic 268	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   1183: invokeinterface 306 5 0
    //   1188: putfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1191: goto -170 -> 1021
    //   1194: ldc 135
    //   1196: ldc_w 308
    //   1199: iconst_0
    //   1200: anewarray 87	java/lang/Object
    //   1203: invokestatic 311	com/tencent/magicbrush/a/d$f:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1206: iload 6
    //   1208: istore 11
    //   1210: iload_3
    //   1211: istore 6
    //   1213: iload 11
    //   1215: istore_3
    //   1216: aload_0
    //   1217: invokespecial 314	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afW	()Z
    //   1220: ifeq +32 -> 1252
    //   1223: ldc 135
    //   1225: ldc_w 316
    //   1228: iconst_1
    //   1229: anewarray 87	java/lang/Object
    //   1232: dup
    //   1233: iconst_0
    //   1234: aload_0
    //   1235: getfield 103	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:sn	Z
    //   1238: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1241: aastore
    //   1242: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1245: iload 9
    //   1247: istore 13
    //   1249: goto -1102 -> 147
    //   1252: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   1255: invokevirtual 325	java/lang/Object:wait	()V
    //   1258: iload 7
    //   1260: istore 11
    //   1262: goto -1179 -> 83
    //   1265: iload 6
    //   1267: istore 11
    //   1269: iload 6
    //   1271: ifeq +291 -> 1562
    //   1274: ldc 135
    //   1276: ldc_w 327
    //   1279: iconst_0
    //   1280: anewarray 87	java/lang/Object
    //   1283: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1286: aload_0
    //   1287: getfield 99	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZu	Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   1290: astore 16
    //   1292: ldc 135
    //   1294: new 137	java/lang/StringBuilder
    //   1297: dup
    //   1298: ldc_w 329
    //   1301: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1304: invokestatic 216	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1307: invokevirtual 217	java/lang/Thread:getId	()J
    //   1310: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: iconst_0
    //   1317: anewarray 87	java/lang/Object
    //   1320: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1323: aload 16
    //   1325: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1328: ifnonnull +14 -> 1342
    //   1331: new 93	java/lang/RuntimeException
    //   1334: dup
    //   1335: ldc_w 331
    //   1338: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1341: athrow
    //   1342: aload 16
    //   1344: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1347: ifnonnull +14 -> 1361
    //   1350: new 93	java/lang/RuntimeException
    //   1353: dup
    //   1354: ldc_w 333
    //   1357: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1360: athrow
    //   1361: aload 16
    //   1363: getfield 261	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZb	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1366: ifnonnull +14 -> 1380
    //   1369: new 93	java/lang/RuntimeException
    //   1372: dup
    //   1373: ldc_w 335
    //   1376: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1379: athrow
    //   1380: aload 16
    //   1382: invokevirtual 338	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:afQ	()V
    //   1385: aload 16
    //   1387: getfield 257	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZa	Ljava/lang/ref/WeakReference;
    //   1390: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1393: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1396: astore 17
    //   1398: aload 17
    //   1400: ifnull +833 -> 2233
    //   1403: aload 16
    //   1405: aload 17
    //   1407: invokestatic 342	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:d	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$h;
    //   1410: aload 16
    //   1412: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1415: aload 16
    //   1417: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1420: aload 16
    //   1422: getfield 261	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZb	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1425: aload 17
    //   1427: invokevirtual 346	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   1430: invokeinterface 352 5 0
    //   1435: putfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1438: aload 16
    //   1440: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1443: ifnull +14 -> 1457
    //   1446: aload 16
    //   1448: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1451: getstatic 355	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1454: if_acmpne +788 -> 2242
    //   1457: aload 16
    //   1459: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   1462: invokeinterface 274 1 0
    //   1467: sipush 12299
    //   1470: if_icmpne +15 -> 1485
    //   1473: ldc 135
    //   1475: ldc_w 357
    //   1478: iconst_0
    //   1479: anewarray 87	java/lang/Object
    //   1482: invokestatic 311	com/tencent/magicbrush/a/d$f:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1485: iconst_0
    //   1486: istore 9
    //   1488: iload 9
    //   1490: ifeq +824 -> 2314
    //   1493: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   1496: astore 16
    //   1498: aload 16
    //   1500: monitorenter
    //   1501: aload_0
    //   1502: iconst_1
    //   1503: putfield 78	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZn	Z
    //   1506: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   1509: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   1512: aload 16
    //   1514: monitorexit
    //   1515: iload 4
    //   1517: ifne +42 -> 1559
    //   1520: ldc 135
    //   1522: ldc_w 359
    //   1525: iconst_0
    //   1526: anewarray 87	java/lang/Object
    //   1529: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1532: aload_0
    //   1533: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1536: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1539: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1542: astore 16
    //   1544: aload 16
    //   1546: ifnull +13 -> 1559
    //   1549: aload 16
    //   1551: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   1554: invokeinterface 362 1 0
    //   1559: iconst_0
    //   1560: istore 11
    //   1562: iload 5
    //   1564: istore 6
    //   1566: iload 5
    //   1568: ifeq +127 -> 1695
    //   1571: ldc 135
    //   1573: ldc_w 364
    //   1576: iconst_0
    //   1577: anewarray 87	java/lang/Object
    //   1580: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1583: aload_0
    //   1584: getfield 99	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZu	Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   1587: astore 17
    //   1589: aload 17
    //   1591: getfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   1594: invokevirtual 368	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   1597: astore 16
    //   1599: aload 17
    //   1601: getfield 257	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZa	Ljava/lang/ref/WeakReference;
    //   1604: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1607: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1610: astore 17
    //   1612: aload 17
    //   1614: ifnull +78 -> 1692
    //   1617: aload 17
    //   1619: invokestatic 371	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$l;
    //   1622: ifnull +15 -> 1637
    //   1625: aload 17
    //   1627: invokestatic 371	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$l;
    //   1630: invokeinterface 376 1 0
    //   1635: astore 16
    //   1637: aload 17
    //   1639: invokestatic 380	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)I
    //   1642: iconst_3
    //   1643: iand
    //   1644: ifeq +48 -> 1692
    //   1647: iconst_0
    //   1648: istore 5
    //   1650: aload 17
    //   1652: invokestatic 380	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)I
    //   1655: iconst_1
    //   1656: iand
    //   1657: ifeq +6 -> 1663
    //   1660: iconst_1
    //   1661: istore 5
    //   1663: aload 17
    //   1665: invokestatic 380	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)I
    //   1668: iconst_2
    //   1669: iand
    //   1670: ifeq +761 -> 2431
    //   1673: new 382	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$m
    //   1676: dup
    //   1677: invokespecial 383	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$m:<init>	()V
    //   1680: astore 17
    //   1682: aload 16
    //   1684: iload 5
    //   1686: aload 17
    //   1688: invokestatic 389	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
    //   1691: pop
    //   1692: iconst_0
    //   1693: istore 6
    //   1695: iload 4
    //   1697: ifeq +28 -> 1725
    //   1700: aload_0
    //   1701: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1704: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1707: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1710: astore 16
    //   1712: aload 16
    //   1714: ifnull +11 -> 1725
    //   1717: aload 16
    //   1719: invokestatic 392	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:i	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/f/b;
    //   1722: invokevirtual 397	com/tencent/mm/plugin/appbrand/game/f/b:aho	()V
    //   1725: iload 4
    //   1727: istore 12
    //   1729: iload 4
    //   1731: ifeq +57 -> 1788
    //   1734: ldc 135
    //   1736: ldc_w 399
    //   1739: iconst_0
    //   1740: anewarray 87	java/lang/Object
    //   1743: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1746: aload_0
    //   1747: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1750: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1753: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1756: astore 16
    //   1758: aload 16
    //   1760: ifnull +25 -> 1785
    //   1763: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1766: invokevirtual 408	com/tencent/mm/plugin/appbrand/game/h:agi	()V
    //   1769: aload 16
    //   1771: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   1774: invokeinterface 411 1 0
    //   1779: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1782: invokevirtual 414	com/tencent/mm/plugin/appbrand/game/h:agj	()V
    //   1785: iconst_0
    //   1786: istore 12
    //   1788: iload_3
    //   1789: istore 4
    //   1791: iload_3
    //   1792: ifeq +99 -> 1891
    //   1795: ldc 135
    //   1797: new 137	java/lang/StringBuilder
    //   1800: dup
    //   1801: ldc_w 416
    //   1804: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1807: iload 13
    //   1809: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1812: ldc_w 421
    //   1815: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: iload 10
    //   1820: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1823: ldc_w 423
    //   1826: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: iconst_0
    //   1833: anewarray 87	java/lang/Object
    //   1836: invokestatic 220	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1839: aload_0
    //   1840: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1843: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1846: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1849: astore 16
    //   1851: aload 16
    //   1853: ifnull +35 -> 1888
    //   1856: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1859: invokevirtual 426	com/tencent/mm/plugin/appbrand/game/h:agk	()V
    //   1862: aload 16
    //   1864: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   1867: iload 13
    //   1869: iload 10
    //   1871: invokeinterface 430 3 0
    //   1876: ldc 135
    //   1878: ldc_w 432
    //   1881: iconst_0
    //   1882: anewarray 87	java/lang/Object
    //   1885: invokestatic 311	com/tencent/magicbrush/a/d$f:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1888: iconst_0
    //   1889: istore 4
    //   1891: aload_0
    //   1892: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1895: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1898: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1901: astore 16
    //   1903: aload 16
    //   1905: ifnull +32 -> 1937
    //   1908: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1911: invokevirtual 435	com/tencent/mm/plugin/appbrand/game/h:agm	()V
    //   1914: aload 16
    //   1916: invokestatic 128	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   1919: iconst_0
    //   1920: invokeinterface 439 2 0
    //   1925: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1928: invokevirtual 442	com/tencent/mm/plugin/appbrand/game/h:onDrawFrame	()V
    //   1931: getstatic 405	com/tencent/mm/plugin/appbrand/game/h:fZZ	Lcom/tencent/mm/plugin/appbrand/game/h;
    //   1934: invokevirtual 445	com/tencent/mm/plugin/appbrand/game/h:agl	()V
    //   1937: aload_0
    //   1938: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1941: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1944: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1947: astore 16
    //   1949: aload 16
    //   1951: ifnull +16 -> 1967
    //   1954: aload 16
    //   1956: invokestatic 392	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:i	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/f/b;
    //   1959: aload 16
    //   1961: invokevirtual 448	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:getIsSwapNow	()Z
    //   1964: invokevirtual 451	com/tencent/mm/plugin/appbrand/game/f/b:cV	(Z)V
    //   1967: sipush 12288
    //   1970: istore_3
    //   1971: iconst_1
    //   1972: istore 14
    //   1974: aload_0
    //   1975: getfield 68	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZa	Ljava/lang/ref/WeakReference;
    //   1978: invokevirtual 124	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1981: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   1984: astore 16
    //   1986: aload 16
    //   1988: ifnull +10 -> 1998
    //   1991: aload 16
    //   1993: invokevirtual 448	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:getIsSwapNow	()Z
    //   1996: istore 14
    //   1998: iload 14
    //   2000: ifeq +101 -> 2101
    //   2003: aload_0
    //   2004: getfield 99	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZu	Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   2007: astore 17
    //   2009: sipush 12288
    //   2012: istore 5
    //   2014: iload 5
    //   2016: istore_3
    //   2017: aload 17
    //   2019: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2022: ifnull +79 -> 2101
    //   2025: iload 5
    //   2027: istore_3
    //   2028: aload 17
    //   2030: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2033: getstatic 247	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2036: if_acmpeq +65 -> 2101
    //   2039: iload 5
    //   2041: istore_3
    //   2042: aload 17
    //   2044: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2047: ifnull +54 -> 2101
    //   2050: iload 5
    //   2052: istore_3
    //   2053: aload 17
    //   2055: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2058: getstatic 355	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2061: if_acmpeq +40 -> 2101
    //   2064: iload 5
    //   2066: istore_3
    //   2067: aload 17
    //   2069: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   2072: aload 17
    //   2074: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2077: aload 17
    //   2079: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2082: invokeinterface 455 3 0
    //   2087: ifne +14 -> 2101
    //   2090: aload 17
    //   2092: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   2095: invokeinterface 274 1 0
    //   2100: istore_3
    //   2101: aload 16
    //   2103: ifnull +9 -> 2112
    //   2106: aload 16
    //   2108: iconst_1
    //   2109: invokevirtual 458	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:setSwapNow	(Z)V
    //   2112: iload 7
    //   2114: istore 5
    //   2116: iload_3
    //   2117: lookupswitch	default:+27->2144, 12288:+63->2180, 12302:+268->2385
    //   2145: aconst_null
    //   2146: <illegal opcode>
    //   2147: ldc_w 461
    //   2150: iload_3
    //   2151: invokestatic 465	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:m	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2154: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   2157: astore 17
    //   2159: aload 17
    //   2161: monitorenter
    //   2162: aload_0
    //   2163: iconst_1
    //   2164: putfield 188	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZj	Z
    //   2167: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   2170: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   2173: aload 17
    //   2175: monitorexit
    //   2176: iload 7
    //   2178: istore 5
    //   2180: aload 16
    //   2182: ifnull +11 -> 2193
    //   2185: aload 16
    //   2187: invokestatic 392	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:i	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/f/b;
    //   2190: invokevirtual 397	com/tencent/mm/plugin/appbrand/game/f/b:aho	()V
    //   2193: iload 8
    //   2195: ifeq +233 -> 2428
    //   2198: iconst_1
    //   2199: istore_1
    //   2200: iconst_0
    //   2201: istore 8
    //   2203: aload_0
    //   2204: invokespecial 468	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:afU	()V
    //   2207: iload 13
    //   2209: istore 9
    //   2211: iload 4
    //   2213: istore_3
    //   2214: iload 5
    //   2216: istore 7
    //   2218: iload 6
    //   2220: istore 5
    //   2222: iload 12
    //   2224: istore 4
    //   2226: iload 11
    //   2228: istore 6
    //   2230: goto -2159 -> 71
    //   2233: aload 16
    //   2235: aconst_null
    //   2236: putfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2239: goto -801 -> 1438
    //   2242: aload 16
    //   2244: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   2247: aload 16
    //   2249: getfield 244	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2252: aload 16
    //   2254: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2257: aload 16
    //   2259: getfield 287	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwK	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2262: aload 16
    //   2264: getfield 265	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   2267: invokeinterface 472 5 0
    //   2272: ifne +28 -> 2300
    //   2275: ldc_w 474
    //   2278: ldc_w 475
    //   2281: aload 16
    //   2283: getfield 232	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   2286: invokeinterface 274 1 0
    //   2291: invokestatic 465	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:m	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2294: iconst_0
    //   2295: istore 9
    //   2297: goto -809 -> 1488
    //   2300: iconst_1
    //   2301: istore 9
    //   2303: goto -815 -> 1488
    //   2306: astore 15
    //   2308: aload 16
    //   2310: monitorexit
    //   2311: aload 15
    //   2313: athrow
    //   2314: ldc 135
    //   2316: ldc_w 477
    //   2319: iconst_0
    //   2320: anewarray 87	java/lang/Object
    //   2323: invokestatic 311	com/tencent/magicbrush/a/d$f:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2326: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   2329: astore 16
    //   2331: aload 16
    //   2333: monitorenter
    //   2334: aload_0
    //   2335: iconst_1
    //   2336: putfield 78	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZn	Z
    //   2339: aload_0
    //   2340: iconst_1
    //   2341: putfield 188	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:fZj	Z
    //   2344: invokestatic 85	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:afP	()Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$k;
    //   2347: invokevirtual 90	java/lang/Object:notifyAll	()V
    //   2350: aload 16
    //   2352: monitorexit
    //   2353: iload 13
    //   2355: istore 9
    //   2357: goto -2286 -> 71
    //   2360: astore 15
    //   2362: aload 16
    //   2364: monitorexit
    //   2365: aload 15
    //   2367: athrow
    //   2368: astore 15
    //   2370: ldc 135
    //   2372: ldc_w 432
    //   2375: iconst_0
    //   2376: anewarray 87	java/lang/Object
    //   2379: invokestatic 311	com/tencent/magicbrush/a/d$f:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2382: aload 15
    //   2384: athrow
    //   2385: ldc 135
    //   2387: new 137	java/lang/StringBuilder
    //   2390: dup
    //   2391: ldc_w 479
    //   2394: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2397: aload_0
    //   2398: invokevirtual 155	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   2401: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2404: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2407: iconst_0
    //   2408: anewarray 87	java/lang/Object
    //   2411: invokestatic 168	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2414: iconst_1
    //   2415: istore 5
    //   2417: goto -237 -> 2180
    //   2420: astore 15
    //   2422: aload 17
    //   2424: monitorexit
    //   2425: aload 15
    //   2427: athrow
    //   2428: goto -225 -> 2203
    //   2431: aconst_null
    //   2432: astore 17
    //   2434: goto -752 -> 1682
    //   2437: iload 9
    //   2439: istore 13
    //   2441: iload 11
    //   2443: istore_3
    //   2444: goto -2297 -> 147
    //   2447: iload 6
    //   2449: istore 11
    //   2451: iload_3
    //   2452: istore 6
    //   2454: iload 11
    //   2456: istore_3
    //   2457: goto -1754 -> 703
    //   2460: goto -1244 -> 1216
    //   2463: goto -1833 -> 630
    //   2466: iconst_0
    //   2467: istore 14
    //   2469: goto -2194 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2472	0	this	j
    //   59	2141	1	i	int
    //   61	604	2	j	int
    //   54	2403	3	k	int
    //   42	2183	4	m	int
    //   48	2368	5	n	int
    //   45	2408	6	i1	int
    //   51	2166	7	i2	int
    //   56	2146	8	i3	int
    //   63	2375	9	i4	int
    //   66	1804	10	i5	int
    //   81	2374	11	i6	int
    //   1727	496	12	i7	int
    //   145	2295	13	i8	int
    //   187	2281	14	bool	boolean
    //   28	136	15	localObject1	Object
    //   840	6	15	localObject2	Object
    //   944	9	15	localRuntimeException	java.lang.RuntimeException
    //   2306	6	15	localObject3	Object
    //   2360	6	15	localObject4	Object
    //   2368	15	15	localObject5	Object
    //   2420	6	15	localObject6	Object
    //   74	17	16	localk	GameGLSurfaceView.k
    //   94	749	16	localObject7	Object
    //   958	203	18	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	94	finally
    //   96	99	94	finally
    //   83	93	840	finally
    //   102	139	840	finally
    //   147	150	840	finally
    //   172	197	840	finally
    //   202	214	840	finally
    //   219	229	840	finally
    //   229	275	840	finally
    //   275	323	840	finally
    //   334	342	840	finally
    //   350	389	840	finally
    //   394	413	840	finally
    //   426	458	840	finally
    //   458	511	840	finally
    //   511	527	840	finally
    //   527	580	840	finally
    //   584	628	840	finally
    //   630	637	840	finally
    //   641	659	840	finally
    //   665	695	840	finally
    //   703	710	840	finally
    //   710	717	840	finally
    //   720	765	840	finally
    //   767	772	840	finally
    //   779	797	840	finally
    //   810	822	840	finally
    //   827	837	840	finally
    //   842	845	840	finally
    //   848	855	840	finally
    //   858	944	840	finally
    //   946	955	840	finally
    //   955	991	840	finally
    //   991	1004	840	finally
    //   1009	1021	840	finally
    //   1021	1040	840	finally
    //   1040	1062	840	finally
    //   1062	1112	840	finally
    //   1112	1117	840	finally
    //   1120	1126	840	finally
    //   1133	1191	840	finally
    //   1194	1206	840	finally
    //   1216	1245	840	finally
    //   1252	1258	840	finally
    //   858	944	944	java/lang/RuntimeException
    //   955	991	944	java/lang/RuntimeException
    //   991	1004	944	java/lang/RuntimeException
    //   1009	1021	944	java/lang/RuntimeException
    //   1021	1040	944	java/lang/RuntimeException
    //   1040	1062	944	java/lang/RuntimeException
    //   1062	1112	944	java/lang/RuntimeException
    //   1133	1191	944	java/lang/RuntimeException
    //   1501	1515	2306	finally
    //   2308	2311	2306	finally
    //   2334	2353	2360	finally
    //   2362	2365	2360	finally
    //   1856	1876	2368	finally
    //   2162	2176	2420	finally
    //   2422	2425	2420	finally
  }
  
  private void afU()
  {
    Object localObject1 = null;
    synchronized (GameGLSurfaceView.afP())
    {
      if (!afW()) {
        return;
      }
      if (this.fZg)
      {
        this.fZg = false;
        d.f.i("MicroMsg.GLThread", "Request leave PAUSE_ALSO_DO_DRAW", new Object[0]);
        return;
      }
    }
    if (!this.fZs.isEmpty()) {
      ??? = (Runnable)this.fZs.remove(0);
    }
    for (;;)
    {
      for (;;)
      {
        if (??? != null)
        {
          ((Runnable)???).run();
          ??? = null;
          break;
        }
        ??? = (GameGLSurfaceView)this.fZa.get();
        if (??? != null) {
          try
          {
            GameGLSurfaceView.g((GameGLSurfaceView)???).cR(true);
            GameGLSurfaceView.i((GameGLSurfaceView)???).cV(false);
            GameGLSurfaceView.i((GameGLSurfaceView)???).aho();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              d.f.e("MicroMsg.GLThread", Log.getStackTraceString(localException) + " readyToPauseAlsoDoDraw while() ", new Object[0]);
            }
          }
        }
      }
      synchronized (GameGLSurfaceView.afP())
      {
        this.fZc = true;
        return;
      }
    }
  }
  
  private boolean afW()
  {
    return (this.sn) && (this.fZh) && (this.mWidth > 0) && (this.mHeight > 0) && ((!this.fZp) || (this.mRenderMode == 1));
  }
  
  final boolean afV()
  {
    return (!this.sn) && (this.fZi) && (!this.fZj) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.fZp) || (this.mRenderMode == 1));
  }
  
  public final void afX()
  {
    synchronized ()
    {
      d.f.i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId(), new Object[0]);
      this.fZc = true;
      this.fZe = true;
      this.fZg = true;
      GameGLSurfaceView.afP().notifyAll();
      for (;;)
      {
        boolean bool = this.fZd;
        if (!bool) {
          try
          {
            GameGLSurfaceView.afP().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public final int getRenderMode()
  {
    synchronized ()
    {
      int i = this.mRenderMode;
      return i;
    }
  }
  
  public final void run()
  {
    setName("MicroMsg.GLThread" + getId());
    d.f.i("MicroMsg.GLThread", "starting tid=" + getId(), new Object[0]);
    h.fZZ.agg();
    try
    {
      afT();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        h localh;
        d.f.e("MicroMsg.GLThread", Log.getStackTraceString(localInterruptedException) + " hy: InterruptedException", new Object[0]);
        GameGLSurfaceView.afP().f(this);
      }
    }
    catch (Exception localException)
    {
      d.f.e("MicroMsg.GLThread", " GLThread#run() stack = [%s]", new Object[] { Log.getStackTraceString(localException) });
      throw localException;
    }
    finally
    {
      GameGLSurfaceView.afP().f(this);
    }
    h.fZZ.agh();
    localh = h.fZZ;
    localh.gaa.clear();
    localh.gab = null;
  }
  
  public final void setRenderMode(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GameGLSurfaceView.afP())
    {
      this.mRenderMode = paramInt;
      GameGLSurfaceView.afP().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j
 * JD-Core Version:    0.7.0.1
 */