package a.j.b.a.a;

import a.f.b.x;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflect-api"})
public abstract class e<M extends Member>
  implements d<M>
{
  public static final e.b BQS = new e.b((byte)0);
  final M BQP;
  final Type BQQ;
  final Class<?> BQR;
  final List<Type> BQv;
  
  private e(M paramM, Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
  {
    this.BQP = paramM;
    this.BQQ = paramType;
    this.BQR = paramClass;
    paramM = this.BQR;
    if (paramM != null)
    {
      paramType = new x(2);
      paramType.add((Type)paramM);
      paramType.dh(paramArrayOfType);
      paramType = a.a.j.listOf((Type[])paramType.toArray(new Type[paramType.ceo.size()]));
      paramM = paramType;
      if (paramType != null) {}
    }
    else
    {
      paramM = a.a.e.R(paramArrayOfType);
    }
    this.BQv = paramM;
  }
  
  public void Y(Object[] paramArrayOfObject)
  {
    a.f.b.j.q(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final void du(Object paramObject)
  {
    if ((paramObject == null) || (!this.BQP.getDeclaringClass().isInstance(paramObject))) {
      throw ((Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
    }
  }
  
  public final M ebV()
  {
    return this.BQP;
  }
  
  public final Type ebW()
  {
    return this.BQQ;
  }
  
  public final List<Type> ebX()
  {
    return this.BQv;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
  public static final class a
    extends e<Constructor<?>>
    implements c
  {
    private final Object BPg;
    
    public a(Constructor<?> paramConstructor, Object paramObject)
    {
      super((Type)localObject, null, paramConstructor, (byte)0);
      AppMethodBeat.i(118973);
      this.BPg = paramObject;
      AppMethodBeat.o(118973);
    }
    
    public final Object X(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(118972);
      a.f.b.j.q(paramArrayOfObject, "args");
      Y(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.BQP;
      x localx = new x(2);
      localx.add(this.BPg);
      localx.dh(paramArrayOfObject);
      paramArrayOfObject = localConstructor.newInstance(localx.toArray(new Object[localx.ceo.size()]));
      AppMethodBeat.o(118972);
      return paramArrayOfObject;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
  public static final class c
    extends e<Constructor<?>>
  {
    public c(Constructor<?> paramConstructor) {}
    
    public final Object X(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(118974);
      a.f.b.j.q(paramArrayOfObject, "args");
      Y(paramArrayOfObject);
      paramArrayOfObject = ((Constructor)this.BQP).newInstance(Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(118974);
      return paramArrayOfObject;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
  public static final class f$a
    extends e.f
    implements c
  {
    private final Object BPg;
    
    public f$a(Method paramMethod, Object paramObject)
    {
      super(false, null, 4);
      AppMethodBeat.i(118992);
      this.BPg = paramObject;
      AppMethodBeat.o(118992);
    }
    
    public final Object X(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(118991);
      a.f.b.j.q(paramArrayOfObject, "args");
      Y(paramArrayOfObject);
      paramArrayOfObject = a(this.BPg, paramArrayOfObject);
      AppMethodBeat.o(118991);
      return paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */