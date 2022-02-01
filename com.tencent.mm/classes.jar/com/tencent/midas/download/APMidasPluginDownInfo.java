package com.tencent.midas.download;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APMidasPluginDownInfo
{
  public String diff_md5 = "";
  public String down_url = "";
  public String full_url = "";
  public int fullsize = 0;
  public boolean is_force = false;
  public boolean is_split = false;
  public String name = "";
  public String new_md5_decode = "";
  public String new_md5_encode = "";
  public String old_md5 = "";
  public int size = 0;
  public String split_download_url;
  public int update_version = 0;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(252996);
    if (paramObject == null)
    {
      AppMethodBeat.o(252996);
      return false;
    }
    if (!(paramObject instanceof APMidasPluginDownInfo))
    {
      AppMethodBeat.o(252996);
      return false;
    }
    paramObject = (APMidasPluginDownInfo)paramObject;
    boolean bool = this.name.equals(paramObject.name);
    AppMethodBeat.o(252996);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(252998);
    if (this.name == null)
    {
      AppMethodBeat.o(252998);
      return 0;
    }
    int i = this.name.hashCode();
    AppMethodBeat.o(252998);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.download.APMidasPluginDownInfo
 * JD-Core Version:    0.7.0.1
 */