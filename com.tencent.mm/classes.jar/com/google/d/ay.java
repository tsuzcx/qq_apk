package com.google.d;

import java.lang.reflect.Field;

final class ay
  implements Comparable<ay>
{
  final Field dEn;
  final ba dQa;
  final Class<?> dQb;
  final int dQc;
  final Field dQd;
  final int dQe;
  final boolean dQf;
  final boolean dQg;
  final cr dQh;
  final Field dQi;
  final Class<?> dQj;
  final Object dQk;
  final bj.e dQl;
  
  private ay(Field paramField1, int paramInt1, ba paramba, Class<?> paramClass1, Field paramField2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, cr paramcr, Class<?> paramClass2, Object paramObject, bj.e parame, Field paramField3)
  {
    this.dEn = paramField1;
    this.dQa = paramba;
    this.dQb = paramClass1;
    this.dQc = paramInt1;
    this.dQd = paramField2;
    this.dQe = paramInt2;
    this.dQf = paramBoolean1;
    this.dQg = paramBoolean2;
    this.dQh = paramcr;
    this.dQj = paramClass2;
    this.dQk = paramObject;
    this.dQl = parame;
    this.dQi = paramField3;
  }
  
  public static ay a(int paramInt, ba paramba, cr paramcr, Class<?> paramClass, boolean paramBoolean, bj.e parame)
  {
    lf(paramInt);
    bj.c(paramba, "fieldType");
    bj.c(paramcr, "oneof");
    bj.c(paramClass, "oneofStoredType");
    if (paramba.dRr == ba.a.dRy) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + paramInt + " is of type " + paramba);
    }
    return new ay(null, paramInt, paramba, null, null, 0, false, paramBoolean, paramcr, paramClass, null, parame, null);
  }
  
  public static ay a(Field paramField, int paramInt, ba paramba, bj.e parame)
  {
    lf(paramInt);
    bj.c(paramField, "field");
    return new ay(paramField, paramInt, paramba, null, null, 0, false, false, null, null, null, parame, null);
  }
  
  public static ay a(Field paramField1, int paramInt, ba paramba, bj.e parame, Field paramField2)
  {
    lf(paramInt);
    bj.c(paramField1, "field");
    return new ay(paramField1, paramInt, paramba, null, null, 0, false, false, null, null, null, parame, paramField2);
  }
  
  public static ay a(Field paramField, int paramInt, ba paramba, Class<?> paramClass)
  {
    lf(paramInt);
    bj.c(paramField, "field");
    bj.c(paramba, "fieldType");
    bj.c(paramClass, "messageClass");
    return new ay(paramField, paramInt, paramba, paramClass, null, 0, false, false, null, null, null, null, null);
  }
  
  public static ay a(Field paramField1, int paramInt, ba paramba, Field paramField2)
  {
    lf(paramInt);
    bj.c(paramField1, "field");
    bj.c(paramba, "fieldType");
    if ((paramba == ba.dQS) || (paramba == ba.dRo)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new ay(paramField1, paramInt, paramba, null, null, 0, false, false, null, null, null, null, paramField2);
  }
  
  public static ay a(Field paramField1, int paramInt1, ba paramba, Field paramField2, int paramInt2, boolean paramBoolean, bj.e parame)
  {
    lf(paramInt1);
    bj.c(paramField1, "field");
    bj.c(paramba, "fieldType");
    bj.c(paramField2, "presenceField");
    if ((paramField2 != null) && (!lg(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new ay(paramField1, paramInt1, paramba, null, paramField2, paramInt2, false, paramBoolean, null, null, null, parame, null);
  }
  
  public static ay a(Field paramField, int paramInt, ba paramba, boolean paramBoolean)
  {
    lf(paramInt);
    bj.c(paramField, "field");
    bj.c(paramba, "fieldType");
    if ((paramba == ba.dQS) || (paramba == ba.dRo)) {
      throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }
    return new ay(paramField, paramInt, paramba, null, null, 0, false, paramBoolean, null, null, null, null, null);
  }
  
  public static ay a(Field paramField, int paramInt, Object paramObject, bj.e parame)
  {
    bj.c(paramObject, "mapDefaultEntry");
    lf(paramInt);
    bj.c(paramField, "field");
    return new ay(paramField, paramInt, ba.dRp, null, null, 0, false, true, null, null, paramObject, parame, null);
  }
  
  public static ay b(Field paramField1, int paramInt1, ba paramba, Field paramField2, int paramInt2, boolean paramBoolean, bj.e parame)
  {
    lf(paramInt1);
    bj.c(paramField1, "field");
    bj.c(paramba, "fieldType");
    bj.c(paramField2, "presenceField");
    if ((paramField2 != null) && (!lg(paramInt2))) {
      throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(paramInt2)));
    }
    return new ay(paramField1, paramInt1, paramba, null, paramField2, paramInt2, true, paramBoolean, null, null, null, parame, null);
  }
  
  private static void lf(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("fieldNumber must be positive: ".concat(String.valueOf(paramInt)));
    }
  }
  
  private static boolean lg(int paramInt)
  {
    return (paramInt != 0) && ((paramInt - 1 & paramInt) == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ay
 * JD-Core Version:    0.7.0.1
 */