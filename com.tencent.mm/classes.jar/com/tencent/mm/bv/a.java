package com.tencent.mm.bv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public class a
{
  protected static final int OPCODE_COMPUTESIZE = 1;
  protected static final int OPCODE_PARSEFROM = 2;
  protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
  protected static final int OPCODE_WRITEFIELDS = 0;
  public static e.a.a.a.a.b unknownTagHandler;
  
  static
  {
    AppMethodBeat.i(51815);
    unknownTagHandler = new e.a.a.a.a.a();
    AppMethodBeat.o(51815);
  }
  
  public static int getNextFieldNumber(e.a.a.a.a parama)
  {
    int i = 0;
    AppMethodBeat.i(51817);
    e.a.a.b.a.a locala = parama.CLY;
    if ((locala.bgR == locala.bufferSize) && (!locala.sK(false))) {
      locala.bgS = 0;
    }
    for (;;)
    {
      parama.CLZ = i;
      i = e.a.a.b.a.fa(parama.CLZ);
      AppMethodBeat.o(51817);
      return i;
      locala.bgS = locala.sl();
      if (locala.bgS == 0)
      {
        parama = e.a.a.b.a.b.eqW();
        AppMethodBeat.o(51817);
        throw parama;
      }
      i = locala.bgS;
    }
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(51820);
    try
    {
      int i = op(1, new Object[0]);
      AppMethodBeat.o(51820);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(51820);
    }
    return 0;
  }
  
  protected int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51818);
    paramVarArgs = new Error("Cannot use this method");
    AppMethodBeat.o(51818);
    throw paramVarArgs;
  }
  
  public a parseFrom(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51821);
    op(2, new Object[] { paramArrayOfByte });
    AppMethodBeat.o(51821);
    return this;
  }
  
  public boolean populateBuilderWithField(e.a.a.a.a parama, a parama1, int paramInt)
  {
    AppMethodBeat.i(51822);
    if (op(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0)
    {
      AppMethodBeat.o(51822);
      return true;
    }
    AppMethodBeat.o(51822);
    return false;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(51816);
    validate();
    byte[] arrayOfByte = new byte[computeSize()];
    e.a.a.c.a locala = new e.a.a.c.a(arrayOfByte);
    writeFields(locala);
    if (locala.output != null)
    {
      locala.output.write(locala.CMa);
      locala.output.flush();
    }
    AppMethodBeat.o(51816);
    return arrayOfByte;
  }
  
  protected a validate()
  {
    return this;
  }
  
  public void writeFields(e.a.a.c.a parama)
  {
    AppMethodBeat.i(51819);
    op(0, new Object[] { parama });
    AppMethodBeat.o(51819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.a
 * JD-Core Version:    0.7.0.1
 */