package androidx.lifecycle;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ac
{
  private static final Class[] bIh;
  final Map<String, Object> bId;
  final Map<String, b.b> bIe;
  private final Map<String, Object<?>> bIf;
  final b.b bIg;
  
  static
  {
    Class localClass1 = Boolean.TYPE;
    Class localClass2 = Double.TYPE;
    Class localClass3 = Integer.TYPE;
    Class localClass4 = Long.TYPE;
    Class localClass5 = Byte.TYPE;
    Class localClass6 = Character.TYPE;
    Class localClass7 = Float.TYPE;
    Class localClass8 = Short.TYPE;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = Size.class;
      if (Build.VERSION.SDK_INT < 21) {
        break label240;
      }
    }
    label240:
    for (Object localObject2 = SizeF.class;; localObject2 = Integer.TYPE)
    {
      bIh = new Class[] { localClass1, [Z.class, localClass2, [D.class, localClass3, [I.class, localClass4, [J.class, String.class, [Ljava.lang.String.class, Binder.class, Bundle.class, localClass5, [B.class, localClass6, [C.class, CharSequence.class, [Ljava.lang.CharSequence.class, ArrayList.class, localClass7, [F.class, Parcelable.class, [Landroid.os.Parcelable.class, Serializable.class, localClass8, [S.class, SparseArray.class, localObject1, localObject2 };
      return;
      localObject1 = Integer.TYPE;
      break;
    }
  }
  
  public ac()
  {
    AppMethodBeat.i(194453);
    this.bIe = new HashMap();
    this.bIf = new HashMap();
    this.bIg = new b.b()
    {
      public final Bundle saveState()
      {
        AppMethodBeat.i(194467);
        Object localObject1 = new HashMap(ac.this.bIe).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = ((b.b)((Map.Entry)localObject2).getValue()).saveState();
          ac.this.i((String)((Map.Entry)localObject2).getKey(), localObject3);
        }
        Object localObject3 = ac.this.bId.keySet();
        localObject1 = new ArrayList(((Set)localObject3).size());
        Object localObject2 = new ArrayList(((ArrayList)localObject1).size());
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          ((ArrayList)localObject1).add(str);
          ((ArrayList)localObject2).add(ac.this.bId.get(str));
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelableArrayList("keys", (ArrayList)localObject1);
        ((Bundle)localObject3).putParcelableArrayList("values", (ArrayList)localObject2);
        AppMethodBeat.o(194467);
        return localObject3;
      }
    };
    this.bId = new HashMap();
    AppMethodBeat.o(194453);
  }
  
  private ac(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(194444);
    this.bIe = new HashMap();
    this.bIf = new HashMap();
    this.bIg = new b.b()
    {
      public final Bundle saveState()
      {
        AppMethodBeat.i(194467);
        Object localObject1 = new HashMap(ac.this.bIe).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = ((b.b)((Map.Entry)localObject2).getValue()).saveState();
          ac.this.i((String)((Map.Entry)localObject2).getKey(), localObject3);
        }
        Object localObject3 = ac.this.bId.keySet();
        localObject1 = new ArrayList(((Set)localObject3).size());
        Object localObject2 = new ArrayList(((ArrayList)localObject1).size());
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          ((ArrayList)localObject1).add(str);
          ((ArrayList)localObject2).add(ac.this.bId.get(str));
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelableArrayList("keys", (ArrayList)localObject1);
        ((Bundle)localObject3).putParcelableArrayList("values", (ArrayList)localObject2);
        AppMethodBeat.o(194467);
        return localObject3;
      }
    };
    this.bId = new HashMap(paramMap);
    AppMethodBeat.o(194444);
  }
  
  static ac a(Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(194464);
    if ((paramBundle1 == null) && (paramBundle2 == null))
    {
      paramBundle1 = new ac();
      AppMethodBeat.o(194464);
      return paramBundle1;
    }
    HashMap localHashMap = new HashMap();
    if (paramBundle2 != null)
    {
      Iterator localIterator = paramBundle2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle2.get(str));
      }
    }
    if (paramBundle1 == null)
    {
      paramBundle1 = new ac(localHashMap);
      AppMethodBeat.o(194464);
      return paramBundle1;
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    if ((paramBundle2 == null) || (paramBundle1 == null) || (paramBundle2.size() != paramBundle1.size()))
    {
      paramBundle1 = new IllegalStateException("Invalid bundle passed as restored state");
      AppMethodBeat.o(194464);
      throw paramBundle1;
    }
    int i = 0;
    while (i < paramBundle2.size())
    {
      localHashMap.put((String)paramBundle2.get(i), paramBundle1.get(i));
      i += 1;
    }
    paramBundle1 = new ac(localHashMap);
    AppMethodBeat.o(194464);
    return paramBundle1;
  }
  
  public final <T> void i(String paramString, T paramT)
  {
    AppMethodBeat.i(194486);
    if (paramT != null)
    {
      localObject = bIh;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].isInstance(paramT)) {
          break label84;
        }
        i += 1;
      }
      paramString = new IllegalArgumentException("Can't put value with type " + paramT.getClass() + " into saved state");
      AppMethodBeat.o(194486);
      throw paramString;
    }
    label84:
    Object localObject = (x)this.bIf.get(paramString);
    if (localObject != null)
    {
      ((x)localObject).setValue(paramT);
      AppMethodBeat.o(194486);
      return;
    }
    this.bId.put(paramString, paramT);
    AppMethodBeat.o(194486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ac
 * JD-Core Version:    0.7.0.1
 */