package com.google.a;

import java.lang.reflect.Field;

final class w
  implements Comparable<w>
{
  final Field bUo;
  final y bUp;
  final Class<?> bUq;
  final int bUr;
  final Field bUs;
  final int bUt;
  final boolean bUu;
  final bi bUv;
  final Field bUw;
  final Class<?> bUx;
  final Object bUy;
  final ae.c bUz;
  final boolean required;
  
  private w(Field paramField1, int paramInt1, y paramy, Class<?> paramClass1, Field paramField2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, bi parambi, Class<?> paramClass2, Object paramObject, ae.c paramc, Field paramField3)
  {
    this.bUo = paramField1;
    this.bUp = paramy;
    this.bUq = paramClass1;
    this.bUr = paramInt1;
    this.bUs = paramField2;
    this.bUt = paramInt2;
    this.required = paramBoolean1;
    this.bUu = paramBoolean2;
    this.bUv = parambi;
    this.bUx = paramClass2;
    this.bUy = paramObject;
    this.bUz = paramc;
    this.bUw = paramField3;
  }
  
  public static w a(int paramInt, y paramy, bi parambi, Class<?> paramClass, boolean paramBoolean, ae.c paramc)
  {
    gC(paramInt);
    ae.checkNotNull(paramy, "fieldType");
    ae.checkNotNull(parambi, "oneof");
    ae.checkNotNull(paramClass, "oneofStoredType");
    if (paramy.bVH == y.a.bVO) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + paramInt + " is of type " + paramy);
    }
    return new w(null, paramInt, paramy, null, null, 0, false, paramBoolean, parambi, paramClass, null, paramc, null);
  }
  
  public static w a(Field paramField, int paramInt, y paramy, ae.c paramc)
  {
    gC(paramInt);
    ae.checkNotNull(paramField, "field");
    return new w(paramField, paramInt, paramy, null, null, 0, false, false, null, null, null, paramc, null);
  }
  
  public static w a(Field paramField1, int paramInt, y paramy, ae.c paramc, Field paramField2)
  {
    gC(paramInt);
    ae.checkNotNull(paramField1, "field");
    return new w(paramField1, paramInt, paramy, null, null, 0, false, false, null, null, null, paramc, paramField2);
  }
  
  public static w a(Field paramField, int paramInt, y paramy, Class<?> paramClass)
  {
    gC(paramInt);
    ae.checkNotNull(paramField, "field");
    ae.checkNotNull(paramy, "fieldType");
    ae.checkNotNull(paramClass, "messageClass");
    return new w(paramField, paramInt, paramy, paramClass, null, 0, false, false, null, null, null, null, null);
  }
  
  public static w a(Field paramField1, int paramInt, y paramy, Field paramField2)
  {
    gC(paramInt);
    ae.checkNotNull(paramField1, "field");
    ae.checkNotNull(paramy, "fieldType");
    if ((paramy == y.bVi) || (paramy == y.bVE)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new w(paramField1, paramInt, paramy, null, null, 0, false, false, null, null, null, null, paramField2);
  }
  
  public static w a(Field paramField1, int paramInt1, y paramy, Field paramField2, int paramInt2, boolean paramBoolean, ae.c paramc)
  {
    gC(paramInt1);
    ae.checkNotNull(paramField1, "field");
    ae.checkNotNull(paramy, "fieldType");
    ae.checkNotNull(paramField2, "presenceField");
    if ((paramField2 != null) && (!gD(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new w(paramField1, paramInt1, paramy, null, paramField2, paramInt2, false, paramBoolean, null, null, null, paramc, null);
  }
  
  public static w a(Field paramField, int paramInt, y paramy, boolean paramBoolean)
  {
    gC(paramInt);
    ae.checkNotNull(paramField, "field");
    ae.checkNotNull(paramy, "fieldType");
    if ((paramy == y.bVi) || (paramy == y.bVE)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new w(paramField, paramInt, paramy, null, null, 0, false, paramBoolean, null, null, null, null, null);
  }
  
  public static w a(Field paramField, int paramInt, Object paramObject, ae.c paramc)
  {
    ae.checkNotNull(paramObject, "mapDefaultEntry");
    gC(paramInt);
    ae.checkNotNull(paramField, "field");
    return new w(paramField, paramInt, y.bVF, null, null, 0, false, true, null, null, paramObject, paramc, null);
  }
  
  public static w b(Field paramField1, int paramInt1, y paramy, Field paramField2, int paramInt2, boolean paramBoolean, ae.c paramc)
  {
    gC(paramInt1);
    ae.checkNotNull(paramField1, "field");
    ae.checkNotNull(paramy, "fieldType");
    ae.checkNotNull(paramField2, "presenceField");
    if ((paramField2 != null) && (!gD(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new w(paramField1, paramInt1, paramy, null, paramField2, paramInt2, true, paramBoolean, null, null, null, paramc, null);
  }
  
  private static void gC(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("fieldNumber must be positive: ".concat(String.valueOf(paramInt)));
    }
  }
  
  private static boolean gD(int paramInt)
  {
    return (paramInt != 0) && ((paramInt - 1 & paramInt) == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.w
 * JD-Core Version:    0.7.0.1
 */