package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.vending.b.b;

public abstract interface e
  extends a
{
  public abstract b addContactAssembler(d paramd);
  
  public abstract void processModContact(cpl paramcpl, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.e
 * JD-Core Version:    0.7.0.1
 */