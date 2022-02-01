package com.google.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b
{
  static final Type[] bND = new Type[0];
  
  private static GenericArrayType a(Type paramType)
  {
    AppMethodBeat.i(107892);
    paramType = new a(paramType);
    AppMethodBeat.o(107892);
    return paramType;
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    AppMethodBeat.i(107901);
    paramClass = b(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      AppMethodBeat.o(107901);
      return paramType;
    }
    AppMethodBeat.o(107901);
    return Object.class;
  }
  
  private static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(107898);
    Object localObject = paramClass1;
    paramClass1 = paramType;
    paramType = (Type)localObject;
    if (paramClass2 == paramType)
    {
      AppMethodBeat.o(107898);
      return paramClass1;
    }
    if (paramClass2.isInterface())
    {
      localObject = paramType.getInterfaces();
      int i = 0;
      int j = localObject.length;
      for (;;)
      {
        if (i >= j) {
          break label106;
        }
        if (localObject[i] == paramClass2)
        {
          paramType = paramType.getGenericInterfaces()[i];
          AppMethodBeat.o(107898);
          return paramType;
        }
        if (paramClass2.isAssignableFrom(localObject[i]))
        {
          paramClass1 = paramType.getGenericInterfaces()[i];
          paramType = localObject[i];
          break;
        }
        i += 1;
      }
    }
    label106:
    if (!paramType.isInterface()) {
      for (paramClass1 = paramType;; paramClass1 = paramType)
      {
        if (paramClass1 == Object.class) {
          break label164;
        }
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2)
        {
          paramType = paramClass1.getGenericSuperclass();
          AppMethodBeat.o(107898);
          return paramType;
        }
        if (paramClass2.isAssignableFrom(paramType))
        {
          paramClass1 = paramClass1.getGenericSuperclass();
          break;
        }
      }
    }
    label164:
    AppMethodBeat.o(107898);
    return paramClass2;
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    AppMethodBeat.i(107903);
    paramType1 = a(paramType1, paramClass, paramType2, new HashSet());
    AppMethodBeat.o(107903);
    return paramType1;
  }
  
  private static Type a(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection)
  {
    AppMethodBeat.i(107904);
    Object localObject1 = paramType2;
    Object localObject2;
    label71:
    int j;
    int i;
    if ((localObject1 instanceof TypeVariable))
    {
      localObject2 = (TypeVariable)localObject1;
      if (paramCollection.contains(localObject2))
      {
        AppMethodBeat.o(107904);
        return localObject1;
      }
      paramCollection.add(localObject2);
      paramType2 = ((TypeVariable)localObject2).getGenericDeclaration();
      if ((paramType2 instanceof Class))
      {
        paramType2 = (Class)paramType2;
        if (paramType2 == null) {
          break label181;
        }
        localObject1 = a(paramType1, paramClass, paramType2);
        if (!(localObject1 instanceof ParameterizedType)) {
          break label181;
        }
        paramType2 = paramType2.getTypeParameters();
        j = paramType2.length;
        i = 0;
        label103:
        if (i >= j) {
          break label166;
        }
        if (!localObject2.equals(paramType2[i])) {
          break label157;
        }
      }
      label157:
      label166:
      label181:
      for (paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments()[i];; paramType2 = (Type)localObject2)
      {
        localObject1 = paramType2;
        if (paramType2 != localObject2) {
          break;
        }
        AppMethodBeat.o(107904);
        return paramType2;
        paramType2 = null;
        break label71;
        i += 1;
        break label103;
        paramType1 = new NoSuchElementException();
        AppMethodBeat.o(107904);
        throw paramType1;
      }
    }
    if (((localObject1 instanceof Class)) && (((Class)localObject1).isArray()))
    {
      paramType2 = (Class)localObject1;
      localObject1 = paramType2.getComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject1, paramCollection);
      if (localObject1 == paramType1)
      {
        AppMethodBeat.o(107904);
        return paramType2;
      }
      paramType1 = a(paramType1);
      AppMethodBeat.o(107904);
      return paramType1;
    }
    if ((localObject1 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)localObject1;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject1, paramCollection);
      if (localObject1 == paramType1)
      {
        AppMethodBeat.o(107904);
        return paramType2;
      }
      paramType1 = a(paramType1);
      AppMethodBeat.o(107904);
      return paramType1;
    }
    if ((localObject1 instanceof ParameterizedType))
    {
      localObject1 = (ParameterizedType)localObject1;
      paramType2 = ((ParameterizedType)localObject1).getOwnerType();
      localObject2 = a(paramType1, paramClass, paramType2, paramCollection);
      if (localObject2 != paramType2)
      {
        i = 1;
        paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments();
        int k = paramType2.length;
        j = 0;
        label364:
        if (j >= k) {
          break label429;
        }
        Type localType = a(paramType1, paramClass, paramType2[j], paramCollection);
        if (localType == paramType2[j]) {
          break label669;
        }
        if (i != 0) {
          break label666;
        }
        paramType2 = (Type[])paramType2.clone();
        i = 1;
        label408:
        paramType2[j] = localType;
      }
    }
    label666:
    label669:
    for (;;)
    {
      j += 1;
      break label364;
      i = 0;
      break;
      label429:
      if (i != 0)
      {
        paramType1 = new b((Type)localObject2, ((ParameterizedType)localObject1).getRawType(), paramType2);
        AppMethodBeat.o(107904);
        return paramType1;
      }
      AppMethodBeat.o(107904);
      return localObject1;
      if ((localObject1 instanceof WildcardType))
      {
        paramType2 = (WildcardType)localObject1;
        localObject1 = paramType2.getLowerBounds();
        localObject2 = paramType2.getUpperBounds();
        if (localObject1.length == 1)
        {
          paramClass = a(paramType1, paramClass, localObject1[0], paramCollection);
          if (paramClass != localObject1[0])
          {
            if ((paramClass instanceof WildcardType)) {
              paramType1 = ((WildcardType)paramClass).getLowerBounds();
            }
            for (;;)
            {
              paramType1 = new c(new Type[] { Object.class }, paramType1);
              AppMethodBeat.o(107904);
              return paramType1;
              paramType1 = new Type[1];
              paramType1[0] = paramClass;
            }
          }
        }
        else if (localObject2.length == 1)
        {
          paramClass = a(paramType1, paramClass, localObject2[0], paramCollection);
          if (paramClass != localObject2[0])
          {
            if ((paramClass instanceof WildcardType)) {
              paramType1 = ((WildcardType)paramClass).getUpperBounds();
            }
            for (;;)
            {
              paramType1 = new c(paramType1, bND);
              AppMethodBeat.o(107904);
              return paramType1;
              paramType1 = new Type[1];
              paramType1[0] = paramClass;
            }
          }
        }
        AppMethodBeat.o(107904);
        return paramType2;
      }
      AppMethodBeat.o(107904);
      return localObject1;
      break label408;
    }
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    AppMethodBeat.i(107895);
    Type localType1 = paramType1;
    for (paramType1 = paramType2;; paramType1 = paramType1.getGenericComponentType())
    {
      if (localType1 == paramType1)
      {
        AppMethodBeat.o(107895);
        return true;
      }
      if ((localType1 instanceof Class))
      {
        boolean bool = localType1.equals(paramType1);
        AppMethodBeat.o(107895);
        return bool;
      }
      if ((localType1 instanceof ParameterizedType))
      {
        if (!(paramType1 instanceof ParameterizedType))
        {
          AppMethodBeat.o(107895);
          return false;
        }
        paramType2 = (ParameterizedType)localType1;
        paramType1 = (ParameterizedType)paramType1;
        localType1 = paramType2.getOwnerType();
        Type localType2 = paramType1.getOwnerType();
        if ((localType1 == localType2) || ((localType1 != null) && (localType1.equals(localType2)))) {}
        for (int i = 1; (i != 0) && (paramType2.getRawType().equals(paramType1.getRawType())) && (Arrays.equals(paramType2.getActualTypeArguments(), paramType1.getActualTypeArguments())); i = 0)
        {
          AppMethodBeat.o(107895);
          return true;
        }
        AppMethodBeat.o(107895);
        return false;
      }
      if (!(localType1 instanceof GenericArrayType)) {
        break;
      }
      if (!(paramType1 instanceof GenericArrayType))
      {
        AppMethodBeat.o(107895);
        return false;
      }
      paramType2 = (GenericArrayType)localType1;
      paramType1 = (GenericArrayType)paramType1;
      localType1 = paramType2.getGenericComponentType();
    }
    if ((localType1 instanceof WildcardType))
    {
      if (!(paramType1 instanceof WildcardType))
      {
        AppMethodBeat.o(107895);
        return false;
      }
      paramType2 = (WildcardType)localType1;
      paramType1 = (WildcardType)paramType1;
      if ((Arrays.equals(paramType2.getUpperBounds(), paramType1.getUpperBounds())) && (Arrays.equals(paramType2.getLowerBounds(), paramType1.getLowerBounds())))
      {
        AppMethodBeat.o(107895);
        return true;
      }
      AppMethodBeat.o(107895);
      return false;
    }
    if ((localType1 instanceof TypeVariable))
    {
      if (!(paramType1 instanceof TypeVariable))
      {
        AppMethodBeat.o(107895);
        return false;
      }
      paramType2 = (TypeVariable)localType1;
      paramType1 = (TypeVariable)paramType1;
      if ((paramType2.getGenericDeclaration() == paramType1.getGenericDeclaration()) && (paramType2.getName().equals(paramType1.getName())))
      {
        AppMethodBeat.o(107895);
        return true;
      }
      AppMethodBeat.o(107895);
      return false;
    }
    AppMethodBeat.o(107895);
    return false;
  }
  
  static int ak(Object paramObject)
  {
    AppMethodBeat.i(107896);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(107896);
      return i;
    }
    AppMethodBeat.o(107896);
    return 0;
  }
  
  public static Type b(Type paramType)
  {
    AppMethodBeat.i(107893);
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray()) {
        paramType = new a(b(paramType.getComponentType()));
      }
      for (;;)
      {
        paramType = (Type)paramType;
        AppMethodBeat.o(107893);
        return paramType;
      }
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      paramType = new b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
      AppMethodBeat.o(107893);
      return paramType;
    }
    if ((paramType instanceof GenericArrayType))
    {
      paramType = new a(((GenericArrayType)paramType).getGenericComponentType());
      AppMethodBeat.o(107893);
      return paramType;
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      paramType = new c(paramType.getUpperBounds(), paramType.getLowerBounds());
      AppMethodBeat.o(107893);
      return paramType;
    }
    AppMethodBeat.o(107893);
    return paramType;
  }
  
  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(107899);
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    a.checkArgument(paramClass2.isAssignableFrom(paramClass1));
    paramType = a(localType, paramClass1, a(localType, paramClass1, paramClass2));
    AppMethodBeat.o(107899);
    return paramType;
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    AppMethodBeat.i(107902);
    if (paramType == Properties.class)
    {
      AppMethodBeat.o(107902);
      return new Type[] { String.class, String.class };
    }
    paramType = b(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      AppMethodBeat.o(107902);
      return paramType;
    }
    AppMethodBeat.o(107902);
    return new Type[] { Object.class, Object.class };
  }
  
  public static Class<?> c(Type paramType)
  {
    AppMethodBeat.i(107894);
    for (;;)
    {
      if ((paramType instanceof Class))
      {
        paramType = (Class)paramType;
        AppMethodBeat.o(107894);
        return paramType;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        a.checkArgument(paramType instanceof Class);
        paramType = (Class)paramType;
        AppMethodBeat.o(107894);
        return paramType;
      }
      if ((paramType instanceof GenericArrayType))
      {
        paramType = Array.newInstance(c(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
        AppMethodBeat.o(107894);
        return paramType;
      }
      if ((paramType instanceof TypeVariable))
      {
        AppMethodBeat.o(107894);
        return Object.class;
      }
      if (!(paramType instanceof WildcardType)) {
        break;
      }
      paramType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName())
    {
      paramType = new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
      AppMethodBeat.o(107894);
      throw paramType;
    }
  }
  
  public static String d(Type paramType)
  {
    AppMethodBeat.i(107897);
    if ((paramType instanceof Class))
    {
      paramType = ((Class)paramType).getName();
      AppMethodBeat.o(107897);
      return paramType;
    }
    paramType = paramType.toString();
    AppMethodBeat.o(107897);
    return paramType;
  }
  
  public static Type e(Type paramType)
  {
    AppMethodBeat.i(107900);
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      AppMethodBeat.o(107900);
      return paramType;
    }
    paramType = ((Class)paramType).getComponentType();
    AppMethodBeat.o(107900);
    return paramType;
  }
  
  static void f(Type paramType)
  {
    AppMethodBeat.i(107905);
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive())) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      AppMethodBeat.o(107905);
      return;
    }
  }
  
  static final class a
    implements Serializable, GenericArrayType
  {
    private final Type bNE;
    
    public a(Type paramType)
    {
      AppMethodBeat.i(107976);
      this.bNE = b.b(paramType);
      AppMethodBeat.o(107976);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107977);
      if (((paramObject instanceof GenericArrayType)) && (b.a(this, (GenericArrayType)paramObject)))
      {
        AppMethodBeat.o(107977);
        return true;
      }
      AppMethodBeat.o(107977);
      return false;
    }
    
    public final Type getGenericComponentType()
    {
      return this.bNE;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(107978);
      int i = this.bNE.hashCode();
      AppMethodBeat.o(107978);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(107979);
      String str = b.d(this.bNE) + "[]";
      AppMethodBeat.o(107979);
      return str;
    }
  }
  
  static final class b
    implements Serializable, ParameterizedType
  {
    private final Type bNF;
    private final Type bNG;
    private final Type[] bNH;
    
    public b(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      AppMethodBeat.i(107944);
      int i;
      boolean bool;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null))
        {
          i = 1;
          if ((paramType1 == null) && (i == 0)) {
            break label164;
          }
          bool = true;
          label59:
          a.checkArgument(bool);
        }
      }
      else
      {
        if (paramType1 != null) {
          break label170;
        }
      }
      label164:
      label170:
      for (paramType1 = null;; paramType1 = b.b(paramType1))
      {
        this.bNF = paramType1;
        this.bNG = b.b(paramType2);
        this.bNH = ((Type[])paramVarArgs.clone());
        int k = this.bNH.length;
        i = j;
        while (i < k)
        {
          a.checkNotNull(this.bNH[i]);
          b.f(this.bNH[i]);
          paramType1 = this.bNH;
          paramType1[i] = b.b(paramType1[i]);
          i += 1;
        }
        i = 0;
        break;
        bool = false;
        break label59;
      }
      AppMethodBeat.o(107944);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107946);
      if (((paramObject instanceof ParameterizedType)) && (b.a(this, (ParameterizedType)paramObject)))
      {
        AppMethodBeat.o(107946);
        return true;
      }
      AppMethodBeat.o(107946);
      return false;
    }
    
    public final Type[] getActualTypeArguments()
    {
      AppMethodBeat.i(107945);
      Type[] arrayOfType = (Type[])this.bNH.clone();
      AppMethodBeat.o(107945);
      return arrayOfType;
    }
    
    public final Type getOwnerType()
    {
      return this.bNF;
    }
    
    public final Type getRawType()
    {
      return this.bNG;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(107947);
      int i = Arrays.hashCode(this.bNH);
      int j = this.bNG.hashCode();
      int k = b.ak(this.bNF);
      AppMethodBeat.o(107947);
      return i ^ j ^ k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(107948);
      int j = this.bNH.length;
      if (j == 0)
      {
        localObject = b.d(this.bNG);
        AppMethodBeat.o(107948);
        return localObject;
      }
      Object localObject = new StringBuilder((j + 1) * 30);
      ((StringBuilder)localObject).append(b.d(this.bNG)).append("<").append(b.d(this.bNH[0]));
      int i = 1;
      while (i < j)
      {
        ((StringBuilder)localObject).append(", ").append(b.d(this.bNH[i]));
        i += 1;
      }
      localObject = ">";
      AppMethodBeat.o(107948);
      return localObject;
    }
  }
  
  static final class c
    implements Serializable, WildcardType
  {
    private final Type bNI;
    private final Type bNJ;
    
    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      AppMethodBeat.i(107981);
      if (paramArrayOfType2.length <= 1)
      {
        bool1 = true;
        a.checkArgument(bool1);
        if (paramArrayOfType1.length != 1) {
          break label97;
        }
        bool1 = true;
        label32:
        a.checkArgument(bool1);
        if (paramArrayOfType2.length != 1) {
          break label107;
        }
        a.checkNotNull(paramArrayOfType2[0]);
        b.f(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          break label102;
        }
      }
      label97:
      label102:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a.checkArgument(bool1);
        this.bNJ = b.b(paramArrayOfType2[0]);
        this.bNI = Object.class;
        AppMethodBeat.o(107981);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label32;
      }
      label107:
      a.checkNotNull(paramArrayOfType1[0]);
      b.f(paramArrayOfType1[0]);
      this.bNJ = null;
      this.bNI = b.b(paramArrayOfType1[0]);
      AppMethodBeat.o(107981);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107982);
      if (((paramObject instanceof WildcardType)) && (b.a(this, (WildcardType)paramObject)))
      {
        AppMethodBeat.o(107982);
        return true;
      }
      AppMethodBeat.o(107982);
      return false;
    }
    
    public final Type[] getLowerBounds()
    {
      if (this.bNJ != null) {
        return new Type[] { this.bNJ };
      }
      return b.bND;
    }
    
    public final Type[] getUpperBounds()
    {
      return new Type[] { this.bNI };
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(107983);
      if (this.bNJ != null) {}
      for (int i = this.bNJ.hashCode() + 31;; i = 1)
      {
        int j = this.bNI.hashCode();
        AppMethodBeat.o(107983);
        return i ^ j + 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(107984);
      if (this.bNJ != null)
      {
        str = "? super " + b.d(this.bNJ);
        AppMethodBeat.o(107984);
        return str;
      }
      if (this.bNI == Object.class)
      {
        AppMethodBeat.o(107984);
        return "?";
      }
      String str = "? extends " + b.d(this.bNI);
      AppMethodBeat.o(107984);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.b
 * JD-Core Version:    0.7.0.1
 */