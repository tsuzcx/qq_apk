package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

final class s
{
  public static boolean a(String paramString, o paramo, c paramc, b paramb, k paramk, aa paramaa, ag paramag, t paramt, y paramy, ad paramad, x paramx1, a parama, x paramx2)
  {
    AppMethodBeat.i(155743);
    try
    {
      ae.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(paramString)));
      Map localMap = bx.M(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        ae.i("MicroMsg.DeviceInfoParser", "hy: null device config");
        AppMethodBeat.o(155743);
        return false;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv7") != null)
      {
        paramo.gcw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
        paramo.gcv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv6") != null)
      {
        paramo.gcx = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
        paramo.gcv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.num") != null)
      {
        paramc.gag = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.num"), 0);
        paramc.gah = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.surface") != null)
      {
        paramc.gai = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.surface"), 0);
        paramc.gaj = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.format") != null)
      {
        paramc.gam = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.format"), 0);
        paramc.bin = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
        paramc.gak = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
        paramc.gal = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.enable") != null)
      {
        paramc.gaq.gaV = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.fps") != null)
      {
        paramc.gaq.fps = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.orien") != null)
      {
        paramc.gaq.gaW = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.rotate") != null)
      {
        paramc.gaq.dHi = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.isleft") != null)
      {
        paramc.gaq.gaX = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.width") != null)
      {
        paramc.gaq.width = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.width"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.height") != null)
      {
        paramc.gaq.height = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.height"), 0);
        paramc.gar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.enable") != null)
      {
        paramc.gan.gaV = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.fps") != null)
      {
        paramc.gan.fps = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.orien") != null)
      {
        paramc.gan.gaW = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.rotate") != null)
      {
        paramc.gan.dHi = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.isleft") != null)
      {
        paramc.gan.gaX = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.width") != null)
      {
        paramc.gan.width = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.width"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.height") != null)
      {
        paramc.gan.height = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.height"), 0);
        paramc.gao = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null)
      {
        paramc.gat = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null)
      {
        paramc.gau = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null)
      {
        paramc.gav = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null)
      {
        paramc.gaw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.gax = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.gay = true;
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.gaA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.gaz = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
        paramc.gaB = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
        paramc.gaC = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
        paramc.gaO = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.focusType") != null) {
        paramc.gaP = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.focusType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.gax = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.gay = true;
        paramc.gas = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.gaA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.gaz = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
        paramc.gaD = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
        paramc.gaE = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
        paramc.gaF = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
        paramc.gaG = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
        paramc.gaH = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
        paramc.gaI = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
        paramc.gaK = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
        paramc.gaL = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
        paramc.gaM = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
        paramc.gaN = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
        paramc.gaQ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
        paramc.gaR = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
        paramc.gaS = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
        paramc.gaT = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
        paramc.gaU = bu.getBoolean((String)localMap.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.streamtype") != null)
      {
        paramb.fYo = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.smode") != null)
      {
        paramb.fYp = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.smode"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.omode") != null)
      {
        paramb.fYq = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.omode"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ospeaker") != null)
      {
        paramb.fYr = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.operating") != null)
      {
        paramb.fYs = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.operating"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.moperating") != null)
      {
        paramb.fYt = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.moperating"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mstreamtype") != null)
      {
        paramb.fYu = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
        paramb.fYn = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
        paramb.fYv = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fYw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
        paramb.fYx = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
        paramb.fYy = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.volummode") != null) {
        paramb.fYz = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.volummode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
        paramb.fYM = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.micmode") != null) {
        paramb.fYL = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.micmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
        paramb.fYN = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
        paramb.fYO = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
        paramb.fYP = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
        paramb.fYQ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
        paramb.fYR = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
        paramb.fYT = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
        paramb.fYU = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
        paramb.fYV = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
        paramb.fYW = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
        paramb.fYX = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
        paramb.fYY = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
        paramb.fYZ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
        paramb.fZa = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
        paramb.fZb = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
        paramb.fZc = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
        paramb.fZd = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
        paramb.fZe = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
        paramb.fZf = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
        paramb.fZg = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
        paramb.fZh = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
        paramb.fZi = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode") != null) {
        paramb.fZj = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain") != null) {
        paramb.fZk = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain") != null) {
        paramb.fZl = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain") != null) {
        paramb.fZm = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio") != null) {
        paramb.fZo = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR") != null) {
        paramb.fZp = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget") != null) {
        paramb.fZn = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase") != null) {
        paramb.fZq = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR") != null) {
        paramb.fZr = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR") != null) {
        paramb.fZs = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper") != null) {
        paramb.fZt = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
        paramb.fYA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
        paramb.fYB = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
        paramb.fYC = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
        paramb.fYD = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
        paramb.fYG = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
        paramb.fYH = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
        paramb.fYI = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
        paramb.fYJ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
        paramb.fZu = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
        paramb.fZv = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null)
      {
        paramb.fZx[0] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null)
      {
        paramb.fZx[1] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null)
      {
        paramb.fZx[2] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null)
      {
        paramb.fZx[3] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null)
      {
        paramb.fZx[4] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null)
      {
        paramb.fZx[5] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null)
      {
        paramb.fZx[6] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null)
      {
        paramb.fZx[7] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null)
      {
        paramb.fZx[8] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null)
      {
        paramb.fZx[9] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null)
      {
        paramb.fZx[10] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null)
      {
        paramb.fZx[11] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null)
      {
        paramb.fZx[12] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null)
      {
        paramb.fZx[13] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0));
        paramb.fZw = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null)
      {
        paramb.fZx[14] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0));
        paramb.fZw = 1;
      }
      if ((localMap.get(".deviceinfoconfig.voip.audio.correctoff") != null) && (bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1)) {
        paramb.fZw = 0;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
        paramb.fYE = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
        paramb.fYF = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
        paramb.fZy[0] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
        paramb.fZy[1] = ((short)bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
        paramb.fZI = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
        paramb.fZJ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
        paramb.fZK = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
        paramb.fZL = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
        paramb.fZA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
        paramb.fYK = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fYw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
        paramb.fZM = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
        paramb.fZN = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
        paramb.fZO = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
        paramb.fZP = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
        paramb.fZQ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
        paramb.fZR = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
        paramb.fZS = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
        paramb.fZT = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
        paramb.fZU = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
        paramb.fZV = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
        paramb.fZW = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
        paramb.fZX = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
        paramb.fZY = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
        paramb.fZZ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
        paramb.gaa = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
        paramb.gab = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
        paramb.gac = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
        paramb.gad = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
        paramb.gae = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
        paramb.gaf = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakermode") != null)
      {
        paramb.fZC = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonemode") != null)
      {
        paramb.fZD = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null)
      {
        paramb.fZE = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.streamtype") != null)
      {
        paramb.fZF = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null)
      {
        paramb.fZG = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null)
      {
        paramb.fZH = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
        paramb.fZB = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null)
      {
        paramk.gbi = true;
        paramk.gbj = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null) {
        paramk.gba = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
        paramk.gbb = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
        paramk.gbc = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
        paramk.gbe = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
        paramk.gbd = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
        paramk.gbf = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
        paramk.gbh = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
        paramk.gbg = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.app") != null) {
        paramk.gbk = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.app"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
        paramk.gbN = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
        paramk.gbO = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
        paramk.gbP = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
        paramk.gbQ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
        paramk.gbR = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv") != null) {
        paramk.gbS = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpucrop") != null) {
        paramk.gbT = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpucrop"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.vmfd") != null) {
        paramk.gbl = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vmfd"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
        paramk.gbm = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
        paramk.gbn = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
        paramk.gbo = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.linespe") != null) {
        paramk.gbp = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.linespe"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.fixspan") != null) {
        paramk.gbA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.fixspan"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideo") != null) {
        paramk.gbq = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideo"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
        paramk.gbr = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
        paramk.gbs = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
        paramk.gbv = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
        paramk.gbu = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.gbw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.gbx = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
        paramk.gbt = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.gbw = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.gbx = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.base") != null) {
        paramk.gbU = ((String)localMap.get(".deviceinfoconfig.voip.common.base"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
        paramk.gbV = ((String)localMap.get(".deviceinfoconfig.voip.common.packageinfo"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.classloader") != null) {
        paramk.gbW = ((String)localMap.get(".deviceinfoconfig.voip.common.classloader"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.resources") != null) {
        paramk.gbX = ((String)localMap.get(".deviceinfoconfig.voip.common.resources"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
        paramk.gby = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
        paramk.gbY = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
        paramk.gbZ = ((String)localMap.get(".deviceinfoconfig.voip.common.extpubdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
        paramk.gca = ((String)localMap.get(".deviceinfoconfig.voip.common.extdatadir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
        paramk.gcb = ((String)localMap.get(".deviceinfoconfig.voip.common.extrootdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
        paramk.gcc = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragestate"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
        paramk.gcd = ((String)localMap.get(".deviceinfoconfig.voip.common.extcachedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
        paramk.gbz = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
        paramk.gce = ((String)localMap.get(".deviceinfoconfig.voip.common.loadDrawable"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
        paramk.gcf = ((String)localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser"));
      }
      if ((localMap.get(".deviceinfoconfig.voip.common.sensorNearFar") != null) && (1 == bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0))) {
        com.tencent.mm.sdk.platformtools.SensorController.IAt = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
        com.tencent.mm.sdk.platformtools.SensorController.IAu = bu.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0D);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
        paramk.gcg = ((String)localMap.get(".deviceinfoconfig.voip.common.sightFullType"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
        paramk.gch = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
        paramk.gci = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
      }
      label8221:
      label8615:
      label8659:
      int i;
      int j;
      int k;
      if (localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null)
      {
        paramk.gcj = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
        if (paramk.gcj == 1)
        {
          bool = true;
          com.tencent.mm.compatible.g.b.cK(bool);
        }
      }
      else
      {
        if (localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
          paramk.gck = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
          paramk.gbB = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
          paramk.gbC = bu.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0D);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
          paramk.gcl = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
          paramk.gcm = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
          paramk.gcn = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
          paramk.gco = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
          paramk.gbD = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
          paramk.gbE = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
          paramk.gbF = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
          paramk.gbG = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
          paramk.gbH = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.gbI = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
          paramk.gbJ = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
          paramk.gbK = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
          paramk.gbL = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.gbM = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null)
        {
          if (bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) != 1) {
            break label10233;
          }
          bool = true;
          paramaa.gez = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
          paramaa.mVideoWidth = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
          paramaa.mVideoHeight = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
          paramaa.geA = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
          paramaa.geB = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
          paramaa.geC = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
          paramaa.geD = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
          paramaa.geE = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
          paramaa.geF = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
          paramaa.geG = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
          paramaa.geH = bu.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.notifythread") != null)
        {
          if (bu.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.notifythread"), 0) != 1) {
            break label10239;
          }
          bool = true;
          paramag.gfb = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null)
        {
          if (bu.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) != 1) {
            break label10245;
          }
          bool = true;
          paramag.gfc = bool;
          ae.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", new Object[] { Boolean.valueOf(paramag.gfc) });
          ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", paramag.gfc).commit();
        }
        paramk.dump();
        i = bu.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
        j = bu.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
        ae.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", new Object[] { Integer.valueOf(i) });
        if (paramt != null)
        {
          paramt.lu(i);
          paramt.lt(j);
        }
        k = bu.getInt((String)localMap.get(".deviceinfoconfig.soter.isSupport"), 0);
        ae.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", new Object[] { Integer.valueOf(k) });
        if (paramad != null)
        {
          if (k <= 0) {
            break label10251;
          }
          bool = true;
          label8857:
          paramad.cJ(bool);
          paramad.ly(k);
        }
        if ((i == 11) && (j == 11) && (paramad != null))
        {
          paramt.lu(1);
          paramt.lt(1);
          paramad.cJ(true);
          paramad.ly(1);
          paramad.abg();
          ae.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
        }
        paramo = (String)localMap.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
        ae.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", new Object[] { paramo });
        if (paramy != null) {
          paramy.vH(paramo);
        }
        paramString = bx.M(paramString, "manufacturerName");
        ae.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", new Object[] { paramString });
        if (paramy != null) {
          paramy.p(paramString);
        }
        i = bu.getInt((String)localMap.get(".deviceinfoconfig.style.swipback"), 0);
        ae.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", new Object[] { Integer.valueOf(i) });
        if (paramy != null) {
          paramy.lv(i);
        }
        i = bu.getInt((String)localMap.get(".deviceinfoconfig.game.isLimit"), 0);
        paramString = (String)localMap.get(".deviceinfoconfig.game.limitPrompt");
        ae.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", new Object[] { Integer.valueOf(i), paramString });
        if (parama != null) {
          if (i != 1) {
            break label10257;
          }
        }
      }
      label10245:
      label10251:
      label10257:
      for (boolean bool = true;; bool = false)
      {
        parama.cG(bool);
        parama.vA(paramString);
        i = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recordertype"), -1);
        j = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
        k = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
        int m = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
        int n = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
        int i1 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
        int i2 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
        int i3 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
        int i4 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useMetering"), -1);
        int i5 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
        int i6 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
        int i7 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
        int i8 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
        int i9 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
        int i10 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
        int i11 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
        int i12 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
        int i13 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
        int i14 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
        int i15 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
        int i16 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
        int i17 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
        int i18 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
        int i19 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
        int i20 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
        int i21 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
        int i22 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
        int i23 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
        int i24 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
        int i25 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CHwHevcEncodeEnable"), -1);
        int i26 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSHwHevcEncodeEnable"), -1);
        int i27 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CSwHevcEncodeEnable"), -1);
        int i28 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSSwHevcEncodeEnable"), -1);
        int i29 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CHwHevcEncodeEnable"), -1);
        int i30 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSHwHevcEncodeEnable"), -1);
        int i31 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CSwHevcEncodeEnable"), -1);
        int i32 = bu.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSSwHevcEncodeEnable"), -1);
        if (paramx1 != null)
        {
          paramx1.gdr = i;
          paramx1.gds = j;
          paramx1.gdt = k;
          paramx1.gdu = m;
          paramx1.gdv = n;
          paramx1.gdw = i1;
          paramx1.gdx = i2;
          paramx1.gdy = i3;
          paramx1.gdz = i4;
          paramx1.gdA = i5;
          paramx1.gdB = i6;
          paramx1.gdE = i10;
          paramx1.gdF = i11;
          paramx1.gdG = i12;
          paramx1.gdH = i13;
          paramx1.gdO = i14;
          paramx1.gdP = i15;
          paramx1.gdR = i16;
          paramx1.gdS = i17;
          paramx1.gdQ = i18;
          paramx1.gdI = i19;
          paramx1.gdJ = i20;
          paramx1.gdK = i21;
          paramx1.gdL = i22;
          paramx1.gdM = i23;
          paramx1.gdN = i24;
          paramx1.gdT = i25;
          paramx1.gdU = i26;
          paramx1.gdV = i27;
          paramx1.gdW = i28;
          paramx1.gdX = i29;
          paramx1.gdY = i30;
          paramx1.gdZ = i31;
          paramx1.gea = i32;
          ae.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", new Object[] { paramx1.toString() });
        }
        if (paramx2 != null)
        {
          paramx2.gdr = i8;
          paramx2.gds = j;
          paramx2.gdt = k;
          paramx2.gdu = m;
          paramx2.gdv = n;
          paramx2.gdw = i1;
          paramx2.gdx = i2;
          paramx2.gdy = i3;
          paramx2.gdz = i4;
          paramx2.gdA = i5;
          paramx2.gdB = i6;
          paramx2.gdC = i7;
          paramx2.gdD = i9;
          ae.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", new Object[] { paramx2.toString() });
        }
        AppMethodBeat.o(155743);
        return true;
        bool = false;
        break;
        label10233:
        bool = false;
        break label8221;
        label10239:
        bool = false;
        break label8615;
        bool = false;
        break label8659;
        bool = false;
        break label8857;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.DeviceInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(155743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.s
 * JD-Core Version:    0.7.0.1
 */