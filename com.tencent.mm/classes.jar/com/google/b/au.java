package com.google.b;

import java.lang.reflect.Field;

final class au
  implements Comparable<au>
{
  final Field bKF;
  final aw bWm;
  final Class<?> bWn;
  final int bWo;
  final Field bWp;
  final int bWq;
  final boolean bWr;
  final boolean bWs;
  final ch bWt;
  final Field bWu;
  final Class<?> bWv;
  final Object bWw;
  final be.c bWx;
  
  private au(Field paramField1, int paramInt1, aw paramaw, Class<?> paramClass1, Field paramField2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, ch paramch, Class<?> paramClass2, Object paramObject, be.c paramc, Field paramField3)
  {
    this.bKF = paramField1;
    this.bWm = paramaw;
    this.bWn = paramClass1;
    this.bWo = paramInt1;
    this.bWp = paramField2;
    this.bWq = paramInt2;
    this.bWr = paramBoolean1;
    this.bWs = paramBoolean2;
    this.bWt = paramch;
    this.bWv = paramClass2;
    this.bWw = paramObject;
    this.bWx = paramc;
    this.bWu = paramField3;
  }
  
  public static au a(int paramInt, aw paramaw, ch paramch, Class<?> paramClass, boolean paramBoolean, be.c paramc)
  {
    hu(paramInt);
    be.c(paramaw, "fieldType");
    be.c(paramch, "oneof");
    be.c(paramClass, "oneofStoredType");
    if (paramaw.bXF == aw.a.bXM) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + paramInt + " is of type " + paramaw);
    }
    return new au(null, paramInt, paramaw, null, null, 0, false, paramBoolean, paramch, paramClass, null, paramc, null);
  }
  
  public static au a(Field paramField, int paramInt, aw paramaw, be.c paramc)
  {
    hu(paramInt);
    be.c(paramField, "field");
    return new au(paramField, paramInt, paramaw, null, null, 0, false, false, null, null, null, paramc, null);
  }
  
  public static au a(Field paramField1, int paramInt, aw paramaw, be.c paramc, Field paramField2)
  {
    hu(paramInt);
    be.c(paramField1, "field");
    return new au(paramField1, paramInt, paramaw, null, null, 0, false, false, null, null, null, paramc, paramField2);
  }
  
  public static au a(Field paramField, int paramInt, aw paramaw, Class<?> paramClass)
  {
    hu(paramInt);
    be.c(paramField, "field");
    be.c(paramaw, "fieldType");
    be.c(paramClass, "messageClass");
    return new au(paramField, paramInt, paramaw, paramClass, null, 0, false, false, null, null, null, null, null);
  }
  
  public static au a(Field paramField1, int paramInt, aw paramaw, Field paramField2)
  {
    hu(paramInt);
    be.c(paramField1, "field");
    be.c(paramaw, "fieldType");
    if ((paramaw == aw.bXg) || (paramaw == aw.bXC)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new au(paramField1, paramInt, paramaw, null, null, 0, false, false, null, null, null, null, paramField2);
  }
  
  public static au a(Field paramField1, int paramInt1, aw paramaw, Field paramField2, int paramInt2, boolean paramBoolean, be.c paramc)
  {
    hu(paramInt1);
    be.c(paramField1, "field");
    be.c(paramaw, "fieldType");
    be.c(paramField2, "presenceField");
    if ((paramField2 != null) && (!hv(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new au(paramField1, paramInt1, paramaw, null, paramField2, paramInt2, false, paramBoolean, null, null, null, paramc, null);
  }
  
  public static au a(Field paramField, int paramInt, aw paramaw, boolean paramBoolean)
  {
    hu(paramInt);
    be.c(paramField, "field");
    be.c(paramaw, "fieldType");
    if ((paramaw == aw.bXg) || (paramaw == aw.bXC)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new au(paramField, paramInt, paramaw, null, null, 0, false, paramBoolean, null, null, null, null, null);
  }
  
  public static au a(Field paramField, int paramInt, Object paramObject, be.c paramc)
  {
    be.c(paramObject, "mapDefaultEntry");
    hu(paramInt);
    be.c(paramField, "field");
    return new au(paramField, paramInt, aw.bXD, null, null, 0, false, true, null, null, paramObject, paramc, null);
  }
  
  public static au b(Field paramField1, int paramInt1, aw paramaw, Field paramField2, int paramInt2, boolean paramBoolean, be.c paramc)
  {
    hu(paramInt1);
    be.c(paramField1, "field");
    be.c(paramaw, "fieldType");
    be.c(paramField2, "presenceField");
    if ((paramField2 != null) && (!hv(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new au(paramField1, paramInt1, paramaw, null, paramField2, paramInt2, true, paramBoolean, null, null, null, paramc, null);
  }
  
  private static void hu(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("fieldNumber must be positive: ".concat(String.valueOf(paramInt)));
    }
  }
  
  private static boolean hv(int paramInt)
  {
    return (paramInt != 0) && ((paramInt - 1 & paramInt) == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.au
 * JD-Core Version:    0.7.0.1
 */