package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.SecureCtrItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class KindaSecureCtrItemImpl
  implements SecureCtrItem
{
  private String rawValue;
  
  public String getValue()
  {
    AppMethodBeat.i(18656);
    String str = new Encrypt().desedeEncode(this.rawValue);
    AppMethodBeat.o(18656);
    return str;
  }
  
  public void setRawValue(String paramString)
  {
    this.rawValue = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaSecureCtrItemImpl
 * JD-Core Version:    0.7.0.1
 */