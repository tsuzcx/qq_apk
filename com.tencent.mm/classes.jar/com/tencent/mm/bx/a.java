package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.a.a.b;

public class a
{
  protected static final int OPCODE_COMPUTESIZE = 1;
  protected static final int OPCODE_PARSEFROM = 2;
  protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
  protected static final int OPCODE_WRITEFIELDS = 0;
  public static b unknownTagHandler;
  
  static
  {
    AppMethodBeat.i(2349);
    unknownTagHandler = new f.a.a.a.a.a();
    AppMethodBeat.o(2349);
  }
  
  public static int getNextFieldNumber(f.a.a.a.a parama)
  {
    AppMethodBeat.i(2351);
    int i = parama.fMp();
    AppMethodBeat.o(2351);
    return i;
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(2354);
    try
    {
      int i = op(1, new Object[0]);
      AppMethodBeat.o(2354);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(2354);
    }
    return 0;
  }
  
  protected int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2352);
    paramVarArgs = new Error("Cannot use this method");
    AppMethodBeat.o(2352);
    throw paramVarArgs;
  }
  
  public a parseFrom(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2355);
    op(2, new Object[] { paramArrayOfByte });
    AppMethodBeat.o(2355);
    return this;
  }
  
  public boolean populateBuilderWithField(f.a.a.a.a parama, a parama1, int paramInt)
  {
    AppMethodBeat.i(2356);
    if (op(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0)
    {
      AppMethodBeat.o(2356);
      return true;
    }
    AppMethodBeat.o(2356);
    return false;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(2350);
    validate();
    byte[] arrayOfByte = new byte[computeSize()];
    f.a.a.c.a locala = new f.a.a.c.a(arrayOfByte);
    writeFields(locala);
    locala.fMA();
    AppMethodBeat.o(2350);
    return arrayOfByte;
  }
  
  protected a validate()
  {
    return this;
  }
  
  public void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2353);
    op(0, new Object[] { parama });
    AppMethodBeat.o(2353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bx.a
 * JD-Core Version:    0.7.0.1
 */