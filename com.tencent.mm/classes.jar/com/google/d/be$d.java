package com.google.d;

import java.io.Serializable;

public final class be$d
  implements Serializable
{
  private final Class<?> dQb;
  private final String dRU;
  private final byte[] dRV;
  
  be$d(ce paramce)
  {
    this.dQb = paramce.getClass();
    this.dRU = this.dQb.getName();
    this.dRV = paramce.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.d.be.d
 * JD-Core Version:    0.7.0.1
 */