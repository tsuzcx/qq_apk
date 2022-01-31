package a.j.b.a.c.g;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class i
  extends a
  implements Serializable
{
  protected i() {}
  
  protected i(byte paramByte) {}
  
  public static <ContainingType extends q, Type> i.f<ContainingType, Type> a(ContainingType paramContainingType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new i.f(paramContainingType, Collections.emptyList(), paramq, new i.e(paramInt, parama, true), paramClass);
  }
  
  public static <ContainingType extends q, Type> i.f<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, q paramq, int paramInt, z.a parama, Class paramClass)
  {
    return new i.f(paramContainingType, paramType, paramq, new i.e(paramInt, parama, false), paramClass);
  }
  
  static Object d(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  static Method e(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      paramClass = String.valueOf(String.valueOf(paramClass.getName()));
      paramString = String.valueOf(String.valueOf(paramString));
      throw new RuntimeException(paramClass.length() + 45 + paramString.length() + "Generated message class \"" + paramClass + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  protected boolean a(e parame, f paramf, g paramg, int paramInt)
  {
    return parame.a(paramInt, paramf);
  }
  
  public s<? extends q> egX()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void emL() {}
  
  public static abstract class b<MessageType extends i.c<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends i.a<MessageType, BuilderType>
    implements i.d<MessageType>
  {
    protected h<i.e> Crw = h.emE();
    private boolean Crx;
    
    protected final void a(MessageType paramMessageType)
    {
      if (!this.Crx)
      {
        this.Crw = this.Crw.emG();
        this.Crx = true;
      }
      h localh = this.Crw;
      paramMessageType = i.c.b(paramMessageType);
      int i = 0;
      while (i < paramMessageType.Crq.enc())
      {
        localh.b(paramMessageType.Crq.VN(i));
        i += 1;
      }
      paramMessageType = paramMessageType.Crq.ene().iterator();
      while (paramMessageType.hasNext()) {
        localh.b((Map.Entry)paramMessageType.next());
      }
    }
    
    public BuilderType ehZ()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class c<MessageType extends c<MessageType>>
    extends i
    implements i.d<MessageType>
  {
    protected final h<i.e> Crw;
    
    protected c()
    {
      this.Crw = h.emD();
    }
    
    protected c(i.b<MessageType, ?> paramb)
    {
      this.Crw = i.b.a(paramb);
    }
    
    private void b(i.f<MessageType, ?> paramf)
    {
      if (paramf.CrG != ehd()) {
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
    }
    
    public final <Type> Type a(i.f<MessageType, List<Type>> paramf, int paramInt)
    {
      b(paramf);
      Object localObject = this.Crw;
      i.e locale = paramf.CrI;
      if (!locale.emJ()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      localObject = ((h)localObject).a(locale);
      if (localObject == null) {
        throw new IndexOutOfBoundsException();
      }
      return paramf.dH(((List)localObject).get(paramInt));
    }
    
    protected final boolean a(e parame, f paramf, g paramg, int paramInt)
    {
      h localh = this.Crw;
      Object localObject = ehd();
      int i = z.eZ(paramInt);
      int j = z.fa(paramInt);
      i.f localf = (i.f)paramg.Cro.get(new g.a(localObject, j));
      if (localf != null) {
        if (i == h.a(localf.CrI.CrD, false))
        {
          i = 0;
          j = 0;
        }
      }
      while (j != 0)
      {
        return parame.a(paramInt, paramf);
        if ((localf.CrI.CrE) && (localf.CrI.CrD.enl()) && (i == h.a(localf.CrI.CrD, true)))
        {
          i = 1;
          j = 0;
        }
        else
        {
          i = 0;
          j = 1;
        }
      }
      if (i != 0)
      {
        paramInt = parame.eP(parame.sl());
        if (localf.CrI.CrD == z.a.CsS) {
          while (parame.so() > 0)
          {
            i = parame.sl();
            paramf = localf.CrI.CrC.Ue(i);
            if (paramf == null) {
              break label273;
            }
            localh.b(localf.CrI, localf.dI(paramf));
          }
        }
        while (parame.so() > 0)
        {
          paramf = h.a(parame, localf.CrI.CrD);
          localh.b(localf.CrI, paramf);
        }
        parame.eQ(paramInt);
      }
      for (;;)
      {
        label273:
        return true;
        switch (i.1.Cru[localf.CrI.CrD.CsX.ordinal()])
        {
        default: 
          parame = h.a(parame, localf.CrI.CrD);
          label329:
          if (!localf.CrI.CrE) {
            break label620;
          }
          localh.b(localf.CrI, localf.dI(parame));
        }
      }
      if (!localf.CrI.CrE)
      {
        paramf = (q)localh.a(localf.CrI);
        if (paramf == null) {}
      }
      for (paramf = paramf.ehb();; paramf = null)
      {
        localObject = paramf;
        if (paramf == null) {
          localObject = localf.CrH.ehc();
        }
        if (localf.CrI.CrD == z.a.CsO)
        {
          paramInt = localf.CrI.number;
          if (parame.bgU >= parame.bgV) {
            throw k.emT();
          }
          parame.bgU += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.eN(z.bo(paramInt, 4));
          parame.bgU -= 1;
        }
        for (;;)
        {
          parame = ((q.a)localObject).ehl();
          break;
          paramInt = parame.sl();
          if (parame.bgU >= parame.bgV) {
            throw k.emT();
          }
          paramInt = parame.eP(paramInt);
          parame.bgU += 1;
          ((q.a)localObject).d(parame, paramg);
          parame.eN(0);
          parame.bgU -= 1;
          parame.eQ(paramInt);
        }
        i = parame.sl();
        paramg = localf.CrI.CrC.Ue(i);
        parame = paramg;
        if (paramg != null) {
          break label329;
        }
        paramf.eX(paramInt);
        paramf.eX(i);
        break;
        label620:
        localh.a(localf.CrI, localf.dI(parame));
        break;
      }
    }
    
    public final <Type> boolean c(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      h localh = this.Crw;
      paramf = paramf.CrI;
      if (paramf.emJ()) {
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      }
      return localh.Crq.get(paramf) != null;
    }
    
    public final <Type> int d(i.f<MessageType, List<Type>> paramf)
    {
      b(paramf);
      h localh = this.Crw;
      paramf = paramf.CrI;
      if (!paramf.emJ()) {
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      }
      paramf = localh.a(paramf);
      if (paramf == null) {
        return 0;
      }
      return ((List)paramf).size();
    }
    
    public final <Type> Type e(i.f<MessageType, Type> paramf)
    {
      b(paramf);
      Object localObject2 = this.Crw.a(paramf.CrI);
      if (localObject2 == null) {
        localObject1 = paramf.CcG;
      }
      do
      {
        return localObject1;
        if (!paramf.CrI.CrE) {
          break;
        }
        localObject1 = localObject2;
      } while (paramf.CrI.CrD.CsX != z.b.Cth);
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(paramf.dH(((Iterator)localObject2).next()));
      }
      return localObject1;
      return paramf.dH(localObject2);
    }
    
    protected final void emL()
    {
      this.Crw.emF();
    }
    
    protected final c<MessageType>.a emM()
    {
      return new i.c.a(this, (byte)0);
    }
  }
  
  public static abstract interface d
    extends r
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.g.i
 * JD-Core Version:    0.7.0.1
 */