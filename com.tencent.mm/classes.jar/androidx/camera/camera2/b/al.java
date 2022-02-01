package androidx.camera.camera2.b;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.b.a.b.j;
import androidx.camera.camera2.b.a.b.n;
import androidx.camera.camera2.b.a.c.d;
import androidx.camera.camera2.b.a.c.e;
import androidx.camera.camera2.b.a.c.i;
import androidx.camera.camera2.b.a.c.k;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.bf;
import androidx.camera.core.impl.bg;
import androidx.camera.core.impl.bg.a;
import androidx.camera.core.impl.bg.b;
import androidx.camera.core.impl.bh;
import androidx.camera.core.impl.bk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class al
{
  private static final Size DN;
  private static final Size DO;
  private static final Size DP;
  private static final Size DQ;
  private static final Rational DR;
  private static final Rational DS;
  private static final Rational DT;
  private static final Rational DU;
  private final String AW;
  private final c BR;
  private final ae BW;
  private final List<bf> DV;
  private final Map<Integer, Size> DW;
  private final androidx.camera.camera2.b.a.h DX;
  private final d DY;
  private final e DZ;
  private final int Ea;
  private final boolean Eb;
  private final Map<Integer, List<Size>> Ec;
  private boolean Ed;
  private boolean Ee;
  private bh Ef;
  private Map<Integer, Size[]> Eg;
  private final i Eh;
  
  static
  {
    AppMethodBeat.i(197628);
    DN = new Size(640, 480);
    DO = new Size(0, 0);
    DP = new Size(1920, 1080);
    DQ = new Size(720, 480);
    DR = new Rational(4, 3);
    DS = new Rational(3, 4);
    DT = new Rational(16, 9);
    DU = new Rational(9, 16);
    AppMethodBeat.o(197628);
  }
  
  /* Error */
  al(android.content.Context paramContext, String paramString, androidx.camera.camera2.b.a.n paramn, c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 92	java/lang/Object:<init>	()V
    //   4: ldc 93
    //   6: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: new 95	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 96	java/util/ArrayList:<init>	()V
    //   17: putfield 98	androidx/camera/camera2/b/al:DV	Ljava/util/List;
    //   20: aload_0
    //   21: new 100	java/util/HashMap
    //   24: dup
    //   25: invokespecial 101	java/util/HashMap:<init>	()V
    //   28: putfield 103	androidx/camera/camera2/b/al:DW	Ljava/util/Map;
    //   31: aload_0
    //   32: new 100	java/util/HashMap
    //   35: dup
    //   36: invokespecial 101	java/util/HashMap:<init>	()V
    //   39: putfield 105	androidx/camera/camera2/b/al:Ec	Ljava/util/Map;
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 107	androidx/camera/camera2/b/al:Ed	Z
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 109	androidx/camera/camera2/b/al:Ee	Z
    //   52: aload_0
    //   53: new 100	java/util/HashMap
    //   56: dup
    //   57: invokespecial 101	java/util/HashMap:<init>	()V
    //   60: putfield 111	androidx/camera/camera2/b/al:Eg	Ljava/util/Map;
    //   63: aload_0
    //   64: new 113	androidx/camera/camera2/b/a/c/i
    //   67: dup
    //   68: invokespecial 114	androidx/camera/camera2/b/a/c/i:<init>	()V
    //   71: putfield 116	androidx/camera/camera2/b/al:Eh	Landroidx/camera/camera2/b/a/c/i;
    //   74: aload_0
    //   75: aload_2
    //   76: invokestatic 122	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 124	java/lang/String
    //   82: putfield 126	androidx/camera/camera2/b/al:AW	Ljava/lang/String;
    //   85: aload_0
    //   86: aload 4
    //   88: invokestatic 122	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 128	androidx/camera/camera2/b/c
    //   94: putfield 130	androidx/camera/camera2/b/al:BR	Landroidx/camera/camera2/b/c;
    //   97: aload_0
    //   98: new 132	androidx/camera/camera2/b/a/c/d
    //   101: dup
    //   102: aload_2
    //   103: invokespecial 135	androidx/camera/camera2/b/a/c/d:<init>	(Ljava/lang/String;)V
    //   106: putfield 137	androidx/camera/camera2/b/al:DY	Landroidx/camera/camera2/b/a/c/d;
    //   109: aload_0
    //   110: new 139	androidx/camera/camera2/b/a/c/e
    //   113: dup
    //   114: invokespecial 140	androidx/camera/camera2/b/a/c/e:<init>	()V
    //   117: putfield 142	androidx/camera/camera2/b/al:DZ	Landroidx/camera/camera2/b/a/c/e;
    //   120: aload_0
    //   121: aload_1
    //   122: invokestatic 148	androidx/camera/camera2/b/ae:N	(Landroid/content/Context;)Landroidx/camera/camera2/b/ae;
    //   125: putfield 150	androidx/camera/camera2/b/al:BW	Landroidx/camera/camera2/b/ae;
    //   128: aload_0
    //   129: aload_3
    //   130: aload_0
    //   131: getfield 126	androidx/camera/camera2/b/al:AW	Ljava/lang/String;
    //   134: invokevirtual 156	androidx/camera/camera2/b/a/n:H	(Ljava/lang/String;)Landroidx/camera/camera2/b/a/h;
    //   137: putfield 158	androidx/camera/camera2/b/al:DX	Landroidx/camera/camera2/b/a/h;
    //   140: aload_0
    //   141: getfield 158	androidx/camera/camera2/b/al:DX	Landroidx/camera/camera2/b/a/h;
    //   144: getstatic 164	android/hardware/camera2/CameraCharacteristics:INFO_SUPPORTED_HARDWARE_LEVEL	Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   147: invokevirtual 169	androidx/camera/camera2/b/a/h:a	(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   150: checkcast 171	java/lang/Integer
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +67 -> 222
    //   158: aload_1
    //   159: invokevirtual 175	java/lang/Integer:intValue	()I
    //   162: istore 5
    //   164: aload_0
    //   165: iload 5
    //   167: putfield 177	androidx/camera/camera2/b/al:Ea	I
    //   170: aload_0
    //   171: getfield 158	androidx/camera/camera2/b/al:DX	Landroidx/camera/camera2/b/a/h;
    //   174: getstatic 180	android/hardware/camera2/CameraCharacteristics:SENSOR_INFO_PIXEL_ARRAY_SIZE	Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   177: invokevirtual 169	androidx/camera/camera2/b/a/h:a	(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   180: checkcast 60	android/util/Size
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +43 -> 228
    //   188: aload_1
    //   189: invokevirtual 183	android/util/Size:getWidth	()I
    //   192: aload_1
    //   193: invokevirtual 186	android/util/Size:getHeight	()I
    //   196: if_icmpge +32 -> 228
    //   199: iconst_0
    //   200: istore 6
    //   202: aload_0
    //   203: iload 6
    //   205: putfield 188	androidx/camera/camera2/b/al:Eb	Z
    //   208: aload_0
    //   209: invokespecial 191	androidx/camera/camera2/b/al:hz	()V
    //   212: aload_0
    //   213: invokespecial 194	androidx/camera/camera2/b/al:hA	()V
    //   216: ldc 93
    //   218: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: iconst_2
    //   223: istore 5
    //   225: goto -61 -> 164
    //   228: iconst_1
    //   229: istore 6
    //   231: goto -29 -> 202
    //   234: astore_1
    //   235: aload_1
    //   236: invokestatic 199	androidx/camera/camera2/b/w:a	(Landroidx/camera/camera2/b/a/b;)Landroidx/camera/core/s;
    //   239: astore_1
    //   240: ldc 93
    //   242: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_1
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	al
    //   0	247	1	paramContext	android.content.Context
    //   0	247	2	paramString	String
    //   0	247	3	paramn	androidx.camera.camera2.b.a.n
    //   0	247	4	paramc	c
    //   162	62	5	i	int
    //   200	30	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   128	154	234	androidx/camera/camera2/b/a/b
    //   158	164	234	androidx/camera/camera2/b/a/b
    //   164	184	234	androidx/camera/camera2/b/a/b
    //   188	199	234	androidx/camera/camera2/b/a/b
    //   202	208	234	androidx/camera/camera2/b/a/b
  }
  
  private static Map<Rational, List<Size>> A(List<Size> paramList)
  {
    AppMethodBeat.i(197523);
    HashMap localHashMap = new HashMap();
    localHashMap.put(DR, new ArrayList());
    localHashMap.put(DT, new ArrayList());
    Iterator localIterator1 = paramList.iterator();
    Size localSize;
    label96:
    Rational localRational;
    boolean bool;
    if (localIterator1.hasNext())
    {
      localSize = (Size)localIterator1.next();
      paramList = null;
      Iterator localIterator2 = localHashMap.keySet().iterator();
      if (localIterator2.hasNext())
      {
        localRational = (Rational)localIterator2.next();
        if (localRational != null) {
          if (localRational.equals(new Rational(localSize.getWidth(), localSize.getHeight()))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      label150:
      Object localObject;
      if (bool)
      {
        localObject = (List)localHashMap.get(localRational);
        paramList = localRational;
        if (!((List)localObject).contains(localSize))
        {
          ((List)localObject).add(localSize);
          paramList = localRational;
        }
      }
      for (;;)
      {
        break label96;
        if (a(localSize) < a(DN)) {
          break label398;
        }
        int i = localSize.getWidth();
        int j = localSize.getHeight();
        localObject = new Rational(localRational.getDenominator(), localRational.getNumerator());
        if ((i % 16 == 0) && (j % 16 == 0))
        {
          if ((a(Math.max(0, j - 16), i, localRational)) || (a(Math.max(0, i - 16), j, (Rational)localObject)))
          {
            bool = true;
            break label150;
          }
          bool = false;
          break label150;
        }
        if (i % 16 == 0)
        {
          bool = a(j, i, localRational);
          break label150;
        }
        if (j % 16 == 0)
        {
          bool = a(i, j, (Rational)localObject);
          break label150;
        }
        bool = false;
        break label150;
        if (paramList != null) {
          break;
        }
        localHashMap.put(new Rational(localSize.getWidth(), localSize.getHeight()), new ArrayList(Collections.singleton(localSize)));
        break;
        AppMethodBeat.o(197523);
        return localHashMap;
      }
      label398:
      bool = false;
    }
  }
  
  private static List<List<Size>> B(List<List<Size>> paramList)
  {
    AppMethodBeat.i(197536);
    Object localObject = paramList.iterator();
    for (int j = 1; ((Iterator)localObject).hasNext(); j = ((List)((Iterator)localObject).next()).size() * j) {}
    if (j == 0)
    {
      paramList = new IllegalArgumentException("Failed to find supported resolutions.");
      AppMethodBeat.o(197536);
      throw paramList;
    }
    localObject = new ArrayList();
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(new ArrayList());
      i += 1;
    }
    i = j / ((List)paramList.get(0)).size();
    int m = 0;
    int k = j;
    int n;
    if (m < paramList.size())
    {
      List localList = (List)paramList.get(m);
      n = 0;
      while (n < j)
      {
        ((List)((List)localObject).get(n)).add((Size)localList.get(n % k / i));
        n += 1;
      }
      if (m >= paramList.size() - 1) {
        break label267;
      }
      k = i / ((List)paramList.get(m + 1)).size();
    }
    for (;;)
    {
      m += 1;
      n = i;
      i = k;
      k = n;
      break;
      AppMethodBeat.o(197536);
      return localObject;
      label267:
      n = k;
      k = i;
      i = n;
    }
  }
  
  private static int a(Size paramSize)
  {
    AppMethodBeat.i(197510);
    int i = paramSize.getWidth();
    int j = paramSize.getHeight();
    AppMethodBeat.o(197510);
    return i * j;
  }
  
  private Rational a(androidx.camera.core.impl.al paramal)
  {
    AppMethodBeat.i(197458);
    new k();
    Object localObject = this.DX;
    int i;
    if ((n)androidx.camera.camera2.b.a.b.h.f(n.class) != null)
    {
      i = n.jdMethod_if();
      switch (i)
      {
      default: 
        label68:
        paramal = null;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(197458);
      return paramal;
      if ((androidx.camera.camera2.b.a.b.b)androidx.camera.camera2.b.a.b.f.d((androidx.camera.camera2.b.a.h)localObject).f(androidx.camera.camera2.b.a.b.b.class) != null)
      {
        i = androidx.camera.camera2.b.a.b.b.jdMethod_if();
        break;
      }
      i = 3;
      break;
      if (this.Eb)
      {
        paramal = DR;
      }
      else
      {
        paramal = DS;
        continue;
        if (this.Eb)
        {
          paramal = DT;
        }
        else
        {
          paramal = DU;
          continue;
          paramal = aJ(256);
          paramal = new Rational(paramal.getWidth(), paramal.getHeight());
          continue;
          localObject = b(paramal);
          if (paramal.km())
          {
            i = paramal.kn();
            switch (i)
            {
            default: 
              "Undefined target aspect ratio: ".concat(String.valueOf(i));
              androidx.camera.core.al.T("SupportedSurfaceCombination");
              paramal = null;
              break;
            case 0: 
              if (this.Eb)
              {
                paramal = DR;
                continue;
              }
              paramal = DS;
              break;
            case 1: 
              if (this.Eb)
              {
                paramal = DT;
                continue;
              }
              paramal = DU;
              break;
            }
          }
          else
          {
            if (localObject == null) {
              break label68;
            }
            paramal = new Rational(((Size)localObject).getWidth(), ((Size)localObject).getHeight());
          }
        }
      }
    }
  }
  
  private Size a(Size paramSize, int paramInt)
  {
    AppMethodBeat.i(197499);
    Size localSize = paramSize;
    if (paramSize != null)
    {
      localSize = paramSize;
      if (aL(paramInt)) {
        localSize = new Size(paramSize.getHeight(), paramSize.getWidth());
      }
    }
    AppMethodBeat.o(197499);
    return localSize;
  }
  
  private List<Size> a(bk<?> parambk)
  {
    AppMethodBeat.i(197485);
    int j = parambk.ki();
    androidx.camera.core.impl.al localal = (androidx.camera.core.impl.al)parambk;
    Object localObject1 = localal.ks();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Pair)((Iterator)localObject1).next();
      } while (((Integer)((Pair)localObject2).first).intValue() != j);
    }
    for (Object localObject2 = (Size[])((Pair)localObject2).second;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = a((Size[])localObject2, j);
        Arrays.sort((Object[])localObject1, new androidx.camera.core.impl.a.c(true));
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aM(j);
      }
      ArrayList localArrayList = new ArrayList();
      localObject1 = localal.kr();
      Object localObject4 = aO(j);
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (a((Size)localObject4) >= a((Size)localObject1)) {}
      }
      else
      {
        localObject3 = localObject4;
      }
      Arrays.sort((Object[])localObject2, new androidx.camera.core.impl.a.c(true));
      localObject4 = b(localal);
      Object localObject5 = DN;
      int i = a(DN);
      if (a((Size)localObject3) < i) {
        localObject1 = DO;
      }
      for (;;)
      {
        int k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localObject5 = localObject2[i];
          if ((a((Size)localObject5) <= a((Size)localObject3)) && (a((Size)localObject5) >= a((Size)localObject1)) && (!localArrayList.contains(localObject5))) {
            localArrayList.add(localObject5);
          }
          i += 1;
        }
        localObject1 = localObject5;
        if (localObject4 != null)
        {
          localObject1 = localObject5;
          if (a((Size)localObject4) < i) {
            localObject1 = localObject4;
          }
        }
      }
      if (localArrayList.isEmpty())
      {
        parambk = new IllegalArgumentException("Can not get supported output size under supported maximum for the format: ".concat(String.valueOf(j)));
        AppMethodBeat.o(197485);
        throw parambk;
      }
      localObject2 = a(localal);
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = localal.kq();
      }
      Object localObject3 = new ArrayList();
      new HashMap();
      if (localObject2 == null)
      {
        ((List)localObject3).addAll(localArrayList);
        if (localObject1 != null) {
          a((List)localObject3, (Size)localObject1);
        }
      }
      for (;;)
      {
        parambk = this.Eh.a(aK(parambk.ki()), (List)localObject3);
        AppMethodBeat.o(197485);
        return parambk;
        localObject4 = A(localArrayList);
        if (localObject1 != null)
        {
          localObject5 = ((Map)localObject4).keySet().iterator();
          while (((Iterator)localObject5).hasNext()) {
            a((List)((Map)localObject4).get((Rational)((Iterator)localObject5).next()), (Size)localObject1);
          }
        }
        localObject1 = new ArrayList(((Map)localObject4).keySet());
        Collections.sort((List)localObject1, new a((Rational)localObject2));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((List)((Map)localObject4).get((Rational)((Iterator)localObject1).next())).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (Size)((Iterator)localObject2).next();
            if (!((List)localObject3).contains(localObject5)) {
              ((List)localObject3).add(localObject5);
            }
          }
        }
      }
    }
  }
  
  private static void a(List<Size> paramList, Size paramSize)
  {
    AppMethodBeat.i(197529);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(197529);
      return;
    }
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Size localSize = (Size)paramList.get(i);
      if ((localSize.getWidth() < paramSize.getWidth()) || (localSize.getHeight() < paramSize.getHeight())) {
        break;
      }
      if (j >= 0) {
        localArrayList.add((Size)paramList.get(j));
      }
      j = i;
      i += 1;
    }
    paramList.removeAll(localArrayList);
    AppMethodBeat.o(197529);
  }
  
  private static boolean a(int paramInt1, int paramInt2, Rational paramRational)
  {
    AppMethodBeat.i(197515);
    if (paramInt2 % 16 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      androidx.core.f.f.checkArgument(bool);
      double d = paramRational.getNumerator() * paramInt1 / paramRational.getDenominator();
      if ((d <= Math.max(0, paramInt2 - 16)) || (d >= paramInt2 + 16)) {
        break;
      }
      AppMethodBeat.o(197515);
      return true;
    }
    AppMethodBeat.o(197515);
    return false;
  }
  
  private Size[] a(Size[] paramArrayOfSize, int paramInt)
  {
    AppMethodBeat.i(197543);
    List localList = aP(paramInt);
    paramArrayOfSize = new ArrayList(Arrays.asList(paramArrayOfSize));
    paramArrayOfSize.removeAll(localList);
    paramArrayOfSize = (Size[])paramArrayOfSize.toArray(new Size[0]);
    AppMethodBeat.o(197543);
    return paramArrayOfSize;
  }
  
  private Size aJ(int paramInt)
  {
    AppMethodBeat.i(197464);
    Size localSize = (Size)this.DW.get(Integer.valueOf(paramInt));
    if (localSize != null)
    {
      AppMethodBeat.o(197464);
      return localSize;
    }
    localSize = aO(paramInt);
    this.DW.put(Integer.valueOf(paramInt), localSize);
    AppMethodBeat.o(197464);
    return localSize;
  }
  
  private static bg.b aK(int paramInt)
  {
    if (paramInt == 35) {
      return bg.b.Nx;
    }
    if (paramInt == 256) {
      return bg.b.Ny;
    }
    if (paramInt == 32) {
      return bg.b.Nz;
    }
    return bg.b.Nw;
  }
  
  private boolean aL(int paramInt)
  {
    AppMethodBeat.i(197505);
    Integer localInteger1 = (Integer)this.DX.a(CameraCharacteristics.SENSOR_ORIENTATION);
    androidx.core.f.f.checkNotNull(localInteger1, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
    paramInt = androidx.camera.core.impl.a.b.aY(paramInt);
    Integer localInteger2 = (Integer)this.DX.a(CameraCharacteristics.LENS_FACING);
    androidx.core.f.f.checkNotNull(localInteger2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
    if (1 == localInteger2.intValue()) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = androidx.camera.core.impl.a.b.c(paramInt, localInteger1.intValue(), bool);
      if ((paramInt != 90) && (paramInt != 270)) {
        break;
      }
      AppMethodBeat.o(197505);
      return true;
    }
    AppMethodBeat.o(197505);
    return false;
  }
  
  private Size[] aM(int paramInt)
  {
    AppMethodBeat.i(197551);
    Size[] arrayOfSize2 = (Size[])this.Eg.get(Integer.valueOf(paramInt));
    Size[] arrayOfSize1 = arrayOfSize2;
    if (arrayOfSize2 == null)
    {
      arrayOfSize1 = aN(paramInt);
      this.Eg.put(Integer.valueOf(paramInt), arrayOfSize1);
    }
    AppMethodBeat.o(197551);
    return arrayOfSize1;
  }
  
  private Size[] aN(int paramInt)
  {
    AppMethodBeat.i(197558);
    Object localObject = (StreamConfigurationMap)this.DX.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (localObject == null)
    {
      localObject = new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
      AppMethodBeat.o(197558);
      throw ((Throwable)localObject);
    }
    if ((Build.VERSION.SDK_INT < 23) && (paramInt == 34)) {}
    for (localObject = ((StreamConfigurationMap)localObject).getOutputSizes(SurfaceTexture.class); localObject == null; localObject = ((StreamConfigurationMap)localObject).getOutputSizes(paramInt))
    {
      localObject = new IllegalArgumentException("Can not get supported output size for the format: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(197558);
      throw ((Throwable)localObject);
    }
    localObject = a((Size[])localObject, paramInt);
    Arrays.sort((Object[])localObject, new androidx.camera.core.impl.a.c(true));
    AppMethodBeat.o(197558);
    return localObject;
  }
  
  private Size aO(int paramInt)
  {
    AppMethodBeat.i(197567);
    Size localSize = (Size)Collections.max(Arrays.asList(aM(paramInt)), new androidx.camera.core.impl.a.c());
    AppMethodBeat.o(197567);
    return localSize;
  }
  
  private List<Size> aP(int paramInt)
  {
    AppMethodBeat.i(197621);
    List localList2 = (List)this.Ec.get(Integer.valueOf(paramInt));
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = this.DY.aR(paramInt);
      this.Ec.put(Integer.valueOf(paramInt), localList1);
    }
    AppMethodBeat.o(197621);
    return localList1;
  }
  
  private Size b(androidx.camera.core.impl.al paramal)
  {
    AppMethodBeat.i(197496);
    int i = paramal.ko();
    paramal = a(paramal.kp(), i);
    AppMethodBeat.o(197496);
    return paramal;
  }
  
  private void hA()
  {
    AppMethodBeat.i(197600);
    this.Ef = bh.a(new Size(640, 480), this.BW.hq(), hB());
    AppMethodBeat.o(197600);
  }
  
  private Size hB()
  {
    AppMethodBeat.i(197614);
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(this.AW);
        if (!this.BR.x(i, 1)) {
          break label417;
        }
        Object localObject1 = this.BR.y(i, 1);
        if (localObject1 != null)
        {
          localObject1 = new Size(((CamcorderProfile)localObject1).videoFrameWidth, ((CamcorderProfile)localObject1).videoFrameHeight);
          AppMethodBeat.o(197614);
          return localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject2 = (StreamConfigurationMap)this.DX.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject2 == null)
        {
          localObject2 = new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
          AppMethodBeat.o(197614);
          throw ((Throwable)localObject2);
        }
        localObject2 = ((StreamConfigurationMap)localObject2).getOutputSizes(MediaRecorder.class);
        if (localObject2 != null)
        {
          Arrays.sort((Object[])localObject2, new androidx.camera.core.impl.a.c(true));
          int j = localObject2.length;
          i = 0;
          if (i < j)
          {
            localSize = localObject2[i];
            if ((localSize.getWidth() <= DP.getWidth()) && (localSize.getHeight() <= DP.getHeight()))
            {
              AppMethodBeat.o(197614);
              return localSize;
            }
            i += 1;
            continue;
          }
        }
        localObject2 = DQ;
        AppMethodBeat.o(197614);
        return localObject2;
      }
      Size localSize = DQ;
      Object localObject2 = null;
      if (this.BR.x(i, 10)) {
        localObject2 = this.BR.y(i, 10);
      }
      for (;;)
      {
        if (localObject2 != null) {
          localSize = new Size(((CamcorderProfile)localObject2).videoFrameWidth, ((CamcorderProfile)localObject2).videoFrameHeight);
        }
        AppMethodBeat.o(197614);
        return localSize;
        if (this.BR.x(i, 8)) {
          localObject2 = this.BR.y(i, 8);
        } else if (this.BR.x(i, 12)) {
          localObject2 = this.BR.y(i, 12);
        } else if (this.BR.x(i, 6)) {
          localObject2 = this.BR.y(i, 6);
        } else if (this.BR.x(i, 5)) {
          localObject2 = this.BR.y(i, 5);
        } else if (this.BR.x(i, 4)) {
          localObject2 = this.BR.y(i, 4);
        }
      }
      label417:
      localObject2 = null;
    }
  }
  
  private void hz()
  {
    AppMethodBeat.i(197593);
    Object localObject1 = this.DV;
    Object localObject2 = new ArrayList();
    Object localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
    ((List)localObject2).add(localObject3);
    localObject3 = new bf();
    ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
    ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
    ((List)localObject2).add(localObject3);
    ((List)localObject1).addAll((Collection)localObject2);
    if ((this.Ea == 0) || (this.Ea == 1) || (this.Ea == 3))
    {
      localObject1 = this.DV;
      localObject2 = new ArrayList();
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Ns));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Ns));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Ns));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Ns));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Ns));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Ns));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Ns));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if ((this.Ea == 1) || (this.Ea == 3))
    {
      localObject1 = this.DV;
      localObject2 = new ArrayList();
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nq));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nq));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      ((List)localObject1).addAll((Collection)localObject2);
    }
    localObject1 = (int[])this.DX.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      if (i < j)
      {
        int k = localObject1[i];
        if (k == 3) {
          this.Ed = true;
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 6) {
            this.Ee = true;
          }
        }
      }
    }
    if (this.Ed)
    {
      localObject1 = this.DV;
      localObject2 = new ArrayList();
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if ((this.Ee) && (this.Ea == 0))
    {
      localObject1 = this.DV;
      localObject2 = new ArrayList();
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if (this.Ea == 3)
    {
      localObject1 = this.DV;
      localObject2 = new ArrayList();
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nq));
      ((bf)localObject3).a(bg.a(bg.b.Nx, bg.a.Nt));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      localObject3 = new bf();
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nr));
      ((bf)localObject3).a(bg.a(bg.b.Nw, bg.a.Nq));
      ((bf)localObject3).a(bg.a(bg.b.Ny, bg.a.Nt));
      ((bf)localObject3).a(bg.a(bg.b.Nz, bg.a.Nt));
      ((List)localObject2).add(localObject3);
      ((List)localObject1).addAll((Collection)localObject2);
    }
    localObject2 = this.DV;
    localObject1 = this.DZ;
    localObject3 = this.AW;
    int i = this.Ea;
    if (((e)localObject1).FT == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      ((List)localObject2).addAll((Collection)localObject1);
      AppMethodBeat.o(197593);
      return;
      if (j.ij()) {
        localObject1 = j.L((String)localObject3);
      } else if (j.ik()) {
        localObject1 = j.aQ(i);
      } else {
        localObject1 = Collections.emptyList();
      }
    }
  }
  
  private boolean y(List<bg> paramList)
  {
    AppMethodBeat.i(197443);
    Iterator localIterator = this.DV.iterator();
    boolean bool2 = false;
    boolean bool1 = bool2;
    bf localbf;
    if (localIterator.hasNext())
    {
      localbf = (bf)localIterator.next();
      if (!paramList.isEmpty()) {
        break label76;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      AppMethodBeat.o(197443);
      return bool1;
      label76:
      if (paramList.size() <= localbf.Np.size()) {
        break label101;
      }
    }
    label101:
    int i = localbf.Np.size();
    Object localObject = new ArrayList();
    bf.a((List)localObject, i, new int[i], 0);
    localObject = ((List)localObject).iterator();
    label140:
    int j;
    if (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      j = 0;
      i = 1;
      label166:
      if (j < localbf.Np.size())
      {
        if (arrayOfInt[j] >= paramList.size()) {
          break label302;
        }
        bg localbg1 = (bg)localbf.Np.get(j);
        bg localbg2 = (bg)paramList.get(arrayOfInt[j]);
        bg.b localb = localbg2.jO();
        if ((localbg2.jP().mId > localbg1.jP().mId) || (localb != localbg1.jO())) {
          break label305;
        }
      }
    }
    label302:
    label305:
    for (int k = 1;; k = 0)
    {
      i = k & i;
      k = i;
      if (i != 0) {}
      for (;;)
      {
        j += 1;
        break label166;
        k = i;
        if (k == 0) {
          break label140;
        }
        bool1 = true;
        break;
        bool1 = false;
        break;
      }
    }
  }
  
  private static List<Integer> z(List<bk<?>> paramList)
  {
    AppMethodBeat.i(197472);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((bk)localIterator.next()).kJ();
      if (!((List)localObject).contains(Integer.valueOf(i))) {
        ((List)localObject).add(Integer.valueOf(i));
      }
    }
    Collections.sort((List)localObject);
    Collections.reverse((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        bk localbk = (bk)localIterator.next();
        if (i == localbk.kJ()) {
          localArrayList.add(Integer.valueOf(paramList.indexOf(localbk)));
        }
      }
    }
    AppMethodBeat.o(197472);
    return localArrayList;
  }
  
  final bg a(int paramInt, Size paramSize)
  {
    AppMethodBeat.i(197634);
    bg.b localb = aK(paramInt);
    bg.a locala = bg.a.Nu;
    Size localSize = aJ(paramInt);
    if (paramSize.getWidth() * paramSize.getHeight() <= this.Ef.jQ().getWidth() * this.Ef.jQ().getHeight()) {
      paramSize = bg.a.Nq;
    }
    for (;;)
    {
      paramSize = bg.a(localb, paramSize);
      AppMethodBeat.o(197634);
      return paramSize;
      if (paramSize.getWidth() * paramSize.getHeight() <= this.Ef.hq().getWidth() * this.Ef.hq().getHeight())
      {
        paramSize = bg.a.Nr;
      }
      else if (paramSize.getWidth() * paramSize.getHeight() <= this.Ef.hB().getWidth() * this.Ef.hB().getHeight())
      {
        paramSize = bg.a.Ns;
      }
      else
      {
        paramInt = paramSize.getWidth();
        int i = paramSize.getHeight();
        int j = localSize.getWidth();
        paramSize = locala;
        if (paramInt * i <= localSize.getHeight() * j) {
          paramSize = bg.a.Nt;
        }
      }
    }
  }
  
  final Map<bk<?>, Size> b(List<bg> paramList, List<bk<?>> paramList1)
  {
    AppMethodBeat.i(197644);
    Object localObject1 = this.BW;
    ((ae)localObject1).CN = ((ae)localObject1).hr();
    if (this.Ef == null) {
      hA();
    }
    for (;;)
    {
      localObject1 = new ArrayList(paramList);
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(a(((bk)((Iterator)localObject2).next()).ki(), new Size(640, 480)));
      }
      localObject1 = this.BW.hq();
      this.Ef = bh.a(this.Ef.jQ(), (Size)localObject1, this.Ef.hB());
    }
    if (!y((List)localObject1))
    {
      paramList = new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.AW + ".  May be attempting to bind too many use cases. Existing surfaces: " + paramList + " New configs: " + paramList1);
      AppMethodBeat.o(197644);
      throw paramList;
    }
    Object localObject2 = z(paramList1);
    localObject1 = new ArrayList();
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((List)localObject1).add(a((bk)paramList1.get(((Integer)((Iterator)localObject3).next()).intValue())));
    }
    localObject1 = B((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (List)((Iterator)localObject1).next();
      Object localObject4 = new ArrayList(paramList);
      int i = 0;
      Object localObject5;
      while (i < ((List)localObject3).size())
      {
        localObject5 = (Size)((List)localObject3).get(i);
        ((List)localObject4).add(a(((bk)paramList1.get(((Integer)((List)localObject2).get(i)).intValue())).ki(), (Size)localObject5));
        i += 1;
      }
      if (y((List)localObject4))
      {
        localObject1 = new HashMap();
        localObject4 = paramList1.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bk)((Iterator)localObject4).next();
          ((Map)localObject1).put(localObject5, (Size)((List)localObject3).get(((List)localObject2).indexOf(Integer.valueOf(paramList1.indexOf(localObject5)))));
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramList = new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.AW + " and Hardware level: " + this.Ea + ". May be the specified resolution is too large and not supported. Existing surfaces: " + paramList + " New configs: " + paramList1);
        AppMethodBeat.o(197644);
        throw paramList;
      }
      AppMethodBeat.o(197644);
      return localObject1;
      localObject1 = null;
    }
  }
  
  static final class a
    implements Comparator<Rational>
  {
    private Rational Ei;
    
    a(Rational paramRational)
    {
      this.Ei = paramRational;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.al
 * JD-Core Version:    0.7.0.1
 */