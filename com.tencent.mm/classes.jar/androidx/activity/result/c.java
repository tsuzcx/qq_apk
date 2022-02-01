package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class c
{
  public Random eQ = new Random();
  public final Map<Integer, String> eR = new HashMap();
  public final Map<String, Integer> eS = new HashMap();
  private final Map<String, c.b> eT = new HashMap();
  public ArrayList<String> eU = new ArrayList();
  public final transient Map<String, a<?>> eV = new HashMap();
  public final Map<String, Object> eW = new HashMap();
  public final Bundle eX = new Bundle();
  
  private <O> void a(String paramString, int paramInt, Intent paramIntent, a<O> parama)
  {
    if ((parama != null) && (parama.ff != null))
    {
      parama.ff.l(parama.fg.a(paramInt, paramIntent));
      return;
    }
    this.eW.remove(paramString);
    this.eX.putParcelable(paramString, new ActivityResult(paramInt, paramIntent));
  }
  
  private int bn()
  {
    for (int i = this.eQ.nextInt(2147418112) + 65536; this.eR.containsKey(Integer.valueOf(i)); i = this.eQ.nextInt(2147418112) + 65536) {}
    return i;
  }
  
  private int p(String paramString)
  {
    Integer localInteger = (Integer)this.eS.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = bn();
    d(i, paramString);
    return i;
  }
  
  public final <I, O> b<I> a(final String paramString, final androidx.activity.result.a.a<I, O> parama, a<O> parama1)
  {
    final int i = p(paramString);
    this.eV.put(paramString, new a(parama1, parama));
    if (this.eW.containsKey(paramString))
    {
      localObject = this.eW.get(paramString);
      this.eW.remove(paramString);
      parama1.l(localObject);
    }
    Object localObject = (ActivityResult)this.eX.getParcelable(paramString);
    if (localObject != null)
    {
      this.eX.remove(paramString);
      parama1.l(parama.a(((ActivityResult)localObject).mResultCode, ((ActivityResult)localObject).eP));
    }
    new b()
    {
      public final void a(I paramAnonymousI, androidx.core.app.b paramAnonymousb)
      {
        AppMethodBeat.i(199246);
        c.this.eU.add(paramString);
        Integer localInteger = (Integer)c.this.eS.get(paramString);
        c localc = c.this;
        if (localInteger != null) {}
        for (int i = localInteger.intValue();; i = i)
        {
          localc.a(i, parama, paramAnonymousI, paramAnonymousb);
          AppMethodBeat.o(199246);
          return;
        }
      }
      
      public final void unregister()
      {
        AppMethodBeat.i(199251);
        c.this.unregister(paramString);
        AppMethodBeat.o(199251);
      }
    };
  }
  
  public final <I, O> b<I> a(final String paramString, q paramq, final androidx.activity.result.a.a<I, O> parama, a<O> parama1)
  {
    j localj = paramq.getLifecycle();
    if (localj.getCurrentState().d(j.b.bHj)) {
      throw new IllegalStateException("LifecycleOwner " + paramq + " is attempting to register while current state is " + localj.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }
    final int i = p(paramString);
    c.b localb = (c.b)this.eT.get(paramString);
    paramq = localb;
    if (localb == null) {
      paramq = new c.b(localj);
    }
    paramq.a(new ActivityResultRegistry.1(this, paramString, parama1, parama));
    this.eT.put(paramString, paramq);
    new b()
    {
      public final void a(I paramAnonymousI, androidx.core.app.b paramAnonymousb)
      {
        AppMethodBeat.i(199256);
        c.this.eU.add(paramString);
        Integer localInteger = (Integer)c.this.eS.get(paramString);
        c localc = c.this;
        if (localInteger != null) {}
        for (int i = localInteger.intValue();; i = i)
        {
          localc.a(i, parama, paramAnonymousI, paramAnonymousb);
          AppMethodBeat.o(199256);
          return;
        }
      }
      
      public final void unregister()
      {
        AppMethodBeat.i(199262);
        c.this.unregister(paramString);
        AppMethodBeat.o(199262);
      }
    };
  }
  
  public abstract <I, O> void a(int paramInt, androidx.activity.result.a.a<I, O> parama, I paramI, androidx.core.app.b paramb);
  
  public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = (String)this.eR.get(Integer.valueOf(paramInt1));
    if (str == null) {
      return false;
    }
    this.eU.remove(str);
    a(str, paramInt2, paramIntent, (a)this.eV.get(str));
    return true;
  }
  
  public final void d(int paramInt, String paramString)
  {
    this.eR.put(Integer.valueOf(paramInt), paramString);
    this.eS.put(paramString, Integer.valueOf(paramInt));
  }
  
  final void unregister(String paramString)
  {
    if (!this.eU.contains(paramString))
    {
      localObject = (Integer)this.eS.remove(paramString);
      if (localObject != null) {
        this.eR.remove(localObject);
      }
    }
    this.eV.remove(paramString);
    if (this.eW.containsKey(paramString))
    {
      new StringBuilder("Dropping pending result for request ").append(paramString).append(": ").append(this.eW.get(paramString));
      this.eW.remove(paramString);
    }
    if (this.eX.containsKey(paramString))
    {
      new StringBuilder("Dropping pending result for request ").append(paramString).append(": ").append(this.eX.getParcelable(paramString));
      this.eX.remove(paramString);
    }
    Object localObject = (c.b)this.eT.get(paramString);
    if (localObject != null)
    {
      ((c.b)localObject).bo();
      this.eT.remove(paramString);
    }
  }
  
  public static final class a<O>
  {
    public final a<O> ff;
    final androidx.activity.result.a.a<?, O> fg;
    
    a(a<O> parama, androidx.activity.result.a.a<?, O> parama1)
    {
      this.ff = parama;
      this.fg = parama1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.result.c
 * JD-Core Version:    0.7.0.1
 */