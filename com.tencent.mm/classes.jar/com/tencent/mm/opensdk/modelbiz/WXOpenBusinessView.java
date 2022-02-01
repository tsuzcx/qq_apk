package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXOpenBusinessView
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXOpenBusinessView.Req";
    public String businessType;
    public String extInfo;
    public String query;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3875);
      if (d.b(this.businessType))
      {
        Log.e("MicroMsg.SDK.WXOpenBusinessView.Req", "businessType is null");
        AppMethodBeat.o(3875);
        return false;
      }
      AppMethodBeat.o(3875);
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3877);
      super.fromBundle(paramBundle);
      this.businessType = paramBundle.getString("_openbusinessview_businessType");
      this.query = paramBundle.getString("_openbusinessview__query_info");
      this.extInfo = paramBundle.getString("_openbusinessview_extInfo");
      AppMethodBeat.o(3877);
    }
    
    public final int getType()
    {
      return 26;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3876);
      super.toBundle(paramBundle);
      paramBundle.putString("_openbusinessview_businessType", this.businessType);
      paramBundle.putString("_openbusinessview__query_info", this.query);
      paramBundle.putString("_openbusinessview_extInfo", this.extInfo);
      AppMethodBeat.o(3876);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String businessType;
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3898);
      fromBundle(paramBundle);
      AppMethodBeat.o(3898);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3899);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_openbusinessview_ext_msg");
      this.businessType = paramBundle.getString("_openbusinessview_business_type");
      AppMethodBeat.o(3899);
    }
    
    public final int getType()
    {
      return 26;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3900);
      super.toBundle(paramBundle);
      paramBundle.putString("_openbusinessview_ext_msg", this.extMsg);
      paramBundle.putString("_openbusinessview_business_type", this.businessType);
      AppMethodBeat.o(3900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView
 * JD-Core Version:    0.7.0.1
 */