package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class Recreator
  implements i
{
  private final d ccc;
  
  Recreator(d paramd)
  {
    this.ccc = paramd;
  }
  
  /* Error */
  public final void onStateChanged(androidx.lifecycle.q paramq, androidx.lifecycle.j.a parama)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: getstatic 40	androidx/lifecycle/j$a:ON_CREATE	Landroidx/lifecycle/j$a;
    //   9: if_acmpeq +20 -> 29
    //   12: new 42	java/lang/AssertionError
    //   15: dup
    //   16: ldc 44
    //   18: invokespecial 47	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   21: astore_1
    //   22: ldc 28
    //   24: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: aload_1
    //   30: invokeinterface 56 1 0
    //   35: aload_0
    //   36: invokevirtual 62	androidx/lifecycle/j:removeObserver	(Landroidx/lifecycle/p;)V
    //   39: aload_0
    //   40: getfield 18	androidx/savedstate/Recreator:ccc	Landroidx/savedstate/d;
    //   43: invokeinterface 68 1 0
    //   48: ldc 70
    //   50: invokevirtual 76	androidx/savedstate/b:aR	(Ljava/lang/String;)Landroid/os/Bundle;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnonnull +9 -> 64
    //   58: ldc 28
    //   60: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: aload_1
    //   65: ldc 78
    //   67: invokevirtual 84	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnonnull +20 -> 92
    //   75: new 86	java/lang/IllegalStateException
    //   78: dup
    //   79: ldc 88
    //   81: invokespecial 91	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   84: astore_1
    //   85: ldc 28
    //   87: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: aload_1
    //   93: invokevirtual 97	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   96: astore_2
    //   97: aload_2
    //   98: invokeinterface 103 1 0
    //   103: ifeq +176 -> 279
    //   106: aload_2
    //   107: invokeinterface 107 1 0
    //   112: checkcast 109	java/lang/String
    //   115: astore_1
    //   116: aload_1
    //   117: iconst_0
    //   118: ldc 2
    //   120: invokevirtual 115	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   123: invokestatic 119	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   126: ldc 121
    //   128: invokevirtual 125	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   131: astore_3
    //   132: aload_3
    //   133: iconst_0
    //   134: anewarray 111	java/lang/Class
    //   137: invokevirtual 129	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   140: astore 4
    //   142: aload 4
    //   144: iconst_1
    //   145: invokevirtual 135	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   148: aload 4
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokevirtual 139	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast 121	androidx/savedstate/b$a
    //   160: astore_3
    //   161: aload_3
    //   162: aload_0
    //   163: getfield 18	androidx/savedstate/Recreator:ccc	Landroidx/savedstate/d;
    //   166: invokeinterface 141 2 0
    //   171: goto -74 -> 97
    //   174: astore_2
    //   175: new 143	java/lang/RuntimeException
    //   178: dup
    //   179: new 145	java/lang/StringBuilder
    //   182: dup
    //   183: ldc 147
    //   185: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 154
    //   194: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aload_2
    //   201: invokespecial 161	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: astore_1
    //   205: ldc 28
    //   207: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: new 86	java/lang/IllegalStateException
    //   216: dup
    //   217: new 145	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 163
    //   223: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_3
    //   227: invokevirtual 166	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   230: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 168
    //   235: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload_1
    //   242: invokespecial 169	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: astore_1
    //   246: ldc 28
    //   248: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_1
    //   252: athrow
    //   253: astore_2
    //   254: new 143	java/lang/RuntimeException
    //   257: dup
    //   258: ldc 171
    //   260: aload_1
    //   261: invokestatic 175	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   264: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   267: aload_2
    //   268: invokespecial 161	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: astore_1
    //   272: ldc 28
    //   274: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload_1
    //   278: athrow
    //   279: ldc 28
    //   281: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	Recreator
    //   0	285	1	paramq	androidx.lifecycle.q
    //   0	285	2	parama	androidx.lifecycle.j.a
    //   131	96	3	localObject	Object
    //   140	9	4	localConstructor	java.lang.reflect.Constructor
    // Exception table:
    //   from	to	target	type
    //   116	132	174	java/lang/ClassNotFoundException
    //   132	142	212	java/lang/NoSuchMethodException
    //   148	161	253	java/lang/Exception
  }
  
  static final class a
    implements b.b
  {
    final Set<String> ccd;
    
    a(b paramb)
    {
      AppMethodBeat.i(193336);
      this.ccd = new HashSet();
      paramb.a("androidx.savedstate.Restarter", this);
      AppMethodBeat.o(193336);
    }
    
    final void add(String paramString)
    {
      AppMethodBeat.i(193356);
      this.ccd.add(paramString);
      AppMethodBeat.o(193356);
    }
    
    public final Bundle saveState()
    {
      AppMethodBeat.i(193346);
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("classes_to_restore", new ArrayList(this.ccd));
      AppMethodBeat.o(193346);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.savedstate.Recreator
 * JD-Core Version:    0.7.0.1
 */