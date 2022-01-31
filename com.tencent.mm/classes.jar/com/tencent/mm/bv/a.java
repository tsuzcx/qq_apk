package com.tencent.mm.bv;

import java.io.OutputStream;

public class a
{
  protected static final int OPCODE_COMPUTESIZE = 1;
  protected static final int OPCODE_PARSEFROM = 2;
  protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
  protected static final int OPCODE_WRITEFIELDS = 0;
  public static d.a.a.a.a.b unknownTagHandler = new d.a.a.a.a.a();
  
  public static int a(d.a.a.a.a parama)
  {
    int i = 0;
    d.a.a.b.a.a locala = parama.xpH;
    if ((locala.aUB == locala.bufferSize) && (!locala.oz(false))) {
      locala.aUC = 0;
    }
    for (;;)
    {
      parama.xpI = i;
      return d.a.a.b.a.dU(parama.xpI);
      locala.aUC = locala.oD();
      if (locala.aUC == 0) {
        throw d.a.a.b.a.b.cUx();
      }
      i = locala.aUC;
    }
  }
  
  public int a(int paramInt, Object... paramVarArgs)
  {
    throw new Error("Cannot use this method");
  }
  
  public void a(d.a.a.c.a parama)
  {
    a(0, new Object[] { parama });
  }
  
  public boolean a(d.a.a.a.a parama, a parama1, int paramInt)
  {
    return a(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0;
  }
  
  public a aH(byte[] paramArrayOfByte)
  {
    a(2, new Object[] { paramArrayOfByte });
    return this;
  }
  
  public int btq()
  {
    try
    {
      int i = a(1, new Object[0]);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public a btr()
  {
    return this;
  }
  
  public byte[] toByteArray()
  {
    btr();
    byte[] arrayOfByte = new byte[btq()];
    d.a.a.c.a locala = new d.a.a.c.a(arrayOfByte);
    a(locala);
    if (locala.eca != null)
    {
      locala.eca.write(locala.xpN);
      locala.eca.flush();
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.a
 * JD-Core Version:    0.7.0.1
 */