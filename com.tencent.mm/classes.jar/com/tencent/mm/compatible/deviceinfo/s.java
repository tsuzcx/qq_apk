package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

final class s
{
  public static boolean a(String paramString, o paramo, c paramc, b paramb, k paramk, aa paramaa, ag paramag, t paramt, y paramy, ad paramad, x paramx1, a parama, x paramx2)
  {
    AppMethodBeat.i(155743);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(paramString)));
      Map localMap = bw.M(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "hy: null device config");
        AppMethodBeat.o(155743);
        return false;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv7") != null)
      {
        paramo.gan = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
        paramo.gam = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv6") != null)
      {
        paramo.gao = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
        paramo.gam = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.num") != null)
      {
        paramc.fYa = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.num"), 0);
        paramc.fYb = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.surface") != null)
      {
        paramc.fYc = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.surface"), 0);
        paramc.fYd = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.format") != null)
      {
        paramc.fYg = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.format"), 0);
        paramc.bin = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
        paramc.fYe = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
        paramc.fYf = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.enable") != null)
      {
        paramc.fYj.fYO = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.fps") != null)
      {
        paramc.fYj.fps = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.orien") != null)
      {
        paramc.fYj.fYP = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.rotate") != null)
      {
        paramc.fYj.dGc = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.isleft") != null)
      {
        paramc.fYj.fYQ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.width") != null)
      {
        paramc.fYj.width = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.width"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.height") != null)
      {
        paramc.fYj.height = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.height"), 0);
        paramc.fYk = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.enable") != null)
      {
        paramc.fYh.fYO = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.fps") != null)
      {
        paramc.fYh.fps = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.orien") != null)
      {
        paramc.fYh.fYP = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.rotate") != null)
      {
        paramc.fYh.dGc = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.isleft") != null)
      {
        paramc.fYh.fYQ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.width") != null)
      {
        paramc.fYh.width = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.width"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.height") != null)
      {
        paramc.fYh.height = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.height"), 0);
        paramc.fYi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null)
      {
        paramc.fYm = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null)
      {
        paramc.fYn = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null)
      {
        paramc.fYo = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null)
      {
        paramc.fYp = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.fYq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.fYr = true;
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.fYt = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.fYs = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
        paramc.fYu = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
        paramc.fYv = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
        paramc.fYH = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.focusType") != null) {
        paramc.fYI = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.focusType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.fYq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.fYr = true;
        paramc.fYl = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.fYt = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.fYs = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
        paramc.fYw = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
        paramc.fYx = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
        paramc.fYy = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
        paramc.fYz = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
        paramc.fYA = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
        paramc.fYB = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
        paramc.fYD = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
        paramc.fYE = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
        paramc.fYF = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
        paramc.fYG = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
        paramc.fYJ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
        paramc.fYK = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
        paramc.fYL = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
        paramc.fYM = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
        paramc.fYN = bt.getBoolean((String)localMap.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.streamtype") != null)
      {
        paramb.fWi = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.smode") != null)
      {
        paramb.fWj = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.smode"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.omode") != null)
      {
        paramb.fWk = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.omode"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ospeaker") != null)
      {
        paramb.fWl = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.operating") != null)
      {
        paramb.fWm = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.operating"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.moperating") != null)
      {
        paramb.fWn = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.moperating"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mstreamtype") != null)
      {
        paramb.fWo = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
        paramb.fWh = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
        paramb.fWp = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fWq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
        paramb.fWr = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
        paramb.fWs = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.volummode") != null) {
        paramb.fWt = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.volummode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
        paramb.fWG = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.micmode") != null) {
        paramb.fWF = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.micmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
        paramb.fWH = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
        paramb.fWI = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
        paramb.fWJ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
        paramb.fWK = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
        paramb.fWL = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
        paramb.fWN = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
        paramb.fWO = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
        paramb.fWP = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
        paramb.fWQ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
        paramb.fWR = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
        paramb.fWS = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
        paramb.fWT = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
        paramb.fWU = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
        paramb.fWV = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
        paramb.fWW = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
        paramb.fWX = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
        paramb.fWY = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
        paramb.fWZ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
        paramb.fXa = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
        paramb.fXb = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
        paramb.fXc = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode") != null) {
        paramb.fXd = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain") != null) {
        paramb.fXe = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain") != null) {
        paramb.fXf = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain") != null) {
        paramb.fXg = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio") != null) {
        paramb.fXi = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR") != null) {
        paramb.fXj = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget") != null) {
        paramb.fXh = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase") != null) {
        paramb.fXk = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR") != null) {
        paramb.fXl = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR") != null) {
        paramb.fXm = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper") != null) {
        paramb.fXn = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
        paramb.fWu = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
        paramb.fWv = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
        paramb.fWw = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
        paramb.fWx = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
        paramb.fWA = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
        paramb.fWB = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
        paramb.fWC = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
        paramb.fWD = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
        paramb.fXo = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
        paramb.fXp = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null)
      {
        paramb.fXr[0] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null)
      {
        paramb.fXr[1] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null)
      {
        paramb.fXr[2] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null)
      {
        paramb.fXr[3] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null)
      {
        paramb.fXr[4] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null)
      {
        paramb.fXr[5] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null)
      {
        paramb.fXr[6] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null)
      {
        paramb.fXr[7] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null)
      {
        paramb.fXr[8] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null)
      {
        paramb.fXr[9] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null)
      {
        paramb.fXr[10] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null)
      {
        paramb.fXr[11] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null)
      {
        paramb.fXr[12] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null)
      {
        paramb.fXr[13] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0));
        paramb.fXq = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null)
      {
        paramb.fXr[14] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0));
        paramb.fXq = 1;
      }
      if ((localMap.get(".deviceinfoconfig.voip.audio.correctoff") != null) && (bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1)) {
        paramb.fXq = 0;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
        paramb.fWy = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
        paramb.fWz = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
        paramb.fXs[0] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
        paramb.fXs[1] = ((short)bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
        paramb.fXC = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
        paramb.fXD = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
        paramb.fXE = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
        paramb.fXF = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
        paramb.fXu = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
        paramb.fWE = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fWq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
        paramb.fXG = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
        paramb.fXH = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
        paramb.fXI = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
        paramb.fXJ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
        paramb.fXK = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
        paramb.fXL = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
        paramb.fXM = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
        paramb.fXN = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
        paramb.fXO = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
        paramb.fXP = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
        paramb.fXQ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
        paramb.fXR = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
        paramb.fXS = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
        paramb.fXT = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
        paramb.fXU = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
        paramb.fXV = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
        paramb.fXW = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
        paramb.fXX = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
        paramb.fXY = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
        paramb.fXZ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakermode") != null)
      {
        paramb.fXw = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonemode") != null)
      {
        paramb.fXx = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null)
      {
        paramb.fXy = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.streamtype") != null)
      {
        paramb.fXz = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null)
      {
        paramb.fXA = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null)
      {
        paramb.fXB = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
        paramb.fXv = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null)
      {
        paramk.fZb = true;
        paramk.fZc = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null) {
        paramk.fYT = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
        paramk.fYU = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
        paramk.fYV = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
        paramk.fYX = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
        paramk.fYW = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
        paramk.fYY = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
        paramk.fZa = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
        paramk.fYZ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.app") != null) {
        paramk.fZd = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.app"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
        paramk.fZG = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
        paramk.fZH = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
        paramk.fZI = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
        paramk.fZJ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
        paramk.fZK = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv") != null) {
        paramk.jKr = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpucrop") != null) {
        paramk.jLV = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpucrop"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.vmfd") != null) {
        paramk.fZe = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vmfd"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
        paramk.fZf = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
        paramk.fZg = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
        paramk.fZh = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.linespe") != null) {
        paramk.fZi = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.linespe"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.fixspan") != null) {
        paramk.fZt = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.fixspan"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideo") != null) {
        paramk.fZj = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideo"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
        paramk.fZk = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
        paramk.fZl = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
        paramk.fZo = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
        paramk.fZn = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.fZp = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.fZq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
        paramk.fZm = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.fZp = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.fZq = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.base") != null) {
        paramk.fZL = ((String)localMap.get(".deviceinfoconfig.voip.common.base"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
        paramk.fZM = ((String)localMap.get(".deviceinfoconfig.voip.common.packageinfo"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.classloader") != null) {
        paramk.fZN = ((String)localMap.get(".deviceinfoconfig.voip.common.classloader"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.resources") != null) {
        paramk.fZO = ((String)localMap.get(".deviceinfoconfig.voip.common.resources"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
        paramk.fZr = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
        paramk.fZP = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
        paramk.fZQ = ((String)localMap.get(".deviceinfoconfig.voip.common.extpubdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
        paramk.fZR = ((String)localMap.get(".deviceinfoconfig.voip.common.extdatadir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
        paramk.fZS = ((String)localMap.get(".deviceinfoconfig.voip.common.extrootdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
        paramk.fZT = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragestate"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
        paramk.fZU = ((String)localMap.get(".deviceinfoconfig.voip.common.extcachedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
        paramk.fZs = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
        paramk.fZV = ((String)localMap.get(".deviceinfoconfig.voip.common.loadDrawable"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
        paramk.fZW = ((String)localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser"));
      }
      if ((localMap.get(".deviceinfoconfig.voip.common.sensorNearFar") != null) && (1 == bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0))) {
        com.tencent.mm.sdk.platformtools.SensorController.Igi = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
        com.tencent.mm.sdk.platformtools.SensorController.Igj = bt.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0D);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
        paramk.fZX = ((String)localMap.get(".deviceinfoconfig.voip.common.sightFullType"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
        paramk.fZY = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
        paramk.fZZ = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
      }
      label8221:
      label8615:
      label8659:
      int i;
      int j;
      int k;
      if (localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null)
      {
        paramk.gaa = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
        if (paramk.gaa == 1)
        {
          bool = true;
          com.tencent.mm.compatible.g.b.cK(bool);
        }
      }
      else
      {
        if (localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
          paramk.gab = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
          paramk.fZu = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
          paramk.fZv = bt.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0D);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
          paramk.gac = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
          paramk.gad = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
          paramk.gae = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
          paramk.gaf = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
          paramk.fZw = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
          paramk.fZx = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
          paramk.fZy = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
          paramk.fZz = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
          paramk.fZA = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.fZB = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
          paramk.fZC = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
          paramk.fZD = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
          paramk.fZE = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.fZF = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null)
        {
          if (bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) != 1) {
            break label10233;
          }
          bool = true;
          paramaa.gcr = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
          paramaa.mVideoWidth = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
          paramaa.mVideoHeight = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
          paramaa.gcs = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
          paramaa.gct = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
          paramaa.gcu = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
          paramaa.gcv = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
          paramaa.gcw = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
          paramaa.gcx = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
          paramaa.gcy = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
          paramaa.gcz = bt.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.notifythread") != null)
        {
          if (bt.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.notifythread"), 0) != 1) {
            break label10239;
          }
          bool = true;
          paramag.gcT = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null)
        {
          if (bt.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) != 1) {
            break label10245;
          }
          bool = true;
          paramag.gcU = bool;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", new Object[] { Boolean.valueOf(paramag.gcU) });
          aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", paramag.gcU).commit();
        }
        paramk.dump();
        i = bt.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
        j = bt.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", new Object[] { Integer.valueOf(i) });
        if (paramt != null)
        {
          paramt.ls(i);
          paramt.lr(j);
        }
        k = bt.getInt((String)localMap.get(".deviceinfoconfig.soter.isSupport"), 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", new Object[] { Integer.valueOf(k) });
        if (paramad != null)
        {
          if (k <= 0) {
            break label10251;
          }
          bool = true;
          label8857:
          paramad.cJ(bool);
          paramad.lw(k);
        }
        if ((i == 11) && (j == 11) && (paramad != null))
        {
          paramt.ls(1);
          paramt.lr(1);
          paramad.cJ(true);
          paramad.lw(1);
          paramad.aaX();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
        }
        paramo = (String)localMap.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", new Object[] { paramo });
        if (paramy != null) {
          paramy.vl(paramo);
        }
        paramString = bw.M(paramString, "manufacturerName");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", new Object[] { paramString });
        if (paramy != null) {
          paramy.i(paramString);
        }
        i = bt.getInt((String)localMap.get(".deviceinfoconfig.style.swipback"), 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", new Object[] { Integer.valueOf(i) });
        if (paramy != null) {
          paramy.lt(i);
        }
        i = bt.getInt((String)localMap.get(".deviceinfoconfig.game.isLimit"), 0);
        paramString = (String)localMap.get(".deviceinfoconfig.game.limitPrompt");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", new Object[] { Integer.valueOf(i), paramString });
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
        parama.ve(paramString);
        i = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recordertype"), -1);
        j = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
        k = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
        int m = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
        int n = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
        int i1 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
        int i2 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
        int i3 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
        int i4 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useMetering"), -1);
        int i5 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
        int i6 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
        int i7 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
        int i8 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
        int i9 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
        int i10 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
        int i11 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
        int i12 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
        int i13 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
        int i14 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
        int i15 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
        int i16 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
        int i17 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
        int i18 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
        int i19 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
        int i20 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
        int i21 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
        int i22 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
        int i23 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
        int i24 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
        int i25 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CHwHevcEncodeEnable"), -1);
        int i26 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSHwHevcEncodeEnable"), -1);
        int i27 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CSwHevcEncodeEnable"), -1);
        int i28 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSSwHevcEncodeEnable"), -1);
        int i29 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CHwHevcEncodeEnable"), -1);
        int i30 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSHwHevcEncodeEnable"), -1);
        int i31 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CSwHevcEncodeEnable"), -1);
        int i32 = bt.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSSwHevcEncodeEnable"), -1);
        if (paramx1 != null)
        {
          paramx1.gbj = i;
          paramx1.gbk = j;
          paramx1.gbl = k;
          paramx1.gbm = m;
          paramx1.gbn = n;
          paramx1.gbo = i1;
          paramx1.gbp = i2;
          paramx1.gbq = i3;
          paramx1.gbr = i4;
          paramx1.gbs = i5;
          paramx1.gbt = i6;
          paramx1.gbw = i10;
          paramx1.gbx = i11;
          paramx1.gby = i12;
          paramx1.gbz = i13;
          paramx1.gbG = i14;
          paramx1.gbH = i15;
          paramx1.gbJ = i16;
          paramx1.gbK = i17;
          paramx1.gbI = i18;
          paramx1.gbA = i19;
          paramx1.gbB = i20;
          paramx1.gbC = i21;
          paramx1.gbD = i22;
          paramx1.gbE = i23;
          paramx1.gbF = i24;
          paramx1.gbL = i25;
          paramx1.gbM = i26;
          paramx1.gbN = i27;
          paramx1.gbO = i28;
          paramx1.gbP = i29;
          paramx1.gbQ = i30;
          paramx1.gbR = i31;
          paramx1.gbS = i32;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", new Object[] { paramx1.toString() });
        }
        if (paramx2 != null)
        {
          paramx2.gbj = i8;
          paramx2.gbk = j;
          paramx2.gbl = k;
          paramx2.gbm = m;
          paramx2.gbn = n;
          paramx2.gbo = i1;
          paramx2.gbp = i2;
          paramx2.gbq = i3;
          paramx2.gbr = i4;
          paramx2.gbs = i5;
          paramx2.gbt = i6;
          paramx2.gbu = i7;
          paramx2.gbv = i9;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", new Object[] { paramx2.toString() });
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
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeviceInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(155743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.s
 * JD-Core Version:    0.7.0.1
 */