package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class v<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  boolean Crr;
  private final int Csn;
  private List<v<K, V>.b> Cso;
  private Map<K, V> Csp;
  private volatile v<K, V>.d Csq;
  
  private v(int paramInt)
  {
    AppMethodBeat.i(121644);
    this.Csn = paramInt;
    this.Cso = Collections.emptyList();
    this.Csp = Collections.emptyMap();
    AppMethodBeat.o(121644);
  }
  
  static <FieldDescriptorType extends h.a<FieldDescriptorType>> v<FieldDescriptorType, Object> VM(int paramInt)
  {
    AppMethodBeat.i(121643);
    v.1 local1 = new v.1(paramInt);
    AppMethodBeat.o(121643);
    return local1;
  }
  
  private V VO(int paramInt)
  {
    AppMethodBeat.i(121655);
    enf();
    Object localObject = ((v.b)this.Cso.remove(paramInt)).getValue();
    if (!this.Csp.isEmpty())
    {
      Iterator localIterator = eng().entrySet().iterator();
      this.Cso.add(new v.b(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    AppMethodBeat.o(121655);
    return localObject;
  }
  
  private void enf()
  {
    AppMethodBeat.i(121658);
    if (this.Crr)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(121658);
      throw localUnsupportedOperationException;
    }
    AppMethodBeat.o(121658);
  }
  
  private SortedMap<K, V> eng()
  {
    AppMethodBeat.i(121659);
    enf();
    if ((this.Csp.isEmpty()) && (!(this.Csp instanceof TreeMap))) {
      this.Csp = new TreeMap();
    }
    SortedMap localSortedMap = (SortedMap)this.Csp;
    AppMethodBeat.o(121659);
    return localSortedMap;
  }
  
  private void enh()
  {
    AppMethodBeat.i(121660);
    enf();
    if ((this.Cso.isEmpty()) && (!(this.Cso instanceof ArrayList))) {
      this.Cso = new ArrayList(this.Csn);
    }
    AppMethodBeat.o(121660);
  }
  
  private int i(K paramK)
  {
    AppMethodBeat.i(121656);
    int j = 0;
    int i = this.Cso.size() - 1;
    int k;
    if (i >= 0)
    {
      k = paramK.compareTo(((v.b)this.Cso.get(i)).Cst);
      if (k > 0)
      {
        i = -(i + 2);
        AppMethodBeat.o(121656);
        return i;
      }
      if (k == 0)
      {
        AppMethodBeat.o(121656);
        return i;
      }
    }
    for (;;)
    {
      if (j <= i)
      {
        k = (j + i) / 2;
        int m = paramK.compareTo(((v.b)this.Cso.get(k)).Cst);
        if (m < 0)
        {
          i = k - 1;
        }
        else if (m > 0)
        {
          j = k + 1;
        }
        else
        {
          AppMethodBeat.o(121656);
          return k;
        }
      }
      else
      {
        i = -(j + 1);
        AppMethodBeat.o(121656);
        return i;
      }
    }
  }
  
  public final Map.Entry<K, V> VN(int paramInt)
  {
    AppMethodBeat.i(121647);
    Map.Entry localEntry = (Map.Entry)this.Cso.get(paramInt);
    AppMethodBeat.o(121647);
    return localEntry;
  }
  
  public final V c(K paramK, V paramV)
  {
    AppMethodBeat.i(121652);
    enf();
    int i = i(paramK);
    if (i >= 0)
    {
      paramK = ((v.b)this.Cso.get(i)).setValue(paramV);
      AppMethodBeat.o(121652);
      return paramK;
    }
    enh();
    i = -(i + 1);
    if (i >= this.Csn)
    {
      paramK = eng().put(paramK, paramV);
      AppMethodBeat.o(121652);
      return paramK;
    }
    if (this.Cso.size() == this.Csn)
    {
      v.b localb = (v.b)this.Cso.remove(this.Csn - 1);
      eng().put(localb.Cst, localb.getValue());
    }
    this.Cso.add(i, new v.b(this, paramK, paramV));
    AppMethodBeat.o(121652);
    return null;
  }
  
  public void clear()
  {
    AppMethodBeat.i(121653);
    enf();
    if (!this.Cso.isEmpty()) {
      this.Cso.clear();
    }
    if (!this.Csp.isEmpty()) {
      this.Csp.clear();
    }
    AppMethodBeat.o(121653);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(121650);
    paramObject = (Comparable)paramObject;
    if ((i(paramObject) >= 0) || (this.Csp.containsKey(paramObject)))
    {
      AppMethodBeat.o(121650);
      return true;
    }
    AppMethodBeat.o(121650);
    return false;
  }
  
  public void emF()
  {
    AppMethodBeat.i(121645);
    if (!this.Crr) {
      if (!this.Csp.isEmpty()) {
        break label44;
      }
    }
    label44:
    for (Map localMap = Collections.emptyMap();; localMap = Collections.unmodifiableMap(this.Csp))
    {
      this.Csp = localMap;
      this.Crr = true;
      AppMethodBeat.o(121645);
      return;
    }
  }
  
  public final int enc()
  {
    AppMethodBeat.i(121646);
    int i = this.Cso.size();
    AppMethodBeat.o(121646);
    return i;
  }
  
  public final Iterable<Map.Entry<K, V>> ene()
  {
    AppMethodBeat.i(121648);
    if (this.Csp.isEmpty())
    {
      localObject = v.a.eni();
      AppMethodBeat.o(121648);
      return localObject;
    }
    Object localObject = this.Csp.entrySet();
    AppMethodBeat.o(121648);
    return localObject;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(121657);
    if (this.Csq == null) {
      this.Csq = new v.d(this, (byte)0);
    }
    v.d locald = this.Csq;
    AppMethodBeat.o(121657);
    return locald;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(121651);
    paramObject = (Comparable)paramObject;
    int i = i(paramObject);
    if (i >= 0)
    {
      paramObject = ((v.b)this.Cso.get(i)).getValue();
      AppMethodBeat.o(121651);
      return paramObject;
    }
    paramObject = this.Csp.get(paramObject);
    AppMethodBeat.o(121651);
    return paramObject;
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(121654);
    enf();
    paramObject = (Comparable)paramObject;
    int i = i(paramObject);
    if (i >= 0)
    {
      paramObject = VO(i);
      AppMethodBeat.o(121654);
      return paramObject;
    }
    if (this.Csp.isEmpty())
    {
      AppMethodBeat.o(121654);
      return null;
    }
    paramObject = this.Csp.remove(paramObject);
    AppMethodBeat.o(121654);
    return paramObject;
  }
  
  public int size()
  {
    AppMethodBeat.i(121649);
    int i = this.Cso.size();
    int j = this.Csp.size();
    AppMethodBeat.o(121649);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.g.v
 * JD-Core Version:    0.7.0.1
 */