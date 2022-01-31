package a.j.b.a;

import a.f.a.a;
import a.f.b.c;
import a.f.b.j;
import a.j.a.b;
import a.j.b.a.c.b.ah;
import a.j.k;
import a.l;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflect-api"})
public abstract class s<R>
  extends e<R>
  implements k<R>
{
  private static final Object BPM = new Object();
  public static final s.b BPN = new s.b((byte)0);
  private final z.a<Field> BPK;
  private final z.a<ah> BPL;
  final i BPf;
  final Object BPg;
  final String name;
  final String signature;
  
  public s(i parami, ah paramah)
  {
    this(parami, str, ad.c(paramah).mk(), paramah, c.BNj);
  }
  
  private s(i parami, String paramString1, String paramString2, ah paramah, Object paramObject)
  {
    this.BPf = parami;
    this.name = paramString1;
    this.signature = paramString2;
    this.BPg = paramObject;
    parami = z.a(null, (a)new s.f(this));
    j.p(parami, "ReflectProperties.lazySo…y -> null\n        }\n    }");
    this.BPK = parami;
    parami = z.a(paramah, (a)new s.e(this));
    j.p(parami, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.BPL = parami;
  }
  
  public s(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == BPM) && (ebO().edp() == null)) {
        throw ((Throwable)new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead"));
      }
    }
    catch (IllegalAccessException paramField)
    {
      throw ((Throwable)new b(paramField));
    }
    if (paramField != null)
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    return null;
  }
  
  public abstract s.c<R> ebJ();
  
  public final Field ebM()
  {
    return (Field)this.BPK.invoke();
  }
  
  protected final Field ebN()
  {
    if (ebO().eeC()) {
      return ebM();
    }
    return null;
  }
  
  public final ah ebO()
  {
    Object localObject = this.BPL.invoke();
    j.p(localObject, "_descriptor()");
    return (ah)localObject;
  }
  
  public final a.j.b.a.a.d<?> ebt()
  {
    return ebJ().ebt();
  }
  
  public final i ebu()
  {
    return this.BPf;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = af.ds(paramObject);
    if (paramObject == null) {}
    while ((!j.e(this.BPf, paramObject.BPf)) || (!j.e(this.name, paramObject.name)) || (!j.e(this.signature, paramObject.signature)) || (!j.e(this.BPg, paramObject.BPg))) {
      return false;
    }
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return (this.BPf.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final boolean isBound()
  {
    return j.e(this.BPg, c.BNj) ^ true;
  }
  
  public String toString()
  {
    ab localab = ab.BQm;
    return ab.b(ebO());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.s
 * JD-Core Version:    0.7.0.1
 */