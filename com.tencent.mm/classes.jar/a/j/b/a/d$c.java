package a.j.b.a;

import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.d.a.o;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.e.b.a.f.a;
import a.j.b.a.c.e.b.b;
import a.j.b.a.c.e.b.b.c;
import a.j.b.a.c.e.b.b.e;
import a.j.b.a.c.f.g;
import a.j.b.a.c.g.i.c;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflect-api"})
public final class d$c
  extends d
{
  final ah BNZ;
  final a.u BOa;
  final b.e BOb;
  final c BOc;
  final h BOd;
  private final String string;
  
  public d$c(ah paramah, a.u paramu, b.e parame, c paramc, h paramh)
  {
    super((byte)0);
    AppMethodBeat.i(118683);
    this.BNZ = paramah;
    this.BOa = paramu;
    this.BOb = parame;
    this.BOc = paramc;
    this.BOd = paramh;
    if (this.BOb.elx())
    {
      paramah = new StringBuilder();
      paramu = this.BOc;
      parame = this.BOb.CpG;
      a.f.b.j.p(parame, "signature.getter");
      paramah = paramah.append(paramu.getString(parame.ClT));
      paramu = this.BOc;
      parame = this.BOb.CpG;
      a.f.b.j.p(parame, "signature.getter");
      paramah = paramu.getString(parame.CpB);
      this.string = paramah;
      AppMethodBeat.o(118683);
      return;
    }
    paramah = a.j.b.a.c.e.b.a.j.Cqr;
    paramu = a.j.b.a.c.e.b.a.j.a(this.BOa, this.BOc, this.BOd);
    if (paramu == null)
    {
      paramah = (Throwable)new x("No field signature for property: " + this.BNZ);
      AppMethodBeat.o(118683);
      throw paramah;
    }
    paramah = paramu.name;
    parame = paramu.desc;
    paramc = new StringBuilder().append(o.ayF(paramah));
    paramah = this.BNZ.ecv();
    a.f.b.j.p(paramah, "descriptor.containingDeclaration");
    if ((a.f.b.j.e(this.BNZ.ecE(), ay.BWN)) && ((paramah instanceof a.j.b.a.c.j.a.a.d)))
    {
      paramah = (i.c)((a.j.b.a.c.j.a.a.d)paramah).Cys;
      paramu = b.Cpv;
      a.f.b.j.p(paramu, "JvmProtoBuf.classModuleName");
      paramah = (Integer)a.j.b.a.c.e.a.f.a(paramah, paramu);
      if (paramah != null)
      {
        paramu = this.BOc.getString(((Number)paramah).intValue());
        paramah = paramu;
        if (paramu != null) {}
      }
      else
      {
        paramah = "main";
      }
      paramah = "$" + g.ayX(paramah);
    }
    for (;;)
    {
      paramah = paramah + "()" + parame;
      break;
      if ((a.f.b.j.e(this.BNZ.ecE(), ay.BWK)) && ((paramah instanceof ab)))
      {
        paramah = this.BNZ;
        if (paramah == null)
        {
          paramah = new v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
          AppMethodBeat.o(118683);
          throw paramah;
        }
        paramah = ((a.j.b.a.c.j.a.a.i)paramah).CyT;
        if (((paramah instanceof a.j.b.a.c.d.b.i)) && (((a.j.b.a.c.d.b.i)paramah).Cjm != null))
        {
          paramah = "$" + ((a.j.b.a.c.d.b.i)paramah).egS().name;
          continue;
        }
      }
      paramah = "";
    }
  }
  
  public final String mk()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.d.c
 * JD-Core Version:    0.7.0.1
 */