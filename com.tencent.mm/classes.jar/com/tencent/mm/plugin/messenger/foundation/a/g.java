package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.vending.b.b;

public abstract interface g
  extends a
{
  public abstract b addContactAssembler(f paramf);
  
  public abstract void processModContact(dph paramdph, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.g
 * JD-Core Version:    0.7.0.1
 */