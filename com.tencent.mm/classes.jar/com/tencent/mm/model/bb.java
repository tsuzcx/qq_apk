package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;

public final class bb
{
  public static SharedPreferences asa()
  {
    AppMethodBeat.i(132249);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("auth_info_key_prefs", g.XN());
    if (!localSharedPreferences.getBoolean("key_auth_info_prefs_created", false))
    {
      e.vIY.idkeyStat(148L, 12L, 1L, true);
      Object localObject = new aa(ae.FfH + "autoauth.cfg");
      if ((!((aa)localObject).Ffl) && (((aa)localObject).get(3) != null))
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", ((Integer)((aa)localObject).get(1)).intValue());
        localEditor.putInt("_auth_uin", ((Integer)((aa)localObject).get(2)).intValue());
        localEditor.putString("_auth_key", (String)((aa)localObject).get(3));
        localEditor.putString("server_id", (String)((aa)localObject).get(4));
        ad.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
        e.vIY.idkeyStat(148L, 51L, 1L, true);
        AppMethodBeat.o(132249);
        return localSharedPreferences;
      }
      localObject = aj.getContext().getSharedPreferences("auto_auth_key_prefs", g.XN());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (bt.isNullOrNil(((SharedPreferences)localObject).getString("_auth_key", ""))) {
        break label525;
      }
      localEditor.putBoolean("key_auth_info_prefs_created", true);
      localEditor.putInt("key_auth_update_version", ((SharedPreferences)localObject).getInt("key_auth_update_version", 0));
      localEditor.putInt("_auth_uin", ((SharedPreferences)localObject).getInt("_auth_uin", 0));
      localEditor.putString("_auth_key", ((SharedPreferences)localObject).getString("_auth_key", ""));
      localEditor.putString("server_id", aj.getContext().getSharedPreferences("server_id_prefs", g.XN()).getString("server_id", ""));
      ad.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
    }
    for (;;)
    {
      AppMethodBeat.o(132249);
      return localSharedPreferences;
      label525:
      ad.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", new Object[] { bt.eGN() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bb
 * JD-Core Version:    0.7.0.1
 */