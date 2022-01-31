package a.j.b.a;

import a.f.a.b;
import a.f.b.k;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.h.c;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.j.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflect-api"})
public final class ab
{
  private static final c BQl;
  public static final ab BQm;
  
  static
  {
    AppMethodBeat.i(118924);
    BQm = new ab();
    BQl = c.Ctz;
    AppMethodBeat.o(118924);
  }
  
  public static String a(ar paramar)
  {
    AppMethodBeat.i(118922);
    a.f.b.j.q(paramar, "typeParameter");
    StringBuilder localStringBuilder = new StringBuilder();
    ba localba = paramar.edG();
    switch (ac.pRV[localba.ordinal()])
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramar.edF());
      paramar = localStringBuilder.toString();
      a.f.b.j.p(paramar, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(118922);
      return paramar;
      localStringBuilder.append("in ");
      continue;
      localStringBuilder.append("out ");
    }
  }
  
  public static String a(t paramt)
  {
    AppMethodBeat.i(118919);
    a.f.b.j.q(paramt, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fun ");
    a(localStringBuilder, (a)paramt);
    Object localObject = BQl;
    f localf = paramt.edF();
    a.f.b.j.p(localf, "descriptor.name");
    localStringBuilder.append(((c)localObject).b(localf, true));
    localObject = paramt.edu();
    a.f.b.j.p(localObject, "descriptor.valueParameters");
    a.a.j.a((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)a.BQn, 48);
    localStringBuilder.append(": ");
    paramt = paramt.eds();
    if (paramt == null) {
      a.f.b.j.ebi();
    }
    a.f.b.j.p(paramt, "descriptor.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    a.f.b.j.p(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118919);
    return paramt;
  }
  
  private static void a(StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(118917);
    ak localak = af.a(parama);
    parama = parama.edp();
    a(paramStringBuilder, localak);
    if ((localak != null) && (parama != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramStringBuilder.append("(");
      }
      a(paramStringBuilder, parama);
      if (i != 0) {
        paramStringBuilder.append(")");
      }
      AppMethodBeat.o(118917);
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, ak paramak)
  {
    AppMethodBeat.i(118916);
    if (paramak != null)
    {
      paramak = paramak.eer();
      a.f.b.j.p(paramak, "receiver.type");
      paramStringBuilder.append(b(paramak));
      paramStringBuilder.append(".");
    }
    AppMethodBeat.o(118916);
  }
  
  public static String b(ah paramah)
  {
    AppMethodBeat.i(118918);
    a.f.b.j.q(paramah, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramah.eey()) {}
    for (Object localObject = "var ";; localObject = "val ")
    {
      localStringBuilder.append((String)localObject);
      a(localStringBuilder, (a)paramah);
      localObject = BQl;
      f localf = paramah.edF();
      a.f.b.j.p(localf, "descriptor.name");
      localStringBuilder.append(((c)localObject).b(localf, true));
      localStringBuilder.append(": ");
      paramah = paramah.eer();
      a.f.b.j.p(paramah, "descriptor.type");
      localStringBuilder.append(b(paramah));
      paramah = localStringBuilder.toString();
      a.f.b.j.p(paramah, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(118918);
      return paramah;
    }
  }
  
  public static String b(t paramt)
  {
    AppMethodBeat.i(118920);
    a.f.b.j.q(paramt, "invoke");
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, (a)paramt);
    List localList = paramt.edu();
    a.f.b.j.p(localList, "invoke.valueParameters");
    a.a.j.a((Iterable)localList, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)b.BQo, 48);
    localStringBuilder.append(" -> ");
    paramt = paramt.eds();
    if (paramt == null) {
      a.f.b.j.ebi();
    }
    a.f.b.j.p(paramt, "invoke.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    a.f.b.j.p(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(118920);
    return paramt;
  }
  
  public static String b(w paramw)
  {
    AppMethodBeat.i(118923);
    a.f.b.j.q(paramw, "type");
    paramw = BQl.b(paramw);
    AppMethodBeat.o(118923);
    return paramw;
  }
  
  public static String b(o paramo)
  {
    AppMethodBeat.i(118921);
    a.f.b.j.q(paramo, "parameter");
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = paramo.BPz;
    switch (ac.bLo[locala.ordinal()])
    {
    default: 
      localStringBuilder.append(" of ");
      paramo = (a)paramo.BPy.ebs();
      if (!(paramo instanceof ah)) {
        break;
      }
    }
    for (paramo = b((ah)paramo);; paramo = a((t)paramo))
    {
      localStringBuilder.append(paramo);
      paramo = localStringBuilder.toString();
      a.f.b.j.p(paramo, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(118921);
      return paramo;
      localStringBuilder.append("extension receiver");
      break;
      localStringBuilder.append("instance");
      break;
      localStringBuilder.append("parameter #" + paramo.index + ' ' + paramo.getName());
      break;
      if (!(paramo instanceof t)) {
        break label198;
      }
    }
    label198:
    paramo = (Throwable)new IllegalStateException("Illegal callable: ".concat(String.valueOf(paramo)).toString());
    AppMethodBeat.o(118921);
    throw paramo;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends k
    implements b<au, String>
  {
    public static final a BQn;
    
    static
    {
      AppMethodBeat.i(118913);
      BQn = new a();
      AppMethodBeat.o(118913);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends k
    implements b<au, String>
  {
    public static final b BQo;
    
    static
    {
      AppMethodBeat.i(118915);
      BQo = new b();
      AppMethodBeat.o(118915);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.ab
 * JD-Core Version:    0.7.0.1
 */