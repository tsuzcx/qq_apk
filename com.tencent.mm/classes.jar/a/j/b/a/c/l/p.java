package a.j.b.a.c.l;

import a.f.a.b;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class p
{
  private static final y CBc;
  private static final p.a CBd;
  public static final ad CBe;
  private static final w CBf;
  private static final ah CBg;
  private static final Set<ah> CBh;
  
  static
  {
    AppMethodBeat.i(122577);
    CBc = new p.1();
    CBd = new p.a(f.ayV("<ERROR CLASS>"));
    CBe = F("<LOOP IN SUPERTYPES>", Collections.emptyList());
    CBf = F("<ERROR PROPERTY TYPE>", Collections.emptyList());
    Object localObject = CBd;
    g.a locala = g.BXx;
    localObject = z.a((l)localObject, g.a.eeH(), a.j.b.a.c.b.w.BWr, ay.BWO, f.ayV("<ERROR PROPERTY>"), b.a.BVX, am.BWF);
    ((z)localObject).a(CBf, Collections.emptyList(), null, null);
    CBg = (ah)localObject;
    CBh = Collections.singleton(localObject);
    AppMethodBeat.o(122577);
  }
  
  public static ad F(String paramString, List<ap> paramList)
  {
    AppMethodBeat.i(122570);
    paramString = new o(azl(paramString), cE(paramString, false), paramList, false);
    AppMethodBeat.o(122570);
    return paramString;
  }
  
  public static boolean L(l paraml)
  {
    AppMethodBeat.i(122573);
    if (paraml == null)
    {
      AppMethodBeat.o(122573);
      return false;
    }
    if (((paraml instanceof p.a)) || ((paraml.ecv() instanceof p.a)) || (paraml == CBc))
    {
      AppMethodBeat.o(122573);
      return true;
    }
    AppMethodBeat.o(122573);
    return false;
  }
  
  public static ad a(String paramString, an paraman)
  {
    AppMethodBeat.i(122569);
    paramString = new o(paraman, cE(paramString, false), (byte)0);
    AppMethodBeat.o(122569);
    return paramString;
  }
  
  private static an a(String paramString, p.a parama)
  {
    AppMethodBeat.i(122572);
    paramString = new p.2(parama, paramString);
    AppMethodBeat.o(122572);
    return paramString;
  }
  
  public static boolean ah(w paramw)
  {
    AppMethodBeat.i(122574);
    if ((paramw != null) && ((paramw.enU() instanceof p.d)))
    {
      AppMethodBeat.o(122574);
      return true;
    }
    AppMethodBeat.o(122574);
    return false;
  }
  
  public static e azh(String paramString)
  {
    AppMethodBeat.i(122564);
    paramString = new p.a(f.ayV("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(122564);
    return paramString;
  }
  
  public static a.j.b.a.c.i.e.h azi(String paramString)
  {
    AppMethodBeat.i(122565);
    paramString = cE(paramString, false);
    AppMethodBeat.o(122565);
    return paramString;
  }
  
  public static ad azj(String paramString)
  {
    AppMethodBeat.i(122567);
    paramString = F(paramString, Collections.emptyList());
    AppMethodBeat.o(122567);
    return paramString;
  }
  
  public static ad azk(String paramString)
  {
    AppMethodBeat.i(122568);
    paramString = a(paramString, a(paramString, CBd));
    AppMethodBeat.o(122568);
    return paramString;
  }
  
  public static an azl(String paramString)
  {
    AppMethodBeat.i(122571);
    paramString = a("[ERROR : " + paramString + "]", CBd);
    AppMethodBeat.o(122571);
    return paramString;
  }
  
  public static a.j.b.a.c.i.e.h cE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(122566);
    if (paramBoolean)
    {
      paramString = new c(paramString, (byte)0);
      AppMethodBeat.o(122566);
      return paramString;
    }
    paramString = new b(paramString, (byte)0);
    AppMethodBeat.o(122566);
    return paramString;
  }
  
  public static y eoH()
  {
    return CBc;
  }
  
  public static final class b
    implements a.j.b.a.c.i.e.h
  {
    private final String Cwo;
    
    private b(String paramString)
    {
      this.Cwo = paramString;
    }
    
    public final Collection<l> a(d paramd, b<? super f, Boolean> paramb)
    {
      AppMethodBeat.i(122548);
      paramd = Collections.emptyList();
      AppMethodBeat.o(122548);
      return paramd;
    }
    
    public final a.j.b.a.c.b.h c(f paramf, a parama)
    {
      AppMethodBeat.i(122545);
      paramf = p.azh(paramf.name);
      AppMethodBeat.o(122545);
      return paramf;
    }
    
    public final Set<f> eeT()
    {
      AppMethodBeat.i(122546);
      Set localSet = Collections.emptySet();
      AppMethodBeat.o(122546);
      return localSet;
    }
    
    public final Set<f> eeU()
    {
      AppMethodBeat.i(122547);
      Set localSet = Collections.emptySet();
      AppMethodBeat.o(122547);
      return localSet;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(122549);
      String str = "ErrorScope{" + this.Cwo + '}';
      AppMethodBeat.o(122549);
      return str;
    }
  }
  
  static final class c
    implements a.j.b.a.c.i.e.h
  {
    private final String Cwo;
    
    private c(String paramString)
    {
      this.Cwo = paramString;
    }
    
    public final Collection a(f paramf, a parama)
    {
      AppMethodBeat.i(122553);
      paramf = new IllegalStateException(this.Cwo + ", required name: " + paramf);
      AppMethodBeat.o(122553);
      throw paramf;
    }
    
    public final Collection<l> a(d paramd, b<? super f, Boolean> paramb)
    {
      AppMethodBeat.i(122555);
      paramd = new IllegalStateException(this.Cwo);
      AppMethodBeat.o(122555);
      throw paramd;
    }
    
    public final Collection b(f paramf, a parama)
    {
      AppMethodBeat.i(122554);
      paramf = new IllegalStateException(this.Cwo + ", required name: " + paramf);
      AppMethodBeat.o(122554);
      throw paramf;
    }
    
    public final a.j.b.a.c.b.h c(f paramf, a parama)
    {
      AppMethodBeat.i(122552);
      paramf = new IllegalStateException(this.Cwo + ", required name: " + paramf);
      AppMethodBeat.o(122552);
      throw paramf;
    }
    
    public final Set<f> eeT()
    {
      AppMethodBeat.i(122556);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(122556);
      throw localIllegalStateException;
    }
    
    public final Set<f> eeU()
    {
      AppMethodBeat.i(122557);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(122557);
      throw localIllegalStateException;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(122558);
      String str = "ThrowingScope{" + this.Cwo + '}';
      AppMethodBeat.o(122558);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.l.p
 * JD-Core Version:    0.7.0.1
 */